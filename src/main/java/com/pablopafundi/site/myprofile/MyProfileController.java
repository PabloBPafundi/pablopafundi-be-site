package com.pablopafundi.site.myprofile;


import com.pablopafundi.site.common.domain.LanguageEnum;
import jakarta.validation.Valid;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

@RestController
public class MyProfileController {

    private final MyProfileService myProfileService;

    public MyProfileController(MyProfileService myProfileService) {
        this.myProfileService = myProfileService;
    }

    // ENDPOINT PARA SUBIR UNA IMAGEN
    @PostMapping("/upload-image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        myProfileService.uploadProfileImage(file);
        return ResponseEntity.ok("Image upload");
    }

    // ENDPOIN PARA OBTENER IMAGEN
    @GetMapping("/public/images/{filename}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) throws IOException {
        // Ruta completa del archivo en el sistema de archivos
        File file = new File("src/main/resources/public/images/" + filename);

        if (!file.exists()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Resource image = new FileSystemResource(file);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                .body(image);
    }


    // ENDPOINT PARA OBTENER EL PERFIL COMPLETO
    @GetMapping("/public/{lang}/my-profile")
    public ResponseEntity<MyProfileResponseDTO> getMyProfile(@PathVariable("lang") LanguageEnum lang) {
        MyProfileResponseDTO profile = myProfileService.getAboutMe(lang);
        return ResponseEntity.ok(profile);
    }

    // ENDPOINT PARA INSERTAR UN PERFIL
    @PostMapping("/{lang}/my-profile")
    public ResponseEntity<?> saveProfile(@Valid @RequestBody MyProfileDTO profileDTO, @PathVariable("lang") LanguageEnum lang) {
        MyProfileResponseDTO profile = myProfileService.saveMyProfile(profileDTO, lang);
        return ResponseEntity.ok(profile);
    }


}

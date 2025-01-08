package com.pablopafundi.site.myprofile;


import com.pablopafundi.site.common.domain.LanguageEnum;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;

@RestController
public class MyProfileController {

    private final MyProfileService myProfileService;
    @Value("${gcs.bucket.name}")
    private String BUCKET_NAME;

    public MyProfileController(MyProfileService myProfileService) {
        this.myProfileService = myProfileService;
    }

    @PostMapping("/upload-image-bucket")
    public ResponseEntity<String> uploadProfileImageBucket(@RequestParam("file") MultipartFile file) {
        myProfileService.uploadProfileImageBucket(file);
        return ResponseEntity.ok("Image upload");
    }

    @GetMapping("/public/image-bucket/{filename}")
    public ResponseEntity<Resource> getImageBucket(@PathVariable String filename) {
        try {

            String imageUrl = "https://storage.googleapis.com/" + BUCKET_NAME + "/" + filename;

            URL url = new URL(imageUrl);
            Resource resource = new UrlResource(url);

            String contentType = "application/octet-stream";

            if (filename.endsWith(".jpg") || filename.endsWith(".jpeg")) {
                contentType = "image/jpeg";
            } else if (filename.endsWith(".png")) {
                contentType = "image/png";
            }
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, contentType).body(resource);

        } catch (MalformedURLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @PostMapping("/upload-image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        myProfileService.uploadProfileImage(file);
        return ResponseEntity.ok("Image upload");
    }


    @GetMapping("/public/images/{filename}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) throws IOException {
        // Ruta completa del archivo en el sistema de archivos
        File file = new File("src/main/resources/public/images/" + filename);

        if (!file.exists()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Resource image = new FileSystemResource(file);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg").body(image);
    }

    @GetMapping("/public/{lang}/my-profile")
    public CompletableFuture<ResponseEntity<MyProfileResponseDTO>> getMyProfile(@PathVariable("lang") LanguageEnum lang) {
        return myProfileService.getAboutMe(lang).thenApply(ResponseEntity::ok);
    }

    @PostMapping("/{lang}/my-profile")
    public ResponseEntity<?> saveProfile(@Valid @RequestBody MyProfileDTO profileDTO, @PathVariable("lang") LanguageEnum lang) {
        MyProfileResponseDTO profile = myProfileService.saveMyProfile(profileDTO, lang);
        return ResponseEntity.ok(profile);
    }


}

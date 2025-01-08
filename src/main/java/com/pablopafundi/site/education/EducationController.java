package com.pablopafundi.site.education;

import com.pablopafundi.site.common.domain.LanguageEnum;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class EducationController {

    private final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("public/{lang}/education")
    public CompletableFuture<ResponseEntity<List<EducationResponseDTO>>> getLastFourEducation(@PathVariable("lang") LanguageEnum lang) {
        return educationService.getLastFourEducation(lang).thenApply(ResponseEntity::ok);
    }


    @PostMapping("/{lang}/education")
    public ResponseEntity<EducationResponseDTO> saveEducation(@PathVariable("lang") LanguageEnum lang, @Valid @RequestBody EducationDTO educationDTO) {
        return ResponseEntity.ok(educationService.saveEducation(lang, educationDTO));
    }


}

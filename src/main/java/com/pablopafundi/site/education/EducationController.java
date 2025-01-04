package com.pablopafundi.site.education;

import com.pablopafundi.site.common.domain.LanguageEnum;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EducationController {

    private final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("public/{lang}/education")
    public ResponseEntity<List<EducationResponseDTO>> getLastFourEducation(@PathVariable("lang") LanguageEnum lang){
        return ResponseEntity.ok(educationService.getLastFourEducation(lang));
    }

    @PostMapping("/{lang}/education")
    public ResponseEntity<EducationResponseDTO> saveEducation(@PathVariable("lang") LanguageEnum lang, @Valid @RequestBody EducationDTO educationDTO){
        return ResponseEntity.ok(educationService.saveEducation(lang, educationDTO));
    }



}

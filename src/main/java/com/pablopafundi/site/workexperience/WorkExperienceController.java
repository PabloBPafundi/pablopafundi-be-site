package com.pablopafundi.site.workexperience;


import com.pablopafundi.site.common.domain.LanguageEnum;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkExperienceController {

    private final WorkExperienceService workExperienceService;

    public WorkExperienceController(WorkExperienceService workExperienceService) {
        this.workExperienceService = workExperienceService;
    }


    @GetMapping("public/{lang}/work-experience")
    public ResponseEntity<List<WorkExperienceResponseDTO>> getLastFourJobsExperiences(@PathVariable("lang") LanguageEnum lang){

        List<WorkExperienceResponseDTO> workExperienceResponseDTOList = workExperienceService.getLastFourJobsExperiences(lang);

        return ResponseEntity.ok(workExperienceResponseDTOList);
    }


    @PostMapping("/{lang}/work-experience")
    public ResponseEntity<WorkExperienceResponseDTO> saveWorkExperience(@Valid @RequestBody WorkExperienceDTO workExperienceDTO, @PathVariable("lang") LanguageEnum lang){

        WorkExperienceResponseDTO savedWorkExperience = workExperienceService.saveWorkExperience(workExperienceDTO, lang);
        return ResponseEntity.ok(savedWorkExperience);

    }

}

package com.pablopafundi.site.workexperience;

import com.pablopafundi.site.common.domain.LanguageEnum;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkExperienceService {
    private final WorkExperienceMapper workExperienceMapper;
    private final WorkExperienceRepository workExperienceRepository;


    public WorkExperienceService(WorkExperienceMapper workExperienceMapper, WorkExperienceRepository workExperienceRepository) {
        this.workExperienceMapper = workExperienceMapper;
        this.workExperienceRepository = workExperienceRepository;
    }



    public List<WorkExperienceResponseDTO> getLastFourJobsExperiences(LanguageEnum lang){

        return workExperienceRepository.findTop4ByIsActiveAndLangOrderByDateStartDesc(true, lang)
                .stream()
                .map(workExperienceMapper::toworkExperienceResponseDTO)
                .collect(Collectors.toList());
    }


    public WorkExperienceResponseDTO saveWorkExperience(WorkExperienceDTO workExperienceDTO, LanguageEnum lang){
        WorkExperience workExperience = workExperienceMapper.toWorkExperience(workExperienceDTO);
        workExperience.setLang(lang);
        var savedWorkExperience = workExperienceRepository.save(workExperience);
        return workExperienceMapper.toworkExperienceResponseDTO(savedWorkExperience);
    }




}

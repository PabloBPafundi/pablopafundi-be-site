package com.pablopafundi.site.education;

import com.pablopafundi.site.common.domain.LanguageEnum;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class EducationService {

    private final EducationMapper educationMapper;
    private final EducationRespository educationRespository;

    public EducationService(EducationMapper educationMapper, EducationRespository educationRespository) {
        this.educationMapper = educationMapper;
        this.educationRespository = educationRespository;
    }

    /*
    public List<EducationResponseDTO> getLastFourEducation(LanguageEnum lang){
        return educationRespository.findTop4ByIsActiveAndLangOrderByDateStartDesc(true, lang)
                .stream()
                .map(educationMapper::toEducationResponseDTO)
                .collect(Collectors.toList());
    }*/


    @Async
    public CompletableFuture<List<EducationResponseDTO>> getLastFourEducation(LanguageEnum lang) {
        List<EducationResponseDTO> education = educationRespository.findTop4ByIsActiveAndLangOrderByDateStartDesc(true, lang)
                .stream()
                .map(educationMapper::toEducationResponseDTO)
                .collect(Collectors.toList());

        return CompletableFuture.completedFuture(education);
    }



    public EducationResponseDTO saveEducation(LanguageEnum lang, EducationDTO educationDTO){
        var education = educationMapper.toEducation(educationDTO);
        education.setLang(lang);
        var savedEducation = educationRespository.save(education);
        return educationMapper.toEducationResponseDTO(savedEducation);
    }


}

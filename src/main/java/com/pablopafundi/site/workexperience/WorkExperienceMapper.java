package com.pablopafundi.site.workexperience;


import org.springframework.stereotype.Service;

@Service
public class WorkExperienceMapper {


    public WorkExperience toWorkExperience(WorkExperienceDTO workExperienceDTO) {

        return new WorkExperience(workExperienceDTO.name(), workExperienceDTO.description(), workExperienceDTO.dateStart(), workExperienceDTO.dateEnd(), workExperienceDTO.siteURL());
    }

    public WorkExperienceResponseDTO toworkExperienceResponseDTO(WorkExperience workExperience) {
        return new WorkExperienceResponseDTO(workExperience.getName(), workExperience.getDescription(), workExperience.getDateStart(), workExperience.getDateEnd(), workExperience.getSiteURL());
    }


    public WorkExperienceDTO toWorkExperienceDTO(WorkExperience workExperience) {
        return new WorkExperienceDTO(workExperience.getName(), workExperience.getDescription(), workExperience.getDateStart(), workExperience.getDateEnd(), workExperience.getSiteURL());
    }

}

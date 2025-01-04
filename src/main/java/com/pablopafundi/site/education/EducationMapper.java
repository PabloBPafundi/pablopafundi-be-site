package com.pablopafundi.site.education;

import org.springframework.stereotype.Service;

@Service
public class EducationMapper {

    public Education toEducation(EducationDTO educationDTO){
        return new Education(educationDTO.name(), educationDTO.description(),educationDTO.dateStart(), educationDTO.dateEnd(), educationDTO.siteURL());
    }


    public EducationDTO toEducationDTO(Education education){

        return new EducationDTO(education.getName(), education.getDescription(), education.getDateStart(), education.getDateEnd(), education.getSiteURL());
    }

    public EducationResponseDTO toEducationResponseDTO(Education education){

        return new EducationResponseDTO(education.getName(), education.getDescription(), education.getDateStart(), education.getDateEnd(), education.getSiteURL());
    }


}

package com.pablopafundi.site.curriculum;

import com.pablopafundi.site.contact.ContactDTO;
import com.pablopafundi.site.contact.ContactResponseDTO;
import com.pablopafundi.site.education.EducationDTO;
import com.pablopafundi.site.education.EducationResponseDTO;
import com.pablopafundi.site.knowledge.KnowledgeResponseDTO;
import com.pablopafundi.site.myprofile.MyProfileDTO;
import com.pablopafundi.site.myprofile.MyProfileResponseDTO;
import com.pablopafundi.site.workexperience.WorkExperienceDTO;
import com.pablopafundi.site.workexperience.WorkExperienceResponseDTO;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Builder
public record CurriculumDTO(

        LocalDate dateGenerate,

        MyProfileResponseDTO myProfile,

        List<WorkExperienceResponseDTO> workExperience,

        List<EducationResponseDTO> education,

        List<ContactResponseDTO> contact,

        List<KnowledgeResponseDTO> knowledge

){}

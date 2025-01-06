package com.pablopafundi.site.curriculum;

import com.pablopafundi.site.common.domain.LanguageEnum;
import com.pablopafundi.site.contact.ContactService;
import com.pablopafundi.site.education.EducationService;
import com.pablopafundi.site.knowledge.KnowledgeService;
import com.pablopafundi.site.myprofile.MyProfileService;
import com.pablopafundi.site.workexperience.WorkExperienceService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CurriculumService {


    private final WorkExperienceService workExperienceService;
    private final EducationService educationService;
    private final MyProfileService myProfileService;
    private final ContactService contactService;
    private final KnowledgeService knowledgeService;


    public CurriculumService(WorkExperienceService workExperienceService, EducationService educationService, MyProfileService myProfileService, ContactService contactService, KnowledgeService knowledgeService) {
        this.workExperienceService = workExperienceService;
        this.educationService = educationService;
        this.myProfileService = myProfileService;
        this.contactService = contactService;
        this.knowledgeService = knowledgeService;
    }

    public CurriculumDTO getCV(LanguageEnum lang){

        return CurriculumDTO.builder()
                 //.workExperience(workExperienceService.getLastFourJobsExperiences(lang))
                 //.education(educationService.getLastFourEducation(lang))
                 //.myProfile(myProfileService.getAboutMe(lang))
                 //.contact(contactService.getContact(lang))
                 //.knowledge(knowledgeService.findByIsActiveTrue(lang))
                 //.dateGenerate(LocalDate.now())

                 .build();
    }


}

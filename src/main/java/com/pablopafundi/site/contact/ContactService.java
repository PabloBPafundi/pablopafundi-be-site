package com.pablopafundi.site.contact;

import com.pablopafundi.site.achivement.AchievementDTO;
import com.pablopafundi.site.achivement.AchievementResponseDTO;
import com.pablopafundi.site.common.domain.LanguageEnum;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {


    private final ContactMapper contactMapper;
    private final ContactRepository contactRepository;

    public ContactService(ContactMapper contactMapper, ContactRepository contactRepository) {
        this.contactMapper = contactMapper;
        this.contactRepository = contactRepository;
    }


    public List<ContactResponseDTO> getContact(LanguageEnum lang){

        return contactRepository.findByIsActiveTrueAndLang(lang)
                .stream()
                .map(contactMapper::toContactResponseDTO)
                .collect(Collectors.toList());
    }

    public ContactResponseDTO saveContact(LanguageEnum lang, ContactDTO contactDTO){
        var achievement = contactMapper.toContact(contactDTO);
        achievement.setLang(lang);
        return contactMapper.toContactResponseDTO(contactRepository.save(achievement));

    }


}

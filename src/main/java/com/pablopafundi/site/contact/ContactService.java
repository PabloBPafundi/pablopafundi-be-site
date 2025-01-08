package com.pablopafundi.site.contact;

import com.pablopafundi.site.common.domain.LanguageEnum;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class ContactService {


    private final ContactMapper contactMapper;
    private final ContactRepository contactRepository;

    public ContactService(ContactMapper contactMapper, ContactRepository contactRepository) {
        this.contactMapper = contactMapper;
        this.contactRepository = contactRepository;
    }

    @Async
    public CompletableFuture<List<ContactResponseDTO>> getContact(LanguageEnum lang) {

        List<ContactResponseDTO> contact = contactRepository.findByIsActiveTrueAndLang(lang).stream().map(contactMapper::toContactResponseDTO).collect(Collectors.toList());

        return CompletableFuture.completedFuture(contact);
    }


    public ContactResponseDTO saveContact(LanguageEnum lang, ContactDTO contactDTO) {
        var achievement = contactMapper.toContact(contactDTO);
        achievement.setLang(lang);
        return contactMapper.toContactResponseDTO(contactRepository.save(achievement));

    }


}

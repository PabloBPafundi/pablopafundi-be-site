package com.pablopafundi.site.contact;

import org.springframework.stereotype.Service;

@Service
public class ContactMapper {



    public Contact toContact(ContactDTO contactDTO){

        return new Contact(contactDTO.channel(),contactDTO.contactDescription(), contactDTO.url());
    }


    public ContactResponseDTO toContactResponseDTO(Contact contact){

        return new ContactResponseDTO(contact.getChannel(), contact.getContact(), contact.getUrl());
    }

}

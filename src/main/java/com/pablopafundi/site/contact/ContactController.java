package com.pablopafundi.site.contact;

import com.pablopafundi.site.common.domain.LanguageEnum;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class ContactController {

    private final ContactService contactService;


    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    /*
    @GetMapping("public/{lang}/contact")
    public ResponseEntity<List<ContactResponseDTO>> getContact(@PathVariable("lang") LanguageEnum lang){
        return ResponseEntity.ok(contactService.getContact(lang));
    )
     */


    @GetMapping("public/{lang}/contact")
    public CompletableFuture<ResponseEntity<List<ContactResponseDTO>>> getContact(@PathVariable("lang") LanguageEnum lang){
        return contactService.getContact(lang).thenApply(ResponseEntity::ok);

    }

    @PostMapping("/{lang}/contact")
    public ResponseEntity<ContactResponseDTO> saveContact(@PathVariable("lang") LanguageEnum lang,@Valid @RequestBody ContactDTO contactDTO){
        return ResponseEntity.ok(contactService.saveContact(lang, contactDTO));
    }


}

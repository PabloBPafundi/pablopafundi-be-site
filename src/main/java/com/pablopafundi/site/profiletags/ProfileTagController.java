package com.pablopafundi.site.profiletags;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileTagController {

    private final ProfileTagService profileTagService;

    public ProfileTagController(ProfileTagService profileTagService) {
        this.profileTagService = profileTagService;
    }

    @PostMapping("/profile-tag")
    public ResponseEntity<ProfileTagResponseDTO> saveProfileTitle(@Valid @RequestBody ProfileTagDTO profileTagDTO) {
        ProfileTagResponseDTO profileTitle = profileTagService.saveProfileTag(profileTagDTO);
        return ResponseEntity.ok(profileTitle);

    }


}

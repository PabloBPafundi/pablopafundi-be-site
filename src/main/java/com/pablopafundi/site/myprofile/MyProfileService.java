package com.pablopafundi.site.myprofile;


import com.pablopafundi.site.common.domain.LanguageEnum;
import com.pablopafundi.site.common.exception.BusinessLogicException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class MyProfileService {

    private final MyProfileRepository myProfileRepository;
    private final MyProfileMapper myProfileMapper;
    @Value("${image.upload.dir}")
    private String uploadDir;

    public MyProfileService(MyProfileRepository myProfileRepository, MyProfileMapper myProfileMapper) {
        this.myProfileRepository = myProfileRepository;
        this.myProfileMapper = myProfileMapper;
    }

    public MyProfileResponseDTO saveMyProfile(MyProfileDTO myProfileDTO, LanguageEnum lang) {

        var myProfile = myProfileMapper.toMyProfile(myProfileDTO);
        myProfile.setLang(lang);

        if (myProfileRepository.findTop1ByIsActiveTrueAndLangEquals(lang).isPresent()) {
            throw new BusinessLogicException("There is already one active profile with language: " + lang);
        }

        var savedMyProfile = myProfileRepository.save(myProfile);

        return myProfileMapper.toMyProfileResponseDTO(savedMyProfile);
    }


    public void uploadProfileImage(MultipartFile file) {

        List<MyProfile> profiles = myProfileRepository.findTop2ByIsActiveTrue();

        if (profiles.size() != 2) {
            throw new BusinessLogicException("In order to upload this image, there must be at least one active profile for every language available in the application. Please ensure that all languages have an active profile.");
        }


        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();


        Path path = Paths.get(uploadDir + fileName);
        try {
            Files.createDirectories(path.getParent());
            Files.write(path, file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error al subir la imagen", e);
        }


        for (MyProfile profile : profiles) {
            profile.setProfileImageUrl("/public/images/" + fileName);
            myProfileRepository.save(profile);
        }
    }

    public MyProfileResponseDTO getAboutMe(LanguageEnum lang) {

        MyProfile profile = myProfileRepository
                .findTop1ByIsActiveTrueAndLangEquals(lang)
                .orElseThrow(() -> new EntityNotFoundException("Profile with lenguage: '" + lang + "' not found "));

        return myProfileMapper.toMyProfileResponseDTO(profile);
    }


    public MyProfileDTO getAboutMeCurriculum() {

        var myProfile = myProfileRepository.findTop1ByIsActiveTrue();

        return myProfileMapper.toMyProfileDTO(myProfile);
    }


}

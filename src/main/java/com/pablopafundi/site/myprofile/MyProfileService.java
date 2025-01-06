package com.pablopafundi.site.myprofile;


import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.pablopafundi.site.common.domain.LanguageEnum;
import com.pablopafundi.site.common.exception.BusinessLogicException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.scheduling.annotation.Async;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class MyProfileService {

    private final MyProfileRepository myProfileRepository;
    private final MyProfileMapper myProfileMapper;
    @Value("${image.upload.dir}")
    private String uploadDir;

    @Value("${gcs.bucket.name}")
    private String BUCKET_NAME;
    private final Storage storage;

    public MyProfileService(MyProfileRepository myProfileRepository, MyProfileMapper myProfileMapper) {
        this.myProfileRepository = myProfileRepository;
        this.myProfileMapper = myProfileMapper;
        this.storage = StorageOptions.getDefaultInstance().getService();
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



    public void uploadProfileImageBucket(MultipartFile file) {

        List<MyProfile> profiles = myProfileRepository.findTop2ByIsActiveTrue();

        if (profiles.size() != 2) {
            throw new BusinessLogicException("In order to upload this image, there must be at least one active profile for every language available in the application. Please ensure that all languages have an active profile.");
        }

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        // Subir la imagen a Google Cloud Storage
        try {
            BlobInfo blobInfo = BlobInfo.newBuilder(BUCKET_NAME, fileName).build();
            storage.create(blobInfo, file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error al subir la imagen", e);
        }

        // Guardar la URL pública de la imagen en la base de datos
        String imageUrl = "https://storage.googleapis.com/" + BUCKET_NAME + "/" + fileName;
        for (MyProfile profile : profiles) {
            profile.setProfileImageUrl(imageUrl);
            myProfileRepository.save(profile);
        }
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

    /*
    public MyProfileResponseDTO getAboutMe(LanguageEnum lang) {

        MyProfile profile = myProfileRepository
                .findTop1ByIsActiveTrueAndLangEquals(lang)
                .orElseThrow(() -> new EntityNotFoundException("Profile with lenguage: '" + lang + "' not found "));

        return myProfileMapper.toMyProfileResponseDTO(profile);
    }*/


    @Transactional
    @Async
    public CompletableFuture<MyProfileResponseDTO> getAboutMe(LanguageEnum lang) {
        MyProfile profile = myProfileRepository
                .findTop1ByIsActiveTrueAndLangEquals(lang)
                .orElseThrow(() -> new EntityNotFoundException("Profile with lenguage: '" + lang + "' not found "));

        return CompletableFuture.completedFuture(myProfileMapper.toMyProfileResponseDTO(profile));
    }


    public MyProfileDTO getAboutMeCurriculum() {

        var myProfile = myProfileRepository.findTop1ByIsActiveTrue();

        return myProfileMapper.toMyProfileDTO(myProfile);
    }


}

package com.pablopafundi.site.profiletags;


import com.pablopafundi.site.myprofile.MyProfile;
import com.pablopafundi.site.myprofile.MyProfileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProfileTagMapper {

    private final MyProfileRepository myProfileRepository;


    public ProfileTagMapper(MyProfileRepository myProfileRepository) {
        this.myProfileRepository = myProfileRepository;
    }


    public ProfileTag toProfileTitle(ProfileTagDTO profileTagDTO) {

        MyProfile profile = myProfileRepository.findById(profileTagDTO.profileID()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found"));

        return new ProfileTag(profileTagDTO.profileTag(), profile);
    }


    public ProfileTagResponseDTO toProfileResponseDTO(ProfileTag profileTags) {
        return new ProfileTagResponseDTO(profileTags.getTagName(), profileTags.getId(), profileTags.getProfile().getId());
    }

    public List<ProfileTagResponseDTO> toProfileResponseDTOList(List<ProfileTag> profileTagsList) {
        return profileTagsList.stream().map(this::toProfileResponseDTO).toList(); // Usamos toList() para devolver una lista inmutable
    }


}

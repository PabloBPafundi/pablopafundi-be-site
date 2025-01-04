package com.pablopafundi.site.myprofile;

import com.pablopafundi.site.profiletags.ProfileTagMapper;
import com.pablopafundi.site.profiletags.ProfileTagResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyProfileMapper {

    private final ProfileTagMapper profileTagMapper;

    public MyProfileMapper(ProfileTagMapper profileTagMapper) {
        this.profileTagMapper = profileTagMapper;
    }


    public MyProfile toMyProfile(MyProfileDTO myProfileDTO){

        return new MyProfile(myProfileDTO.residency(), myProfileDTO.aboutMe(), myProfileDTO.lang());
    }

    public MyProfileDTO toMyProfileDTO(MyProfile myProfile){

        return new MyProfileDTO(myProfile.getAboutMe(), myProfile.getResidency(), myProfile.getLang());
    }

    public MyProfileResponseDTO toMyProfileResponseDTO(MyProfile myProfile){


        List<ProfileTagResponseDTO> profileResponseDTOList =
                myProfile.getTitle() != null
                        ? profileTagMapper.toProfileResponseDTOList(myProfile.getTitle())
                        : List.of();

        return new MyProfileResponseDTO(
                myProfile.getId(),
                myProfile.getResidency(),
                myProfile.getAboutMe(),
                myProfile.getProfileImageUrl(),
                profileResponseDTOList
        );
    }

}

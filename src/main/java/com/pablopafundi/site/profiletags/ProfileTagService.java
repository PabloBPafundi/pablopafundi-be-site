package com.pablopafundi.site.profiletags;


import org.springframework.stereotype.Service;

@Service
public class ProfileTagService {
    private final ProfileTagMapper profileTagMapper;
    private final ProfileTagRepository profileTagRepository;


    public ProfileTagService(ProfileTagMapper profileTagMapper, ProfileTagRepository profileTagRepository) {
        this.profileTagMapper = profileTagMapper;
        this.profileTagRepository = profileTagRepository;
    }

    public ProfileTagResponseDTO saveProfileTag(ProfileTagDTO profileTagDTO) {

        ProfileTag profileTag = profileTagMapper.toProfileTitle(profileTagDTO);
        var savedProfileTag = profileTagRepository.save(profileTag);
        return profileTagMapper.toProfileResponseDTO(savedProfileTag);

    }

}

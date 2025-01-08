package com.pablopafundi.site.user;

import org.springframework.stereotype.Service;

@Service
public class UserMapper {


    public User toUser(UserDTO userDto) {

        return new User(userDto.userName(), userDto.password(), userDto.role());
    }

    public UserResponseDTO toUserResponseDTO(User user) {

        return new UserResponseDTO(user.getUsername(), user.getPassword(), user.getRole());
    }

}

package com.pablopafundi.site.user;

import com.pablopafundi.site.config.JwtService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public UserService(UserMapper userMapper, UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    public boolean userExistsByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }

    public void createUser(String userName, String password, Role role) {
        String encodedPassword = passwordEncoder.encode(password);
        User user =
                User.builder()
                .userName(userName)
                .password(encodedPassword)
                .role(role)
                .build();
        userRepository.save(user);

    }

    public UserResponseDTO createUser(UserDTO userDTO) {
        String encodedPassword = passwordEncoder.encode(userDTO.password());
        User user = User.builder()
                .userName(userDTO.userName())
                .password(encodedPassword)
                .role(userDTO.role())
                .build();
        return userMapper.toUserResponseDTO((userRepository.save(user)));
    }

}
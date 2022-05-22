package com.springboot.app.servicies;

import com.springboot.app.entities.User;
import com.springboot.app.entities.dto.LoginDTO;
import com.springboot.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public boolean signIn(final LoginDTO loginDTO) throws Exception {
        final User user = userRepository.findByUserNameOrEmail(loginDTO.getUsernameOrEmail(), loginDTO.getUsernameOrEmail())
                .orElseThrow(() ->
                        new Exception("User not found with username or email:" + loginDTO.getUsernameOrEmail()));

        return user.getPassword().equals(loginDTO.getPassword());
    }
}

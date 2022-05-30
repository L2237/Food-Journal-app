package com.springboot.app.servicies;

import com.springboot.app.entities.User;
import com.springboot.app.entities.dto.LoginDTO;
import com.springboot.app.repositories.UserRepository;
import com.springboot.app.utils.MD5Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        users.forEach(user -> user.setPassword(MD5Utils.bytesToHex(MD5Utils.digest(user.getPassword().getBytes(UTF_8)))));
        return userRepository.findAll();
    }

    public boolean signIn(final LoginDTO loginDTO) throws Exception {
        final User user = userRepository.findByUserNameOrEmail(loginDTO.getUsernameOrEmail(), loginDTO.getUsernameOrEmail())
                .orElseThrow(() ->
                        new Exception("User not found with username or email:" + loginDTO.getUsernameOrEmail()));

        return user.getPassword().equals(loginDTO.getPassword());
    }

}

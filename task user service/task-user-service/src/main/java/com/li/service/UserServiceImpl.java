package com.li.service;

import com.li.config.JwtProvider;
import com.li.model.User;
import com.li.repository.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: li he
 **/
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserRepository userRepository;

    @Override
    public User getUserProfile(String jwt) {
        String email =  JwtProvider.getEmailFromJwtToken(jwt);

        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

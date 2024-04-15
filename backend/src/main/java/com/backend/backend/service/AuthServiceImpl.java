package com.backend.backend.service;

import com.backend.backend.entity.UserEntity;
import com.backend.backend.model.User;
import com.backend.backend.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService{

    private UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User loginUser(String email, String password) {
        Optional<UserEntity> userEntityOptional = userRepository.findByEmail(email);
        if (userEntityOptional.isPresent()) {
            UserEntity userEntity = userEntityOptional.get();
            User user = new User();
            BeanUtils.copyProperties(userEntity, user);
            return user;
        }
        return null;
    }
}

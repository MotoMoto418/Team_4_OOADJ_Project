package com.backend.backend.service;

import com.backend.backend.entity.UserEntity;
import com.backend.backend.model.User;
import com.backend.backend.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userRepository.save(userEntity);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<User> users = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            User user = new User();
            BeanUtils.copyProperties(userEntity, user);
            users.add(user);
        }
        return users;
    }

    @Override
    public User getUserById(Long id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        if (userEntityOptional.isPresent()) {
            User user = new User();
            BeanUtils.copyProperties(userEntityOptional.get(), user);
            return user;
        } else {
            return null; // Return null if user is not found
        }
    }
}

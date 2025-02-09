package com.employee.service.impl;

import com.employee.entity.user.User;
import com.employee.model.UserModel;
import com.employee.repository.user.UserRepository;
import com.employee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserModel saveUser(UserModel user) {
        User userEntity = new User();
        BeanUtils.copyProperties(user, userEntity);
        userRepository.save(userEntity);
        return user;
    }


    @Override
    public UserModel getUserById(Long id) {
        User userEntity = userRepository.findById(id).get();
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userEntity, userModel);
        return userModel;
    }

    @Override
    public boolean deleteUserById(Long id) {
        User userEntity = userRepository.findById(id).get();
        userRepository.delete(userEntity);
        return true;
    }




}

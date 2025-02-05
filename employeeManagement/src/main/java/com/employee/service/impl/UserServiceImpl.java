package com.employee.service.impl;

import com.employee.entity.UserEntity;
import com.employee.model.UserModel;
import com.employee.repository.UserRepository;
import com.employee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserModel saveUser(UserModel user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userRepository.save(userEntity);
        return user;
    }

    @Override
    public List<UserModel> getAllUser() {
        List<UserEntity> getAllUser = userRepository.findAll();
        List<UserModel> allUser = getAllUser
                .stream()
                .map(userEntity -> new UserModel(
                        userEntity.getId(),
                        userEntity.getFirstName(),
                        userEntity.getLastName(),
                        userEntity.getEmailId()
                ))
                .collect(Collectors.toList());
        return allUser;
    }

    @Override
    public UserModel getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userEntity, userModel);
        return userModel;
    }

    @Override
    public boolean deleteUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        userRepository.delete(userEntity);
        return true;
    }

    @Override
    public UserModel updateUserById(Long id, UserModel user) {
        UserEntity userEntity = userRepository.findById(id).get();
        userEntity.setEmailId(user.getEmailId());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        return user;
    }


}

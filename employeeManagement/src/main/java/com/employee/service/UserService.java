package com.employee.service;

import com.employee.entity.UserEntity;
import com.employee.model.UserModel;

import java.util.List;


public interface UserService {


    UserModel saveUser(UserModel user);

    List<UserModel> getAllUser();

    UserModel getUserById(Long id);

    boolean deleteUserById(Long id);

    UserModel updateUserById(Long id, UserModel user);
}

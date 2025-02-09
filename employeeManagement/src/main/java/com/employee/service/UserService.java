package com.employee.service;

import com.employee.model.UserModel;

import java.util.List;


public interface UserService {


    UserModel saveUser(UserModel user);



    UserModel getUserById(Long id);

    boolean deleteUserById(Long id);


}

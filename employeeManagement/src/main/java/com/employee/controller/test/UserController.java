package com.employee.controller.test;

import com.employee.entity.UserEntity;
import com.employee.model.UserModel;
import com.employee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public UserModel saveUser(@RequestBody UserModel user){
        return userService.saveUser(user);
    }

    @GetMapping("/users")
    public List<UserModel> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable Long id){
        UserModel user;
        user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUserById(@PathVariable Long id){
        boolean deleted = false;
        deleted = userService.deleteUserById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserModel> updateUserById(@PathVariable("id") Long id,
                                                    @RequestBody UserModel user){

        user = userService.updateUserById(id, user);
        return ResponseEntity.ok(user);

    }

}

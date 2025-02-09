package com.employee.controller.user;

import com.employee.entity.user.User;
import com.employee.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resister")
@RequiredArgsConstructor
public class UserController {


    private final UserRepository userRepository;
    @PostMapping
    public ResponseEntity<User> resister(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(user));
    }

}

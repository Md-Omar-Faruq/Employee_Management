package com.employee.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USERS")
@RequiredArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private  Long id;
    @Column(name = "USER_NAME")
    private  String userName;
    @Column(name = "PASSWORD")
    private String password;

}

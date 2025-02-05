package com.employee.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USERS")
@RequiredArgsConstructor
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private  Long id;
    @Column(name = "FIRST_NAME")
    private  String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL_ID")
    private String emailId;

}

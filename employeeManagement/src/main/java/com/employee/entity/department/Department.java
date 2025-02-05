package com.employee.entity.department;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DEPARTMENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "DEPARTMENT_NAME")
    @NotBlank(message = "Please Add Address Name")
    private String departmentName;

    @Column(name = "DEPARTMENT_ADDRESS")
    private String departmentAddress;

    @Column(name = "DEPARTMENT_CODE")
    private String departmentCode;

}

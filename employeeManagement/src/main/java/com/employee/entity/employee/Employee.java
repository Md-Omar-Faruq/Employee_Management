package com.employee.entity.employee;

import com.employee.constant.SequenceConstant;
import com.employee.entity.department.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @SequenceGenerator(
            name = SequenceConstant.EMPLOYEE_SEQUENCE,
            initialValue = SequenceConstant.EMPLOYEE_SEQUENCE_INITIAL_VALUE,
            allocationSize = SequenceConstant.EMPLOYEE_SEQUENCE_ALLOCATION
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SequenceConstant.EMPLOYEE_SEQUENCE)
    @Column( name = "ID", nullable = false)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

}

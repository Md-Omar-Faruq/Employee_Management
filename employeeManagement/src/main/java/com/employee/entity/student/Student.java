package com.employee.entity.student;

import com.employee.constant.SequenceConstant;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table( name = "STUDENT")
public class Student {

    @Id
    @Column(name = "ID")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = SequenceConstant.STUDENT_SEQUENCE
    )
    @SequenceGenerator(
            name = SequenceConstant.STUDENT_SEQUENCE,
            sequenceName = SequenceConstant.STUDENT_SEQUENCE,
            initialValue = SequenceConstant.STUDENT_SEQUENCE_INITIAL_VALUE,
            allocationSize = SequenceConstant.STUDENT_SEQUENCE_ALLOCATION
    )
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL", unique = true)
    @NotBlank
    private String email;

    @ManyToOne
    @JoinColumn(name = "guardian_id", referencedColumnName = "id")
    Guardian guardian;

}

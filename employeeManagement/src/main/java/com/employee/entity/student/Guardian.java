package com.employee.entity.student;

import com.employee.constant.SequenceConstant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Guardian {

    @Id
    @Column(name = "ID")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = SequenceConstant.GUARDIAN_SEQUENCE
    )
    @SequenceGenerator(
            name = SequenceConstant.GUARDIAN_SEQUENCE,
            sequenceName = SequenceConstant.GUARDIAN_SEQUENCE,
            initialValue = SequenceConstant.GUARDIAN_SEQUENCE_INITIAL_VALUE,
            allocationSize = SequenceConstant.GUARDIAN_SEQUENCE_ALLOCATION
    )
    private Long id;

    @Column(name = "GUARDIAN_NAME")
    private String name;

    @Column(name = "GUARDIAN_EMAIL")
    private String email;

    @Column(name = "GUARDIAN_MOBILE")
    private String mobile;

}

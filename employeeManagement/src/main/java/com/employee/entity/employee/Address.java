package com.employee.entity.employee;

import com.employee.constant.SequenceConstant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DEPARTMENT")
@Entity
public class Address {

    @Id
    @SequenceGenerator(
            name = SequenceConstant.ADDRESS_SEQUENCE,
            initialValue = SequenceConstant.ADDRESS_SEQUENCE_INITIAL_VALUE,
            allocationSize = SequenceConstant.ADDRESS_SEQUENCE_ALLOCATION
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SequenceConstant.ADDRESS_SEQUENCE)
    @Column( name = "ID", nullable = false)
    private Long id;

    @Column(name = "STREET_NAME")
    private String streetName;

    @Column(name = "HOUSE_NO")
    private String houseNo;

    @Column(name = "ZIP_CODE")
    private String zipCode;

}

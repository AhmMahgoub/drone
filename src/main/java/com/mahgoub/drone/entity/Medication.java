package com.mahgoub.drone.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "medication")
@Getter
@Setter
@ToString
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$", message = ExceptionMessages.INVALID_MEDICATION_NAME_PATTERN)
    @NotBlank(message = ExceptionMessages.MISSING_REQUEST_PARAMETERS)
    private String name;

    @Column(name = "code", nullable = false)
    @Pattern(regexp = "^[A-Z0-9_]*$", message = ExceptionMessages.INVALID_MEDICATION_CODE_PATTERN)
    @NotBlank(message = ExceptionMessages.MISSING_REQUEST_PARAMETERS)
    private String code;

    @Column(name = "image", nullable = false)
    @NotBlank(message = ExceptionMessages.MISSING_REQUEST_PARAMETERS)
    private String image;

    @Column(name = "weight", nullable = false)
    @Size(min = 10, message = ExceptionMessages.INVALID_MIN_WEIGHT_VALUE)
    @NotBlank(message = ExceptionMessages.MISSING_REQUEST_PARAMETERS)
    private Integer weight ;

}

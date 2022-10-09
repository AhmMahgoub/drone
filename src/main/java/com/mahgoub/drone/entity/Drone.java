package com.mahgoub.drone.entity;

import com.mahgoub.drone.enums.ModelEnum;
import com.mahgoub.drone.enums.StateEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "drone")
@Getter
@Setter
@ToString
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "serial_number", nullable = false, length = 100)
    @Size(max = 100, message = ExceptionMessages.INVALID_SERIAL_NUMBER_LENGTH)
    @NotBlank(message = ExceptionMessages.MISSING_REQUEST_PARAMETERS)
    private String serialNumber;

    @Column(name = "weight", nullable = false)
    @Size(max = 500, message = ExceptionMessages.INVALID_MAX_WEIGHT_VALUE)
    @NotBlank(message = ExceptionMessages.MISSING_REQUEST_PARAMETERS)
    private Integer weight ;

    @NotBlank(message = ExceptionMessages.MISSING_REQUEST_PARAMETERS)
    @Size(max = 100)
    @Column(name = "battery_percentage", nullable = false)
    private Integer batteryPercentage = 100;

    @Enumerated(EnumType.ORDINAL)
    @NotBlank(message = ExceptionMessages.MISSING_REQUEST_PARAMETERS)
    @Column(name = "model", nullable = false)
    private ModelEnum modelEnum ;

    @Enumerated(EnumType.ORDINAL)
    @NotBlank(message = ExceptionMessages.MISSING_REQUEST_PARAMETERS)
    @Column(name = "state", nullable = false)
    private StateEnum stateEnum ;
}

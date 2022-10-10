package com.mahgoub.drone.entity;

import com.mahgoub.drone.common.request.RegisterDroneRequest;
import com.mahgoub.drone.enums.ModelEnum;
import com.mahgoub.drone.enums.StateEnum;
import com.mahgoub.drone.service.DroneService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "drone")
@Getter
@Setter
@ToString
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial_number", nullable = false, length = 100)
    @Size(max = 100, message = ExceptionMessages.INVALID_SERIAL_NUMBER_LENGTH)
    @NotBlank(message = ExceptionMessages.MISSING_REQUEST_PARAMETERS)
    private String serialNumber;

    @Column(name = "weight", nullable = false)
    @Max(value = 500,message = ExceptionMessages.INVALID_MAX_WEIGHT_VALUE)
    @NotNull(message = ExceptionMessages.MISSING_REQUEST_PARAMETERS)
    private Integer weight ;

    @NotNull(message = ExceptionMessages.MISSING_REQUEST_PARAMETERS)
    @Max(value = 100,message = ExceptionMessages.MISSING_REQUEST_PARAMETERS)
    @Column(name = "battery_percentage", nullable = false)
    private Integer batteryPercentage = 100;

    @Enumerated(EnumType.ORDINAL)
    @NotNull(message = ExceptionMessages.MISSING_REQUEST_PARAMETERS)
    @Column(name = "model", nullable = false)
    private ModelEnum modelEnum ;

    @Enumerated(EnumType.ORDINAL)
    @NotNull(message = ExceptionMessages.MISSING_REQUEST_PARAMETERS)
    @Column(name = "state", nullable = false)
    private StateEnum stateEnum ;

    @OneToMany(mappedBy = "drone")
    Set<Registration> registrations;

        public Drone(RegisterDroneRequest registerDroneRequest){
            this.serialNumber=registerDroneRequest.getSerialNumber();
            this.batteryPercentage=registerDroneRequest.getBatteryPercentage();
            this.weight=registerDroneRequest.getWeight();
            this.modelEnum=registerDroneRequest.getModel();
            this.stateEnum=registerDroneRequest.getState();
        }
}

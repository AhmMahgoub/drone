package com.mahgoub.drone.entity;

import com.mahgoub.drone.common.request.RegisterDroneRequest;
import com.mahgoub.drone.enums.ModelEnum;
import com.mahgoub.drone.enums.StateEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Page;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "drone")
@Getter
@Setter
public class Drone {

    public Drone() {
    }

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
    @Max(value = 100,message = ExceptionMessages.INVALID_BATTERY_PERCENTAGE)
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

    @ManyToMany
    @JoinTable(
            name = "drone_medications",
            joinColumns = @JoinColumn(name = "drone_id"),
            inverseJoinColumns = @JoinColumn(name = "medication_id"))
    Set<Medication> droneMedications;

    public void addMedication(Medication medication) {
        this.droneMedications.add(medication);
        medication.getDrones().add(this);
    }

//    @OneToMany(mappedBy = "drone", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private Set<Medication> medications;

//    @OneToMany(mappedBy = "drone")
//    Set<Registration> registrations;

        public Drone(RegisterDroneRequest registerDroneRequest){
            this.serialNumber=registerDroneRequest.getSerialNumber();
            this.batteryPercentage=registerDroneRequest.getBatteryPercentage();
            this.weight=registerDroneRequest.getWeight();
            this.modelEnum=registerDroneRequest.getModel();
            this.stateEnum=registerDroneRequest.getState();
        }
}

package com.mahgoub.drone.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.awt.print.Book;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "medication")
@Getter @Setter
public class Medication {
    public Medication() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
    @Min(value = 10, message = ExceptionMessages.INVALID_MIN_WEIGHT_VALUE)
    @NotNull(message = ExceptionMessages.MISSING_REQUEST_PARAMETERS)
    private Integer weight ;

    @ManyToMany(mappedBy = "droneMedications")
    Set<Drone> drones;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "drone_id")
//    private Drone drone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @OneToMany(mappedBy = "medication")
//    Set<Registration> registrations;

}

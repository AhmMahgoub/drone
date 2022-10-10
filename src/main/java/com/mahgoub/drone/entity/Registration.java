package com.mahgoub.drone.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Registration {
    public Registration() {
    }

    @Id
    long id;

    @ManyToOne
    @JoinColumn(name = "drone_id")
    Drone drone;

    @ManyToOne
    @JoinColumn(name = "medication_id")
    Medication medication;

}

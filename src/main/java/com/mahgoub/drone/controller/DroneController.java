package com.mahgoub.drone.controller;

import com.mahgoub.drone.common.request.LoadDroneRequest;
import com.mahgoub.drone.common.request.RegisterDroneRequest;
import com.mahgoub.drone.entity.Drone;
import com.mahgoub.drone.service.drone.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class DroneController {

    @Autowired
    DroneService droneService;

    @PostMapping(path = "/register/drone", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerDrone(@RequestBody @Valid RegisterDroneRequest request) {
        Drone drone = droneService.registerDrone(request);
        return ResponseEntity.ok().body(drone);
    }

    @PostMapping(path = "/load/drone", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> loadDroneWithMedication(@RequestBody @Valid LoadDroneRequest request) {
        droneService.loadDroneWithMedications(request);
        return ResponseEntity.ok().body("loaded successfully");
    }


}

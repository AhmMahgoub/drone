package com.mahgoub.drone.controller;

import com.mahgoub.drone.common.request.LoadDroneRequest;
import com.mahgoub.drone.common.request.RegisterDroneRequest;
import com.mahgoub.drone.entity.Drone;
import com.mahgoub.drone.service.drone.DroneService;
import com.mahgoub.drone.service.medication.MedicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class DroneController {

    @Autowired
    DroneService droneService;

    @Autowired
    MedicationService medicationService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DroneController.class);

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

    @GetMapping(path = "/check/drone/medication")
    public ResponseEntity<?> checkMedicationsByDrone(@RequestParam("serialNumber") String serialNumber) {
        return ResponseEntity.ok().body(droneService.checkMedicationsByDrone(serialNumber));
    }

    @GetMapping(path = "/check/available/drones")
    public ResponseEntity<?> checkAvailableDrones() {
        return ResponseEntity.ok().body(droneService.checkAvailableDrones());
    }

    @GetMapping(path = "/check/drone/battery")
    public ResponseEntity<?> checkBatteryPercentageByDrone(@RequestParam("serialNumber") String serialNumber) {
        LOGGER.info("check Percentage of serial number [{}] ",serialNumber);
        return ResponseEntity.ok().body(droneService.findBatteryPercentageOfDrone(serialNumber));
    }
}

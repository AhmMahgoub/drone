package com.mahgoub.drone.service;

import com.mahgoub.drone.common.request.RegisterDroneRequest;
import com.mahgoub.drone.entity.Drone;
import com.mahgoub.drone.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DroneServiceImpl implements DroneService {

    @Autowired
    DroneRepository droneRepository;

    @Override
    public Drone registerDrone(RegisterDroneRequest registerDroneRequest) {

        Drone drone = new Drone(registerDroneRequest);

        return droneRepository.save(drone);
    }
}

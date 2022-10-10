package com.mahgoub.drone.service;

import com.mahgoub.drone.common.request.RegisterDroneRequest;
import com.mahgoub.drone.entity.Drone;
import org.springframework.http.ResponseEntity;

public interface DroneService {

    public Drone registerDrone(RegisterDroneRequest registerDroneRequest);
}

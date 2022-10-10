package com.mahgoub.drone.service.drone;

import com.mahgoub.drone.common.request.LoadDroneRequest;
import com.mahgoub.drone.common.request.RegisterDroneRequest;
import com.mahgoub.drone.entity.Drone;
import org.springframework.http.ResponseEntity;

public interface DroneService {

    public Drone registerDrone(RegisterDroneRequest registerDroneRequest);
    public void loadDroneWithMedications(LoadDroneRequest registerDroneRequest);
}

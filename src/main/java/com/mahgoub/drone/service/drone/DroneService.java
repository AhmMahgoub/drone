package com.mahgoub.drone.service.drone;

import com.mahgoub.drone.common.request.LoadDroneRequest;
import com.mahgoub.drone.common.request.RegisterDroneRequest;
import com.mahgoub.drone.common.response.DroneResponse;
import com.mahgoub.drone.common.response.MedicationResponse;
import com.mahgoub.drone.entity.Drone;
import com.mahgoub.drone.entity.Medication;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DroneService {

    public Drone registerDrone(RegisterDroneRequest registerDroneRequest);
    public void loadDroneWithMedications(LoadDroneRequest registerDroneRequest);
    public List<MedicationResponse> checkMedicationsByDrone(String serialNumber);
    public List<DroneResponse> checkAvailableDrones();
    public Integer findBatteryPercentageOfDrone(String serialNumber);

}

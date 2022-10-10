package com.mahgoub.drone.service.drone;

import com.mahgoub.drone.common.request.LoadDroneRequest;
import com.mahgoub.drone.common.request.RegisterDroneRequest;
import com.mahgoub.drone.entity.Drone;
import com.mahgoub.drone.entity.Medication;
import com.mahgoub.drone.repository.DroneRepository;
import com.mahgoub.drone.repository.MedicationRepository;
import com.mahgoub.drone.service.medication.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DroneServiceImpl implements DroneService {

    @Autowired
    DroneRepository droneRepository;
    @Autowired
    MedicationService medicationService;

    @Override
    public Drone registerDrone(RegisterDroneRequest registerDroneRequest) {

        Drone drone = new Drone(registerDroneRequest);

        return droneRepository.save(drone);
    }

    @Override
    @Transactional
    public void loadDroneWithMedications(LoadDroneRequest loadDroneRequest) {
        List<Medication> medicationList =medicationService.findAllMedicationsByCodes(loadDroneRequest.getMedicationCode());
        Integer wht = medicationList.stream().mapToInt(Medication::getWeight).sum();
        List drones =droneRepository.getAllIdleDrones(wht);
    }
}

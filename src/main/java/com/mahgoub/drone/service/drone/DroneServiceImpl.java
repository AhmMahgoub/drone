package com.mahgoub.drone.service.drone;

import com.mahgoub.drone.common.request.LoadDroneRequest;
import com.mahgoub.drone.common.request.RegisterDroneRequest;
import com.mahgoub.drone.common.response.DroneResponse;
import com.mahgoub.drone.common.response.MedicationResponse;
import com.mahgoub.drone.entity.Drone;
import com.mahgoub.drone.entity.ExceptionMessages;
import com.mahgoub.drone.entity.Medication;
import com.mahgoub.drone.enums.StateEnum;
import com.mahgoub.drone.exception.BusinessException;
import com.mahgoub.drone.exception.CustomValidationException;
import com.mahgoub.drone.repository.DroneRepository;
import com.mahgoub.drone.service.medication.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.stream.Collectors;

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
        Integer weightSum = medicationList.stream().mapToInt(Medication::getWeight).sum();

        //find idle and the minimum load can drone load
        List<Drone> drones =droneRepository.getAllIdleDrones(weightSum);
        if(drones.isEmpty()){
             throw new BusinessException("no available drone found");
        }
        Drone drone = drones.get(0);
        drone.setDroneMedications(new HashSet<>(medicationList));
        drone.setStateEnum(StateEnum.LOADING);
        droneRepository.save(drone);
    }

    @Override
    public List<MedicationResponse> checkMedicationsByDrone(String serialNumber) {
        Drone drone = droneRepository.getBySerialNumber(serialNumber);
        ArrayList<MedicationResponse> medications = new ArrayList<>();
        drone.getDroneMedications().forEach(o ->
                    {MedicationResponse medicationResponse = new MedicationResponse();
                    medicationResponse.setCode(o.getCode());
                    medicationResponse.setImage(o.getImage());
                    medicationResponse.setName(o.getName());
                    medicationResponse.setWeight(o.getWeight());
                    medications.add(medicationResponse);});

        return medications;
    }

    @Override
    public List<DroneResponse> checkAvailableDrones() {
        ArrayList<DroneResponse> drones = new ArrayList<>();
        droneRepository.getAllAvailableDrones().forEach(d -> {
            DroneResponse droneResponse = new DroneResponse();
            droneResponse.setMaximumWeight(d.getWeight());
            droneResponse.setModelName(d.getModelEnum().getName());
            droneResponse.setSerialNumber(d.getSerialNumber());
            droneResponse.setBatteryPercentage(d.getBatteryPercentage());
            drones.add(droneResponse);
        });
        return drones;
    }

    @Override
    public Integer findBatteryPercentageOfDrone(String serialNumber) {
        return droneRepository.getBatteryPercentageBySerialNumber(serialNumber);
    }
}

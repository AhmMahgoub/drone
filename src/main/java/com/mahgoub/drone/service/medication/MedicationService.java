package com.mahgoub.drone.service.medication;

import com.mahgoub.drone.entity.Drone;
import com.mahgoub.drone.entity.Medication;

import java.util.List;

public interface MedicationService {
    public List<Medication> findAllMedicationsByCodes(List<String> codes);

}

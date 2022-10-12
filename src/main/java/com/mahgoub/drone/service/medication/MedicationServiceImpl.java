package com.mahgoub.drone.service.medication;

import com.mahgoub.drone.entity.Medication;
import com.mahgoub.drone.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService{

    @Autowired
    MedicationRepository medicationRepository;

    @Override
    public List<Medication> findAllMedicationsByCodes(List<String> codes) {
        return medicationRepository.findAllByCodeIn(codes);
    }


}

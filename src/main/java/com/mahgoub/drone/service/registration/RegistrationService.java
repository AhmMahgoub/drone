package com.mahgoub.drone.service.registration;

import java.util.List;

public interface RegistrationService {
    public void saveMedicationsWithDrone(Integer droneId , List<Integer> medicationIds);
}

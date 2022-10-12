package com.mahgoub.drone.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@ActiveProfiles("test")
public class DroneValidationTest {

    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void whenInvalidDroneProperty_thenValidationFails() {
        Drone drone = new Drone();
        Set<ConstraintViolation<Drone>> violations = validator.validateProperty(drone, "serialNumber");
        Assertions.assertFalse(violations.isEmpty());

        drone.setSerialNumber(null);
        violations = validator.validateProperty(drone, "serialNumber");
        Assertions.assertFalse(violations.isEmpty());

        drone.setSerialNumber("testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest");
        violations = validator.validateProperty(drone, "serialNumber");
        Assertions.assertFalse(violations.isEmpty());

        drone.setWeight(null);
        violations = validator.validateProperty(drone, "weight");
        Assertions.assertFalse(violations.isEmpty());

        drone.setWeight(600);
        violations = validator.validateProperty(drone, "weight");
        Assertions.assertFalse(violations.isEmpty());

        drone.setBatteryPercentage(null);
        violations = validator.validateProperty(drone, "batteryPercentage");
        Assertions.assertFalse(violations.isEmpty());

        drone.setBatteryPercentage(101);
        violations = validator.validateProperty(drone, "batteryPercentage");
        Assertions.assertFalse(violations.isEmpty());

        drone.setStateEnum(null);
        violations = validator.validateProperty(drone, "stateEnum");
        Assertions.assertFalse(violations.isEmpty());

        drone.setModelEnum(null);
        violations = validator.validateProperty(drone, "modelEnum");
        Assertions.assertFalse(violations.isEmpty());
    }
}

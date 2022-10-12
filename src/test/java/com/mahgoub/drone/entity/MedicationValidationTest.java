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
public class MedicationValidationTest {

    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void whenInvalidMedicationProperty_thenValidationFails() {

        Medication medication = new Medication();
        Set<ConstraintViolation<Medication>> violations = validator.validateProperty(medication, "name");
        Assertions.assertFalse(violations.isEmpty());

        medication.setName(null);
        violations = validator.validateProperty(medication, "name");
        Assertions.assertFalse(violations.isEmpty());

        medication.setCode(null);
        violations = validator.validateProperty(medication, "code");
        Assertions.assertFalse(violations.isEmpty());

        medication.setCode("asd");
        violations = validator.validateProperty(medication, "code");
        Assertions.assertFalse(violations.isEmpty());

        medication.setCode("a--");
        violations = validator.validateProperty(medication, "code");
        Assertions.assertFalse(violations.isEmpty());

        medication.setCode(null);
        violations = validator.validateProperty(medication, "image");
        Assertions.assertFalse(violations.isEmpty());

        medication.setWeight(null);
        violations = validator.validateProperty(medication, "weight");
        Assertions.assertFalse(violations.isEmpty());

        medication.setWeight(5);
        violations = validator.validateProperty(medication, "weight");
        Assertions.assertFalse(violations.isEmpty());
    }

}

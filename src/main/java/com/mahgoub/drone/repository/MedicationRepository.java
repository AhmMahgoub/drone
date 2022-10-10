package com.mahgoub.drone.repository;

import com.mahgoub.drone.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationRepository extends JpaRepository<Medication,Long>, JpaSpecificationExecutor<Medication> {
    List<Medication> findAllByCodeIn(List<String> codes);
}

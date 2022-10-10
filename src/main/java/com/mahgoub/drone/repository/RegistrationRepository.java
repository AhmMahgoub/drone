package com.mahgoub.drone.repository;

import com.mahgoub.drone.entity.Medication;
import com.mahgoub.drone.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Long>, JpaSpecificationExecutor<Registration> {
}

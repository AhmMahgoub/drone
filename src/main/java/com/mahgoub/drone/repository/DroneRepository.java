package com.mahgoub.drone.repository;

import com.mahgoub.drone.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepository extends JpaRepository<Drone,Long>, JpaSpecificationExecutor<Drone> {

}

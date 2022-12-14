package com.mahgoub.drone.repository;

import com.mahgoub.drone.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DroneRepository extends JpaRepository<Drone,Long>, JpaSpecificationExecutor<Drone> {

    @Query("select d from Drone d where d.stateEnum =com.mahgoub.drone.enums.StateEnum.IDLE and d.weight > :weight and d.batteryPercentage > 25 order by d.weight")
    List<Drone> getAllIdleDrones(Integer weight);

    Drone getBySerialNumber(String serialNumber);

    @Query("select d from Drone d where d.stateEnum =com.mahgoub.drone.enums.StateEnum.IDLE")
    List<Drone> getAllAvailableDrones();

    @Query("select d.batteryPercentage from Drone d where d.serialNumber =:serialNumber")
    Integer getBatteryPercentageBySerialNumber(String serialNumber);

    List<Drone> findAll();
}

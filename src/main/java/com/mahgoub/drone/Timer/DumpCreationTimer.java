package com.mahgoub.drone.Timer;

import com.mahgoub.drone.service.drone.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DumpCreationTimer {

    @Autowired
    DroneService droneService;

  @Scheduled(cron = "*/20 * * * * *")
    public void checkDroneBatteryPercentage() {
      droneService.findDronesBatteryPercentage();
     }
}

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduling.enabled",matchIfMissing = true)
class schedulingConfiguration{

}
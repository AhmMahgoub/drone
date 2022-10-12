package com.mahgoub.drone.common.response;

import lombok.Data;

@Data
public class DroneBatteryResponse {
    private String serialNumber;
    private Integer batteryPercentage;
}

package com.mahgoub.drone.common.response;


import lombok.Data;

@Data
public class DroneResponse {

    private String serialNumber;
    private Integer maximumWeight;
    private Integer batteryPercentage;
    private String modelName;

}

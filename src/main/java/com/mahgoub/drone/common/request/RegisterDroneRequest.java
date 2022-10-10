package com.mahgoub.drone.common.request;

import com.mahgoub.drone.enums.ModelEnum;
import com.mahgoub.drone.enums.StateEnum;
import lombok.Data;

@Data
public class RegisterDroneRequest {

    private String serialNumber;
    private Integer weight;
    private Integer batteryPercentage;
    private ModelEnum model;
    private StateEnum state;

}

package com.mahgoub.drone.common.request;

import lombok.Data;

import java.util.List;

@Data
public class LoadDroneRequest {
    private List<String> medicationCode;
}

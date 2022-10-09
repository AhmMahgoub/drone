package com.mahgoub.drone.enums;

public enum ModelEnum {

    LIGHT_WEIGHT("Lightweight"),
    MIDDLE_WEIGHT("Middleweight"),
    CRUISER_WEIGHT("Cruiserweight"),
    HEAVY_WEIGHT("Heavyweight");

    private final String name;

    ModelEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

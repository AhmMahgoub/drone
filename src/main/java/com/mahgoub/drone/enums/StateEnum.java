package com.mahgoub.drone.enums;

public enum StateEnum {

    IDLE("IDLE"),
    LOADING("LOADING"),
    LOADED("LOADED"),
    DELIVERING("DELIVERING"),
    DELIVERED("DELIVERED"),
    RETURNING("RETURNING");

    private final String name;

    StateEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

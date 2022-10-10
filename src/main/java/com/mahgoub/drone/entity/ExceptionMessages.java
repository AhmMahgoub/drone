package com.mahgoub.drone.entity;

public class ExceptionMessages {
    public static final String MISSING_REQUEST_PARAMETERS="Missing Request Parameter";
    public static final String INVALID_SERIAL_NUMBER_LENGTH="Invalid Serial Number : Should be lower than 100 characters";
    public static final String INVALID_MAX_WEIGHT_VALUE="Invalid Weight : Should be lower than 500 gr";
    public static final String INVALID_MIN_WEIGHT_VALUE="Invalid Weight : Should be more than 10 gr";
    public static final String INVALID_MEDICATION_NAME_PATTERN="Invalid input : allowed only letters, numbers, ‘-‘, ‘_’";
    public static final String INVALID_MEDICATION_CODE_PATTERN="allowed only upper case letters, underscore and numbers";
    public static final String INVALID_BATTERY_PERCENTAGE="maximum value of battery should be 100";

}

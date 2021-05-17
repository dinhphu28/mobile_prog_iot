package com.anthony.smarthome.Models.devices;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class devicesNewModel {
    private String deviceName;

    private String deviceDescription;

    private boolean deviceType;

    private boolean dataType;

    private boolean bitValue;

    private float decimalValue;
}

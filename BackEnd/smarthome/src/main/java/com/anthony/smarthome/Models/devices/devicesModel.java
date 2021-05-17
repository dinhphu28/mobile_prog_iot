package com.anthony.smarthome.Models.devices;


import com.anthony.smarthome.Entities.devices;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class devicesModel {
    private Integer id;

    private String deviceName;

    private String deviceDescription;

    private boolean deviceType;

    private boolean dataType;

    private boolean bitValue;

    private float decimalValue;

    public devicesModel(devices device) {
        this.id = device.getId();
        this.deviceName = device.getDeviceName();
        this.deviceDescription = device.getDeviceDescription();
        this.deviceType = device.isDeviceType();
        this.dataType = device.isDataType();
        this.bitValue = device.isBitValue();
        this.decimalValue = device.getDecimalValue();
    }
}

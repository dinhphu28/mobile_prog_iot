package com.anthony.smarthome.Models.devices;

import com.anthony.smarthome.Entities.devices;

public class AdapterDevices {
    public devices convertFromModelToDeviceEntity(devicesNewModel devicesmodel) {
        devices dvc = new devices();

        dvc.setId(null);
        dvc.setDeviceName(devicesmodel.getDeviceName());
        dvc.setDeviceDescription(devicesmodel.getDeviceDescription());
        dvc.setDeviceType(devicesmodel.isDeviceType());
        dvc.setDataType(devicesmodel.isDataType());
        dvc.setBitValue(devicesmodel.isBitValue());
        dvc.setDecimalValue(devicesmodel.getDecimalValue());

        return dvc;
    }
}

package com.anthony.smarthome.Models.devices;

import com.anthony.smarthome.Entities.devices;

public class AdapterDevices {
    public devices convertFromNewModelToDeviceEntity(devicesNewModel devicesmodel) {
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

    public devices convertFromModelToDeviceEntity(devicesModel devicesmodel) {
        devices dvc = new devices();

        dvc.setId(devicesmodel.getId());
        dvc.setDeviceName(devicesmodel.getDeviceName());
        dvc.setDeviceDescription(devicesmodel.getDeviceDescription());
        dvc.setDeviceType(devicesmodel.isDeviceType());
        dvc.setDataType(devicesmodel.isDataType());
        dvc.setBitValue(devicesmodel.isBitValue());
        dvc.setDecimalValue(devicesmodel.getDecimalValue());

        return dvc;
    }
}

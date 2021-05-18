package com.anthony.smarthome.Models.devices.logs;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class devicelogsNewModel {
    private Integer deviceId;

    private boolean bitValue;

    private float decimalValue;

    private LocalDate dateRecord;

    private LocalTime timeRecord;
}

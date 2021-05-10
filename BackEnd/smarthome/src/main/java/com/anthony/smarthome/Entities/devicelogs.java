package com.anthony.smarthome.Entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "devicelogs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class devicelogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")
    private Integer id; // identity: start at 1, step is 1

    @Column(name = "deviceid")
    private Integer deviceId;   // device id; Maximum 10 logs for each device

    @Column(name = "bitvalue")
    private boolean bitValue;   // default: 0

    @Column(name = "decimalvalue")
    private float decimalValue; // default: 0

    @Column(name = "daterecord")
    private LocalDate dateRecord;

    @Column(name = "timerecord")
    private LocalTime timeRecord;
}

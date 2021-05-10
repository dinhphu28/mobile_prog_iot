package com.anthony.smarthome.Entities;

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
@Table(name = "devices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class devices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")
    private Integer id; // identity: start at 1, step is 1

    @Column(name = "devicename")
    private String deviceName;  // max length 50

    @Column(name = "devicedescription")
    private String deviceDescription;   // max length 250

    @Column(name = "devicetype")
    private boolean deviceType; // 0: input | 1: output

    @Column(name = "datatype")
    private boolean dataType;   // 0: bit | 1: decimal

    @Column(name = "bitvalue")
    private boolean bitValue;   // default: 0

    @Column(name = "decimalvalue")
    private float decimalValue; // default: 0
}

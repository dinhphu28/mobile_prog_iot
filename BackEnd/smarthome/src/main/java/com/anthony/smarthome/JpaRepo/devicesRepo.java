package com.anthony.smarthome.JpaRepo;

import com.anthony.smarthome.Entities.devices;

import org.springframework.data.jpa.repository.JpaRepository;

public interface devicesRepo extends JpaRepository<devices, Integer> {

}

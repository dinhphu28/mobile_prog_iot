package com.anthony.smarthome.JpaRepo;

import com.anthony.smarthome.Entities.devicelogs;

import org.springframework.data.jpa.repository.JpaRepository;

public interface devicelogsRepo extends JpaRepository<devicelogs, Integer> {

}

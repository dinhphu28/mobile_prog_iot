package com.anthony.smarthome.JpaRepo;

import java.util.List;

import com.anthony.smarthome.Entities.devicelogs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface devicelogsRepo extends JpaRepository<devicelogs, Integer> {

    List<devicelogs> findTop10BydeviceIdOrderByIdDesc(Integer id);

    Long deleteBydeviceId(Integer id);
}

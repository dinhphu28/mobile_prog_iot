package com.anthony.smarthome.JpaRepo;

import com.anthony.smarthome.Entities.accounts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface accountsRepo extends JpaRepository<accounts, String> {

}

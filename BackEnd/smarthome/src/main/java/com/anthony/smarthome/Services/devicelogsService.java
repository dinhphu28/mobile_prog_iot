package com.anthony.smarthome.Services;

import com.anthony.smarthome.Entities.devicelogs;
import com.anthony.smarthome.JpaRepo.devicelogsRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class devicelogsService {
    @Autowired
    private devicelogsRepo repo;

    public devicelogs getone(Integer id) {
        return repo.findById(id).get();
    }



    public boolean create(devicelogs dlog) {
        devicelogs tmp = null;

        boolean kk = false;

        try {
            dlog.setId(0);

            repo.save(dlog);

            kk = true;
        } catch (Exception e) {
            //TODO: handle exception
        }

        return kk;
    }
}

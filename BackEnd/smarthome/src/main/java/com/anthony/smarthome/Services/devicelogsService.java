package com.anthony.smarthome.Services;

import java.util.List;

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

    public List<devicelogs> gettop10ofonedevice(Integer id) {
        return repo.findTop10BydeviceIdOrderByIdDesc(id);
    }

    public boolean create(devicelogs dlog) {
        devicelogs tmp = null;

        boolean kk = false;

        try {
            // tmp = getone(dlog.getId());

            repo.save(dlog);

            kk = true;
        } catch (Exception e) {
            //TODO: handle exception
        }

        return kk;
    }

    public Long deleteallofonedevice(Integer id) {
        return repo.deleteBydeviceId(id);
    }
}

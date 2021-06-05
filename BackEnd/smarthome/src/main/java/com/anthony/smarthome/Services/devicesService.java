package com.anthony.smarthome.Services;

import java.util.List;

import com.anthony.smarthome.Entities.devices;
import com.anthony.smarthome.JpaRepo.devicesRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class devicesService {
    @Autowired
    private devicesRepo repo;

    @Autowired
    private devicelogsService service;

    public devices getone(Integer id) {
        return repo.findById(id).get();
    }

    public List<devices> getall() {
        return repo.findAll();
    }

    public boolean create(devices device) {
        devices tmp = null;

        boolean kk = false;

        try {
            if(device.getId() != null) {
                tmp = getone(device.getId());
            }
        } catch (Exception e) {
            //TODO: handle exception
        }

        if(tmp == null) {
            kk = true;
        }

        if(kk) {
            repo.save(device);
        }

        return kk;
    }

    public boolean save(devices device) {
        devices tmp = null;

        boolean kk = false;

        try {
            if(device.getId() != null) {
                tmp = getone(device.getId());

                if(tmp != null) {
                    kk = true;
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
        }

        if(kk) {
            repo.save(device);
        }

        return kk;
    }

    public boolean delete(Integer id) {
        boolean kk = false;

        try {
            devices dvc = null;
            dvc = getone(id);

            if(dvc != null) {
                if(dvc.getId() == id) {
                    Long nodeled = Long.valueOf(-1);

                    nodeled = service.deleteallofonedevice(id);

                    repo.deleteById(id);

                    kk = true;
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
        }

        return kk;
    }
}

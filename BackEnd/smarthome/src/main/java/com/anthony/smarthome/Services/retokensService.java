package com.anthony.smarthome.Services;

import com.anthony.smarthome.Entities.retokens;
import com.anthony.smarthome.JpaRepo.retokensRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class retokensService {
    @Autowired
    private retokensRepo repo;

    public retokens getone(String username) {
        return repo.findById(username).get();
    }

    public boolean save(retokens token) {
        retokens tmp = null;

        boolean kk = false;

        try {
            if(token.getUsername() != null) {
                tmp = getone(token.getUsername());

                if(tmp != null) {
                    kk = true;
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
        }

        if(kk) {
            repo.save(token);
        }

        return kk;
    }
}

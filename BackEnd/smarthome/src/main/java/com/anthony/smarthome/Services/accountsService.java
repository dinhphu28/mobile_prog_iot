package com.anthony.smarthome.Services;

import com.anthony.smarthome.Entities.accounts;
import com.anthony.smarthome.JpaRepo.accountsRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class accountsService {
    @Autowired
    private accountsRepo repo;

    public accounts getone(String username) {
        return repo.findById(username).get();
    }

    public boolean save(accounts account) {
        accounts tmp = null;

        boolean kk = false;

        try {
            if(account.getUsername() != null) {
                tmp = getone(account.getUsername());

                if(tmp != null) {
                    kk = true;
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
        }

        if(kk) {
            repo.save(account);
        }

        return kk;
    }
}

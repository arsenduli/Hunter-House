package com.betaplan.arsen.beltexamattemptow.services;

import com.betaplan.arsen.beltexamattemptow.models.Hunter;
import com.betaplan.arsen.beltexamattemptow.repositories.HunterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HunterServices {
    @Autowired
    private HunterRepo hunterRepo;

    public HunterServices(HunterRepo hunterRepo) {
        this.hunterRepo = hunterRepo;
    }

    //find all
    public List<Hunter> getAllHunter(){
        return hunterRepo.findAll();
    }
    // find by id
    public Hunter getByIdHunter(Long id){
        Optional<Hunter> optional = hunterRepo.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }
    //create
    public Hunter createHunter(Hunter hunter){
        return hunterRepo.save(hunter);
    }
    //update
    public Hunter updateHunter(Hunter hunter){
        return hunterRepo.save(hunter);
    }
    //delete by id
    public void deleteHunterById(Hunter hunter){
        hunterRepo.delete(hunter);
    }
}

package com.betaplan.arsen.beltexamattemptow.repositories;

import com.betaplan.arsen.beltexamattemptow.models.Hunter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HunterRepo extends CrudRepository<Hunter , Long> {
    List<Hunter> findAll();
}

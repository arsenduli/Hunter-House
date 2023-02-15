package com.betaplan.arsen.beltexamattemptow.repositories;

import com.betaplan.arsen.beltexamattemptow.models.Hunter;
import com.betaplan.arsen.beltexamattemptow.models.Notes;
import com.betaplan.arsen.beltexamattemptow.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepo extends CrudRepository<Notes , Long> {
    List<Notes> findAll();

    List<Notes> findAllByHunterNote(Hunter hunter);
    List<Notes> findAllByUserNote(User user);

}

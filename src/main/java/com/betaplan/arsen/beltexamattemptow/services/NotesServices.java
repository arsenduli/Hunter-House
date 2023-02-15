package com.betaplan.arsen.beltexamattemptow.services;

import com.betaplan.arsen.beltexamattemptow.models.Hunter;
import com.betaplan.arsen.beltexamattemptow.models.Notes;
import com.betaplan.arsen.beltexamattemptow.models.User;
import com.betaplan.arsen.beltexamattemptow.repositories.NotesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotesServices {

    @Autowired
    private NotesRepo notesRepo;

    public NotesServices(NotesRepo notesRepo) {
        this.notesRepo = notesRepo;
    }


    //find all
    public List<Notes> getAllNotes(){
        return notesRepo.findAll();
    }
    public Notes getNotesById(Long id){
        Optional<Notes> optional = notesRepo.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;

    }

    public List<Notes> getByHunter(Hunter hunter){
        return notesRepo.findAllByHunterNote(hunter);
    }
    public List<Notes> getByUser(User user){
        return notesRepo.findAllByUserNote(user);
    }

    public Notes createNotes(Notes notes){
        return notesRepo.save(notes);
    }

    public void  deletenotes(Notes notes)
    {
        notesRepo.delete(notes);
    }
}

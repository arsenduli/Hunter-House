package com.betaplan.arsen.beltexamattemptow.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "note")
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String addNotes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userNote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hunter_id")
    private Hunter hunterNote;

    public Notes() {
    }

    public Notes(Long id, String addNotes, User userNote, Hunter hunterNote) {
        this.id = id;
        this.addNotes = addNotes;
        this.userNote = userNote;
        this.hunterNote = hunterNote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddNotes() {
        return addNotes;
    }

    public void setAddNotes(String addNotes) {
        this.addNotes = addNotes;
    }

    public User getUserNote() {
        return userNote;
    }

    public void setUserNote(User userNote) {
        this.userNote = userNote;
    }

    public Hunter getHunterNote() {
        return hunterNote;
    }

    public void setHunterNote(Hunter hunterNote) {
        this.hunterNote = hunterNote;
    }
}



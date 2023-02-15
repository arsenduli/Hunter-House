package com.betaplan.arsen.beltexamattemptow.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "hunter")
public class Hunter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 4)
    private String address;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Past
    private Date listedOn;
    @NotNull()
    @Min(1)
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User added;

    @OneToMany(mappedBy = "hunterNote", cascade =  CascadeType.ALL ,fetch = FetchType.LAZY)
    private List<Notes> noteHunter;
    public Hunter() {
    }

    public Hunter(Long id, String address, String listedOn, Double price, User added, List<Notes> noteHunter) {
        this.id = id;
        this.address = address;
        this.price = price;
        this.added = added;
        this.noteHunter = noteHunter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getListedOn() {
        return listedOn;
    }

    public void setListedOn(Date listedOn) {
        this.listedOn = listedOn;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public User getAdded() {
        return added;
    }

    public void setAdded(User added) {
        this.added = added;
    }

    public List<Notes> getNoteHunter() {
        return noteHunter;
    }

    public void setNoteHunter(List<Notes> noteHunter) {
        this.noteHunter = noteHunter;
    }
}

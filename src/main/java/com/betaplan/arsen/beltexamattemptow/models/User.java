package com.betaplan.arsen.beltexamattemptow.models;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty()
    @Size(min = 3)
    private String userName;
    @NotEmpty()
    @Email
    private String email;
    @NotEmpty()
    @Size(min = 8)
    private String password;
    @Transient
    private String passwordConfirmation;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateAt;

    @PrePersist
    protected void onCreate(){
        this.createAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updateAt = new Date();
    }
    @OneToMany(mappedBy = "userNote",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Notes> makeNotes;
    @OneToMany(mappedBy = "added" , fetch = FetchType.LAZY)
    private List<Hunter> hunters;
    public User() {
    }

    public User(Long id, String userName, String email, String password, String passwordConfirmation, Date createAt, Date updateAt) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public List<Notes> getMakeNotes() {
        return makeNotes;
    }

    public void setMakeNotes(List<Notes> makeNotes) {
        this.makeNotes = makeNotes;
    }

    public List<Hunter> getHunters() {
        return hunters;
    }

    public void setHunters(List<Hunter> hunters) {
        this.hunters = hunters;
    }
}

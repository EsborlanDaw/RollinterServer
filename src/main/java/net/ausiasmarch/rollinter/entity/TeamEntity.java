package net.ausiasmarch.rollinter.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "team")
@JsonIgnoreProperties({"hibernateLazyInitialize", "handler"})

public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private final List<UserEntity> users;

    private LocalDateTime creationdate;

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private UserEntity user;



    public LocalDateTime getCreationdate() {
        return creationdate;
    }


    public void setCreationdate(LocalDateTime creationdate) {
        this.creationdate = creationdate;
    }


    public TeamEntity() {
        this.users = new ArrayList<>();
    }

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Long getUser() {
        return user.getId();
    }


    public void setUser(UserEntity user) {
        this.user = user;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getUsers() {
        return users.size();
    }

     @PreRemove
    public void nullify(){
        this.users.forEach(c ->
                                c.setTeam(null));                  
    } 


}

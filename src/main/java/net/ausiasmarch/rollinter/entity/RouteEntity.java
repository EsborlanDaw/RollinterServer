package net.ausiasmarch.rollinter.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "route")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class RouteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "zone", fetch = FetchType.LAZY)
    private final List <ZoneEntity> zones;

    private String dificulty;
    private String time;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_city")
    private CityEntity city;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private UserEntity user;

    public RouteEntity(List<ZoneEntity> zones) {
        this.zones = new ArrayList<>();
    }

    public RouteEntity(Long id, ZoneEntity zones) {
        this.id = id;
        this.zones = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getZones() {
        return zones.size();
    }

    public String getDificulty() {
        return dificulty;
    }

    public void setDificulty(String dificulty) {
        this.dificulty = dificulty;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    

    public void setCity(CityEntity city) {
        this.city = city;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @PreRemove
    public void nullify() {
        this.zones.forEach(c -> c.setRoute(null));
    }

}

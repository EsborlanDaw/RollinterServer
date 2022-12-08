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
@Table(name = "city")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
    private final List <RouteEntity> routes;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_country")
    private CountryEntity country;

    

    public CityEntity(List<RouteEntity> routes) {
        this.routes = new ArrayList<>();
    }

    public CityEntity(Long id, List<RouteEntity> routes) {
        this.id = id;
        this.routes = new ArrayList<>();
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

    public void setName(String name) {
        this.name = name;
    }

    public int getRoutes() {
        return routes.size();
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }


    @PreRemove
    public void nullify() {
        this.routes.forEach(c -> c.setCity(null));
    }

   
    

    
    
}

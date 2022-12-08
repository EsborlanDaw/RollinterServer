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
@Table(name = "country")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class CountryEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private final List <CityEntity> cities;
    

    public CountryEntity(List<CityEntity> routes) {
        this.cities = new ArrayList<>();
    }

    public CountryEntity(Long id,List<CityEntity> routes) {
        this.cities = new ArrayList<>();
        this.id = id;
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

    public int getCities() {
        return cities.size();
    }

    @PreRemove
    public void nullify() {
        this.cities.forEach(c -> c.setCountry(null));
    }


}

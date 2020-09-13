package com.bookmyshow.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cities")
public class City extends Auditable {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String state;
    @Getter
    @Setter
    private String country;

    @Getter
    @Setter
    @OneToMany
    private List<Cinema> cinemas = new ArrayList<>();

    public City() {
    }

    public City(String name, String state, String country) {
        this.name = name;
        this.state = state;
        this.country = country;
    }
}

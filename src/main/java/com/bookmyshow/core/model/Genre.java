package com.bookmyshow.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="genres")
public class Genre extends Auditable {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String description;

    @ManyToMany
    @Getter
    @Setter
    private List<Movie> movies = new ArrayList<>();

}

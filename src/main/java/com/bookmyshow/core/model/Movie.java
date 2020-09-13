package com.bookmyshow.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie extends Auditable {
    // atribs
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String director;
    @Getter
    @Setter
    private MPAARating mpaaRating;
    @Getter
    @Setter
    private String language;
    @Getter
    @Setter
    private Date releaseDate;
    @Getter
    @Setter
    private int durationMinutes;
    @Getter
    @Setter
    private String summary;

    // relationships
    @ManyToMany
    @Getter
    @Setter
    private List<Genre> genres = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    @Getter
    @Setter
    private List<MovieShow> shows = new ArrayList<>();

}

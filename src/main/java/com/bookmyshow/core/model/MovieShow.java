package com.bookmyshow.core.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movieshows")
public class MovieShow extends Auditable {
    @ManyToOne
    @JsonBackReference
    @NotNull
    @Getter
    @Setter
    private Movie movie;

    @Getter
    @Setter
    private Date timingFrom;
    @Getter
    @Setter
    private Date timingTo;

    @Getter
    @Setter
    @ManyToOne
    private Auditorium hall;

    @OneToMany(mappedBy = "show")
    @Getter
    @Setter
    private List<Booking> bookings = new ArrayList<>();


    public MovieShow() {
    }

    public MovieShow(Movie movie, Date timingFrom, Date timingTo) {
        this.movie = movie;
        this.timingFrom = timingFrom;
        this.timingTo = timingTo;
    }
}

package com.bookmyshow.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="auditoriums")
public class Auditorium extends Auditable {
    // attrib
    private String name;
    private boolean hasAirConditioning;
    private boolean supports3D;
    private int numberOfExits;
    private int numberOfEmergencyExits;

    //relationships
    @ManyToOne
    @Getter
    @Setter
    private Cinema cinema;

    @OneToMany(mappedBy = "auditorium")
    @Getter @Setter
    private List<AudiSeat> seats = new ArrayList<>();

    @OneToMany(mappedBy = "auditorium")
    @Getter @Setter
    private List<MovieShow> shows = new ArrayList<>();
}

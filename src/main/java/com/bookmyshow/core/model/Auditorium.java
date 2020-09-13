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
@Table(name = "auditoriums")
public class Auditorium extends Auditable {
    @ManyToOne
    @Getter
    @Setter
    private Cinema cinema;
    @Getter
    @Setter
    private boolean hasAirConditioner;
    @Getter
    @Setter
    private int numberOfExits;
    @Getter
    @Setter
    private int numberOfEmergencyExits;
    @Getter
    @Setter
    private boolean canHost3D;
    @Getter
    @Setter
    private String hallName;
    @Getter
    @Setter
    @OneToMany
    private List<AudiSeat> seats = new ArrayList<>();
    @Getter
    @Setter
    @OneToMany
    private List<MovieShow> shows = new ArrayList<>();

    public Auditorium() {
    }

    private Auditorium(Cinema cinema, String hallName) {
        this.cinema = cinema;
        this.hallName = hallName;
    }

    public static final class Builder {
        private Cinema cinema;
        private boolean hasAirConditioner;
        private int numberOfExits;
        private int numberOfEmergencyExits;
        private boolean canHost3D;
        private String hallName;
        private List<AudiSeat> seats;
        private List<MovieShow> shows;

        private Builder(Cinema cinema, String hallName) {
            this.cinema = cinema;
            this.hallName = hallName;
        }

        public static Builder aCinemaHall(Cinema cinema, String hallName) {
            return new Builder(cinema, hallName);
        }

        public Builder withHasAirConditioner(boolean hasAirConditioner) {
            this.hasAirConditioner = hasAirConditioner;
            return this;
        }

        public Builder withNumberOfExits(int numberOfExits) {
            this.numberOfExits = numberOfExits;
            return this;
        }

        public Builder withNumberOfEmergencyExits(int numberOfEmergencyExits) {
            this.numberOfEmergencyExits = numberOfEmergencyExits;
            return this;
        }

        public Builder withCanHost3D(boolean canHost3D) {
            this.canHost3D = canHost3D;
            return this;
        }

        public Builder withSeats(List<AudiSeat> seats) {
            this.seats = seats;
            return this;
        }

        public Builder withShows(List<MovieShow> shows) {
            this.shows = shows;
            return this;
        }

        public Auditorium build() {
            Auditorium auditorium = new Auditorium(cinema, hallName);
            auditorium.setHasAirConditioner(hasAirConditioner);
            auditorium.setNumberOfExits(numberOfExits);
            auditorium.setNumberOfEmergencyExits(numberOfEmergencyExits);
            auditorium.setCanHost3D(canHost3D);
            auditorium.setSeats(seats);
            auditorium.setShows(shows);
            return auditorium;
        }
    }
}

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
@Table(name = "cinemas")
public class Cinema extends Auditable {
    @Getter
    @Setter
    @ManyToOne
    private City city;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String address;
    @Getter
    @Setter
    @OneToMany
    private List<Auditorium> halls = new ArrayList<>();
    @Getter
    @Setter
    private boolean hasParking;
    @Getter
    @Setter
    private boolean hasDiner;

    public Cinema() {
    }

    private Cinema(City city, String name) {
        this.city = city;
        this.name = name;
    }

    public static final class Builder {
        private City city;
        private String name;
        private String address;
        private List<Auditorium> halls;
        private boolean hasParking;
        private boolean hasDiner;

        private Builder(City city, String name) {
            this.city = city;
            this.name = name;
        }

        public static Builder aCinema(City city, String name) {
            return new Builder(city, name);
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder withHalls(List<Auditorium> halls) {
            this.halls = halls;
            return this;
        }

        public Builder withHasParking(boolean hasParking) {
            this.hasParking = hasParking;
            return this;
        }

        public Builder withHasDiner(boolean hasDiner) {
            this.hasDiner = hasDiner;
            return this;
        }

        public Cinema build() {
            Cinema cinema = new Cinema(city, name);
            cinema.setAddress(address);
            cinema.setHalls(halls);
            cinema.setHasParking(hasParking);
            cinema.setHasDiner(hasDiner);
            return cinema;
        }
    }
}

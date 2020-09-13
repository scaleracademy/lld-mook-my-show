package com.bookmyshow.core.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "seatfeatures")
public class SeatFeature extends Auditable {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String description;


    public SeatFeature() {
    }

    public SeatFeature(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

package com.bookmyshow.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "audiseats")
public class AudiSeat extends Auditable {
    @Getter
    @Setter
    @OneToMany
    private List<ShowSeat> showSeats = new ArrayList<>();

    @Getter
    @Setter
    @ManyToMany
    private List<SeatFeature> features = new ArrayList<>();
    @Getter
    @Setter
    private String rowNumber;
    @Getter
    @Setter
    private String seatNumber;

    public AudiSeat() {}

    public AudiSeat(String rowNumber, String seatNumber) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
    }

}

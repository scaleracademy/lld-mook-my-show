package com.bookmyshow.core.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking extends Auditable {
    @ManyToOne
    @JsonManagedReference
    @Getter
    @Setter
    private MovieShow show;

    @OneToMany
    @Getter
    @Setter
    private List<Transaction> transactions = new ArrayList<>();

    @OneToMany
    @Getter
    @Setter
    private List<ShowSeat> seats = new ArrayList<>();

    @Getter
    @Setter
    private double totalPrice = 0;

    @ManyToOne
    @Getter
    @Setter
    private Coupon coupon;

    public int numberOfSeats() {
        return seats.size();
    }
}

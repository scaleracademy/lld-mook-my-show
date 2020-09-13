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
@Table(name="bookings")
public class Booking extends Auditable {
    // attribs
    @Getter @Setter
    private double totalPrice = 0;

    // relationships
    @ManyToOne
    @Getter @Setter
    private MovieShow show;

    @OneToMany
    @Getter @Setter
    private List<ShowSeat> seats = new ArrayList<>();

    @OneToMany
    @Getter @Setter
    private List<Transaction> transactions = new ArrayList<>();

    @ManyToOne
    @Getter @Setter
    private Coupon coupon;

    @ManyToOne
    @Getter @Setter
    private User user;
}


// in the booking table, column called show which contains foreignkey to MovieShow table

// Users table has a column called profileID
// Profiles table has a column called userID
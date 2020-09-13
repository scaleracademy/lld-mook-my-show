package com.bookmyshow.core.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="bookings")
public class Booking extends Auditable {

}

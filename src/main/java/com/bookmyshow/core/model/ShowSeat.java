package com.bookmyshow.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "showseats")
public class ShowSeat extends Auditable {
    @Getter
    @Setter
    @ManyToOne
    private Booking booking;
    @Getter
    @Setter
    @ManyToOne
    private MovieShow show;
    @Getter
    @Setter
    private ShowSeatStatus status = ShowSeatStatus.AVAILABLE;
    @Getter
    @Setter
    private double price;

    private ShowSeat(MovieShow show, double price) {
        this.show = show;
        this.price = price;
    }

    public static final class Builder {
        private Booking booking;
        private MovieShow show;
        private ShowSeatStatus status;
        private double price;

        private Builder(MovieShow show, double price) {
            this.show = show;
            this.price = price;
        }

        public static Builder aShowSeat(MovieShow show, double price) {
            return new Builder(show, price);
        }

        public Builder withBooking(Booking booking) {
            this.booking = booking;
            return this;
        }

        public Builder withStatus(ShowSeatStatus status) {
            this.status = status;
            return this;
        }

        public ShowSeat build() {
            ShowSeat showSeat = new ShowSeat(show, price);
            showSeat.setBooking(booking);
            showSeat.setStatus(status);
            return showSeat;
        }
    }
}

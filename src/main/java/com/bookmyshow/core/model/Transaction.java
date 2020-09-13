package com.bookmyshow.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction extends Auditable {
    @Getter
    @Setter
    @ManyToOne
    private Booking booking;
    @Getter
    @Setter
    private TransactionStatus status = TransactionStatus.NEW;
    @Getter
    @Setter
    private String paymentGateway;
    @Getter
    @Setter
    private double amount;
}

package com.bookmyshow.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "coupons")
public class Coupon extends Auditable {
    @Getter
    @Setter
    private String code;
    @Getter
    @Setter
    private int maxUsage;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @Getter
    @Setter
    private Date expiresOn = new Date();

    private Coupon(String code) {
        this.code = code;
    }

    public Coupon() {
    }

    public static final class CouponBuilder {
        private String code;
        private int maxUsage;
        private Date expiresOn;

        private CouponBuilder(String code) {
            this.code = code;
        }

        public static CouponBuilder aCoupon(String code) {
            return new CouponBuilder(code);
        }

        public CouponBuilder withMaxUsage(int maxUsage) {
            this.maxUsage = maxUsage;
            return this;
        }

        public CouponBuilder withExpiresOn(Date expiresOn) {
            this.expiresOn = expiresOn;
            return this;
        }

        public Coupon build() {
            Coupon coupon = new Coupon(code);
            coupon.setMaxUsage(maxUsage);
            coupon.setExpiresOn(expiresOn);
            return coupon;
        }
    }
}

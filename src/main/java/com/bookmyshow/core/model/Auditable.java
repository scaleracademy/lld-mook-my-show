package com.bookmyshow.core.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.StringIdGenerator.class,
        property = "id"
)
public abstract class Auditable implements Serializable {
    @Id
    @GeneratedValue(generator = "sequence",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence",
            allocationSize = 10)
    @Getter
    @Setter
    private Long id;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    private Date createdAt = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(nullable = false)
    @Getter
    @Setter
    private Date updatedAt = new Date();

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Auditable)
            return ((Auditable) obj).getId().equals(getId());
        return super.equals(obj);
    }
}

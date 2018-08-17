package com.resolution.domain.entity.base;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="CREATED_AT", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
//    @CreationTimestamp
    @CreatedDate
    private Date createdAt;

    @Column(name="UPDATED_AT", nullable = false)
    @Temporal(TemporalType.DATE)
    @UpdateTimestamp
    private Date updatedAt;

}

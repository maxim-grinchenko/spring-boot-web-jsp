package com.resolution.controller;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * A Region.
 */
@Data
@Entity
@Table(name = "region")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//@Document(indexName = "region")
public class Region extends AbstractAuditingEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @NotNull
    @Column(name = "ru", nullable = false)
    private String ru;

    @NotNull
    @Column(name = "kk", nullable = false)
    private String kk;

    @Column(name = "en")
    private String en;

    @NotNull
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    @Column(name = "kato", unique = true)
    private String kato;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

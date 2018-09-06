package com.resolution.controller;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A RegionDepInfo.
 */
@Data
@Entity
@Table(name = "region_dep_info")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//@Document(indexName = "regiondepinfo")
public class RegionDepInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "name_ru", nullable = false)
    private String nameRu;

    @NotNull
    @Column(name = "name_kk", nullable = false)
    private String nameKk;

    @Column(name = "name_en")
    private String nameEn;

    @NotNull
    @Column(name = "description_ru", nullable = false)
    private String descriptionRu;

    @NotNull
    @Column(name = "description_kk", nullable = false)
    private String descriptionKk;

    @Column(name = "description_en")
    private String descriptionEn;

    @NotNull
    @Column(name = "full_address_ru", nullable = false)
    private String fullAddressRu;

    @NotNull
    @Column(name = "full_address_kk", nullable = false)
    private String fullAddressKk;

    @Column(name = "full_address_en")
    private String fullAddressEn;

    @Column(name = "lat")
    private String lat;

    @Column(name = "lon")
    private String lon;

    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Column(name = "phone_1", nullable = false)
    private String phone1;

    @Column(name = "phone_2")
    private String phone2;

    @Column(name = "website")
    private String website;

    @Column(name = "note")
    private String note;

    @ManyToOne
    private Region region;


}

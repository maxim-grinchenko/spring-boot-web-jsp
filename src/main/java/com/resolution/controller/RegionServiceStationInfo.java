package com.resolution.controller;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A RegionServiceStationInfo.
 */
@Data
@Entity
@Table(name = "region_service_station_info")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//@Document(indexName = "regionservicestationinfo")
public class RegionServiceStationInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "note")
    private String note;

    @ManyToOne
    private RegionDepInfo regionDepInfo;


}

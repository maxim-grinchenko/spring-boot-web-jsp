package com.resolution.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "APP_USER")
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //    @NotEmpty
    @Column(name = "FIRST_NAME", nullable = false)
    private String name;

    //    @NotEmpty
    @Column(name = "PASSWORD", nullable = false)
    private String phone;


    //    @NotEmpty
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "ROLE_ID", nullable = false)
    private int roleId;

//    @NotEmpty
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "APP_USER_USER_PROFILE",
//            joinColumns = {@JoinColumn(name = "USER_ID")},
//            inverseJoinColumns = {@JoinColumn(name = "USER_PROFILE_ID")})
//    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();

}
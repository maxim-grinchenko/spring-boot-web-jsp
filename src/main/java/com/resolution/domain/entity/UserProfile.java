package com.resolution.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "USER_PROFILE")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TYPE", length = 15, unique = true, nullable = false)
    private String type = UserProfileType.USER.getUserProfileType();

}

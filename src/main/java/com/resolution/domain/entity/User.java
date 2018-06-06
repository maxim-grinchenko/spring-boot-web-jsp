package com.resolution.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "APP_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @NotNull
    @NotEmpty
    @Column(name = "FIRST_NAME", nullable = false)
    private String name;

//    @NotNull
    @NotEmpty
    @Column(name = "PASSWORD", nullable = false)
    private String phone;

//    @NotNull
    @NotEmpty
    @Column(name = "EMAIL", nullable = false)
    private String email;

    /*
     * some int validation or custom annotation for validation*/
    @Column(name = "ROLE_ID", nullable = false)
    private int roleId;

}
package com.resolution.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @NotNull
    @NotEmpty
    @Column(name = "FIRST_NAME", nullable = false)
    private String name;

    @NotNull
    @NotEmpty
    @Column(name = "PASSWORD", nullable = false)
    private String phone;

    @NotNull
    @Email
    @NotEmpty
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @NotNull
    @NotEmpty
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    /*
     * some int validation or custom annotation for validation*/
    @Column(name = "ROLE_ID", nullable = false)
    private int roleId;

}
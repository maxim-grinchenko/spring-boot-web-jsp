package com.resolution.domain.entity;

import com.resolution.domain.entity.base.AbstractEntity;
import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "USER_TABLE")
public class User extends AbstractEntity {

    @NotNull
    @NotEmpty(message = "*Please provide your name")
    @Column(name = "FIRST_NAME", nullable = false)
    private String name;

    @NotNull
    @Length(min = 5, message = "*Your phone must have at least 5 characters")
    @NotEmpty(message = "*Please provide your phone")
    @Column(name = "PHONE", nullable = false)
    private String phone;

    @NotNull
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @NotNull
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "id"))
    private String role;


    public User(String name, String phone, String email, String password) {
    }
}
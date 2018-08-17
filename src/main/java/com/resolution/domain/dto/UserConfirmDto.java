package com.resolution.domain.dto;

/**
 * @author maxima - 16.08.2018
 */

public class UserConfirmDto {
    public String email;
    public String password;

    public UserConfirmDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserConfirmDto{" +
            "email='" + email + '\'' +
            ", password='" + password + '\'' +
            '}';
    }
}

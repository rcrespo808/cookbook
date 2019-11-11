package com.training.cookbook.publisher.dto;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Valid
public class PublisherCreateDto {

    private static final String PASSWORD_MESSAGE = "Password should at least be 8 characters long, have at least one uppercase, one lowercase letter, and one special character";

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String username;

    private String biography;

    //TODO:add error message
    @NotBlank
    @Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = PASSWORD_MESSAGE)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getbiography() {
        return biography;
    }

    public void setbiography(String biography) {
        this.biography = biography;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

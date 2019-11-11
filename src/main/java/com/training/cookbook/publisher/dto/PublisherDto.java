package com.training.cookbook.publisher.dto;

public class PublisherDto {

    private Long id;

    private String email;

    private String biography;

    private String username;


    //Todo: Check requiered constructors
    public PublisherDto(Long publisherId) {
        this.setId(publisherId);
    }

    public PublisherDto() {}

    public PublisherDto(Long id, String email, String biography) {
        this.id = id;
        this.email = email;
        this.biography = biography;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

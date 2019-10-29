package com.training.cookbook.publisher.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Publisher {
    @Id
    private Long id;

    private String username;

    private String biography;

    private Date deleteDate;

    public Publisher(Long publisherId) {
        this.setId(publisherId);
        deleteDate = null;
    }

    public Publisher() {
        deleteDate = null;
    }

    public Publisher(Long id, String username, String biography) {
        this.id = id;
        this.username = username;
        this.biography = biography;
        deleteDate = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publisher)) return false;
        Publisher publisher = (Publisher) o;
        return getId().equals(publisher.getId()) &&
                Objects.equals(getUsername(), publisher.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername());
    }

}

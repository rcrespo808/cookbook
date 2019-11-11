package com.training.cookbook.publisher.persistence.entity;

import com.training.cookbook.user.persistence.entity.User;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Publisher {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name = "USER_ID"))
    private User user;

    @Column(unique = true)
    private String username;

    private String email;

    private String biography;

    private Date deleteDate;

    public Publisher(Long publisherId) {
        this.setId(publisherId);
    }

    public Publisher() {}

    public Publisher(Long id, String username, String biography) {
        this.id = id;
        this.username = username;
        this.biography = biography;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

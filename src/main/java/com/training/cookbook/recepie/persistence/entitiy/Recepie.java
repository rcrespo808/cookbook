package com.training.cookbook.recepie.persistence.entitiy;

import javax.persistence.*;
import java.util.List;

@Entity
public class Recepie {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    private String description;

    @OneToMany(mappedBy="recepie")
    private List<Ingredient> ingredients;

    @ElementCollection
    private List<String> Steps;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<com.training.cookbook.recepie.persistence.entitiy.Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<com.training.cookbook.recepie.persistence.entitiy.Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getSteps() {
        return Steps;
    }

    public void setSteps(List<String> steps) {
        Steps = steps;
    }
}

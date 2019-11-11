package com.training.cookbook.recepie.dto;

import java.util.List;

public class RecepieCreateDto {
    private long id;
    private long publisherId;
    private String title;
    private String description;
    private List<IngredientCreateDto> ingredients;
    private List<String> steps;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(long publisherId) {
        this.publisherId = publisherId;
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

    public List<IngredientCreateDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientCreateDto> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }
}

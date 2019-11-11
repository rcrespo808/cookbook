package com.training.cookbook.recepie.dto;

public class IngredientCreateDto {
    private long id;
    private long quantity;
    private int measurement_unit;

    private String ingredient;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public int getMeasurement_unit() {
        return measurement_unit;
    }

    public void setMeasurement_unit(int measurement_unit) {
        this.measurement_unit = measurement_unit;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}

package com.training.cookbook.recepie.persistence.entitiy;

import javax.persistence.*;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue
    private long id;

    private long quantity;

    private String ingredient;

    @ManyToOne
    private Recepie recepie;

    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    private MeasurementUnit measurement_unit;

    public Ingredient(long id, long quantity, Recepie recepie, MeasurementUnit measurement_unit) {
        this.id = id;
        this.quantity = quantity;
        this.recepie = recepie;
        this.measurement_unit = measurement_unit;
    }

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

    public Recepie getRecepie() {
        return recepie;
    }

    public void setRecepie(Recepie recepie) {
        this.recepie = recepie;
    }

    public MeasurementUnit getMeasurement_unit() {
        return measurement_unit;
    }

    public void setMeasurement_unit(MeasurementUnit measurement_unit) {
        this.measurement_unit = measurement_unit;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}

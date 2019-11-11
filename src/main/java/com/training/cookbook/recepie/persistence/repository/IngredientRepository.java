package com.training.cookbook.recepie.persistence.repository;

import com.training.cookbook.recepie.persistence.entitiy.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {}


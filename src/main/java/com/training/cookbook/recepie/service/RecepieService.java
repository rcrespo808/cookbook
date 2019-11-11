package com.training.cookbook.recepie.service;

import com.training.cookbook.recepie.persistence.entitiy.Ingredient;
import com.training.cookbook.recepie.persistence.entitiy.Recepie;
import com.training.cookbook.recepie.persistence.repository.IngredientRepository;
import com.training.cookbook.recepie.persistence.repository.RecepieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecepieService {

    private RecepieRepository recepieRepository;

    private IngredientRepository ingredientRepository;

    public RecepieService(RecepieRepository recepieRepository, IngredientRepository ingredientRepository) {
        this.recepieRepository = recepieRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public Recepie CreateRecepie(Recepie recepie) {
        Recepie save = recepieRepository.save(recepie);
        List<Ingredient> ingredients = save.getIngredients();
        ingredients.forEach(ingredient -> ingredientRepository.save(ingredient));
        return save;
    }
}

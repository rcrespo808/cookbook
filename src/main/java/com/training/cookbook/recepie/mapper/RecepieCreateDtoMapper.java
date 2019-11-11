package com.training.cookbook.recepie.mapper;

import com.training.cookbook.recepie.dto.IngredientCreateDto;
import com.training.cookbook.recepie.dto.RecepieCreateDto;
import com.training.cookbook.recepie.persistence.entitiy.Ingredient;
import com.training.cookbook.recepie.persistence.entitiy.MeasurementUnit;
import com.training.cookbook.recepie.persistence.entitiy.Recepie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecepieCreateDtoMapper {

    public Recepie toRecepie(RecepieCreateDto recepieDto){
        Recepie recepie = new Recepie();

        recepie.setId(recepieDto.getId());
        recepie.setDescription(recepieDto.getDescription());
        recepie.setTitle(recepieDto.getTitle());
        recepie.setSteps(recepieDto.getSteps());
        recepie.setIngredients(mapIngredientList(recepieDto.getIngredients(),recepie));

        return recepie;

    }

    private List<Ingredient> mapIngredientList(List<IngredientCreateDto> ingredientCreateDtoList, Recepie recepie){
        List<Ingredient> ingredients = new ArrayList<>();
        if (ingredientCreateDtoList != null && ingredientCreateDtoList.size() > 0) {
            ingredientCreateDtoList.forEach(e -> ingredients.add(new Ingredient(e.getId(), e.getQuantity(), recepie, MeasurementUnit.values()[e.getMeasurement_unit()])));
        }
        return ingredients;
    }

}

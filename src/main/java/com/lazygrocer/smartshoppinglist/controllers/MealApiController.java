package com.lazygrocer.smartshoppinglist.controllers;

import com.lazygrocer.smartshoppinglist.MealAlreadyFoundException;
import com.lazygrocer.smartshoppinglist.models.Ingredient;
import com.lazygrocer.smartshoppinglist.models.Meal;
import com.lazygrocer.smartshoppinglist.models.MealIngredient;
import com.lazygrocer.smartshoppinglist.repositories.IngredientRepository;
import com.lazygrocer.smartshoppinglist.repositories.MealIngredientRepository;
import com.lazygrocer.smartshoppinglist.repositories.MealRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
@RequestMapping("/api/meals")
public class MealApiController {
    @Resource
    private MealRepository mealRepo;
    @Resource
    private IngredientRepository ingredientRepo;
    @Resource
    private MealIngredientRepository mealIngredientRepo;

    @PostMapping("/add-meal")
    public Meal addMeal(@RequestBody Meal meal) {

        for (MealIngredient mealIngredient : meal.getMealIngredients()) {
            Optional<Ingredient> ingredientOptional = ingredientRepo.findByName(mealIngredient.getIngredient().getName());
            if (!ingredientOptional.isPresent()) {
                mealIngredient.updateIngredient(ingredientRepo.save(new Ingredient(mealIngredient.getIngredient().getName())));
            } else {
                mealIngredient.updateIngredient(ingredientOptional.get());
            }
            mealIngredientRepo.save(mealIngredient);

        }
        
        if(mealRepo.findByName(meal.getName()) != null) {
        	throw new MealAlreadyFoundException();
        } 
        mealRepo.save(meal);
        meal.updateMealIngredientReferences();

        return mealRepo.save(meal);

    }
    
//    throws InterruptedException

    @PutMapping("/edit-meal/{mealId}")
    public Meal editMeal(@RequestBody Meal meal, @PathVariable Long mealId)  {
        Meal mealToChange = mealRepo.save(meal);
        mealIngredientRepo.deleteAll(mealToChange.getMealIngredients());
        for (MealIngredient mealIngredient : meal.getMealIngredients()) {
            Optional<Ingredient> ingredientOptional = ingredientRepo.findByName(mealIngredient.getIngredient().getName());
            if (!ingredientOptional.isPresent()) {
                mealIngredient.updateIngredient(ingredientRepo.save(new Ingredient(mealIngredient.getIngredient().getName())));
            } else {
                mealIngredient.updateIngredient(ingredientOptional.get());
            }
            mealIngredientRepo.save(mealIngredient);
        }
       // if(mealRepo.findByName(meal.getName()) != null) {
       // 	throw new MealAlreadyFoundException();
       // } 
        mealRepo.save(meal);
        meal.updateMealIngredientReferences();
        return mealRepo.save(meal);
    }

}

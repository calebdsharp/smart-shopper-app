package com.lazygrocer.smartshoppinglist.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lazygrocer.smartshoppinglist.models.MealIngredient;

public interface MealIngredientRepository extends CrudRepository<MealIngredient, Long> {

	MealIngredient findByIngredientName(MealIngredient[] mealIngredients);

}

package com.lazygrocer.smartshoppinglist.models;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MealTest {

	@Test
	public void shouldBeAbleToChangeName() {
		Meal testMeal = new Meal("name",1);
		testMeal.changeName("newName");
		assertEquals("newName",testMeal.getName());
	}
	@Test
	public void shouldBeAbleToRemoveIngredient() {	
		Ingredient ingredient1 = new Ingredient("ingredientOne");
		MealIngredient mealIngredientOne = new MealIngredient(ingredient1, 2);
		Ingredient ingredient2 = new Ingredient("ingredientTwo");
		MealIngredient mealIngredientTwo = new MealIngredient(ingredient2, 6);
		Ingredient ingredient3 = new Ingredient("ingredientTwo");
		MealIngredient ingredientThree = new MealIngredient(ingredient3, 14);
		
		Meal meal = new Meal ("meal 1", 2, mealIngredientOne, mealIngredientTwo, ingredientThree);
		
		meal.remove(mealIngredientOne);
		assertThat(meal.getMealIngredients(), containsInAnyOrder(mealIngredientTwo, ingredientThree));
		
	}

}

package com.lazygrocer.smartshoppinglist.controllers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.lazygrocer.smartshoppinglist.MealNotFoundException;
import com.lazygrocer.smartshoppinglist.models.Ingredient;
import com.lazygrocer.smartshoppinglist.models.Meal;
import com.lazygrocer.smartshoppinglist.models.MealIngredient;
import com.lazygrocer.smartshoppinglist.repositories.IngredientRepository;
import com.lazygrocer.smartshoppinglist.repositories.MealIngredientRepository;
import com.lazygrocer.smartshoppinglist.repositories.MealRepository;

public class MealControllerTest {

	@InjectMocks
	private MealController underTest;

	@Mock
	private MealRepository mealRepo;
	@Mock
	private Meal meal;
	Long mealId;
	
	@Mock
	private Meal anotherMeal;
	@Mock
	private Model model;
	@Mock
	private MealIngredientRepository mealIngredientRepo;
	@Mock
	private IngredientRepository ingredientRepo;
	@Mock
	private MealIngredient mealIngredient;
	@Mock
	private MealIngredient anotherMealIngredient;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldAddSingleMealToModel() throws MealNotFoundException {
		long newMealId = 1;
		when(mealRepo.findById(newMealId)).thenReturn(Optional.of(meal));
		underTest.findOneMeal(newMealId, model);
		verify(model).addAttribute("meal", meal);
	}

	@Test
	public void shouldAddAllMealsToModel() {
		Collection<Meal> allMeals = Arrays.asList(meal, anotherMeal);
		when(mealRepo.findAll()).thenReturn(allMeals);

		underTest.findAllMeals(model);
		verify(model).addAttribute("meals", allMeals);
	}
	
	@Test
	public void shouldAddAdditionalMealsToModel() {
		Ingredient ingredient1 = new Ingredient("ingredient1");
		MealIngredient mealIngredientOne = new MealIngredient(ingredient1, 2);
	
		Ingredient ingredient2 = new Ingredient("ingredient2");
		MealIngredient mealIngredientTwo = new MealIngredient(ingredient2, 6);
		
		Ingredient ingredient3 = new Ingredient("ingredient3");
		MealIngredient mealIngredientThree = new MealIngredient(ingredient3, 14);
		
		
		String mealName = "meal name";
//		underTest.addMeal(mealName, 4);
		
		Meal newMeal = new Meal(mealName, 1, mealIngredientOne, mealIngredientTwo, mealIngredientThree);
		
		when(mealRepo.save(newMeal)).thenReturn(newMeal);
		
	}
	
//	@Test
//	public void shouldGetTotalOfMealsInModel() {
//		Meal testMealOne = new Meal("test meal 1", 2);
//		Meal testMealTwo = new Meal("test meal 2", 4);
//		
//		Collection<Meal> allMeals = Arrays.asList(testMealOne, testMealTwo);
//		when(mealRepo.findAll()).thenReturn(allMeals);
//		
//		underTest.getTotalMealCount(model);
//		verify(model).addAttribute("meals", allMeals);
//	}
	
//	@Test
//	public void shouldRemoveMealFromModelByName() {
//		String mealName = meal.getName();
//		when(mealRepo.findByName(mealName)).thenReturn(meal);
//		underTest.deleteMealByName(mealName);
//		verify(mealRepo).delete(meal);
//	}
	
//	@Test 
//	public void shouldRemoveMealFromModelById() {
//		underTest.deleteMealById(mealId);
//		verify(mealRepo).deleteById(mealId);
//	}
//	
//	@Test
//	public void shouldChangeMealName() {
//		Meal testMeal = mock(Meal.class);
//		when(mealRepo.findById(1L)).thenReturn(Optional.of(testMeal));
//		underTest.changeMealName(1L,"newName");
//		verify(testMeal).changeName("newName");
//	}
//	public void shouldDeleteIngredientFromMeal() {
//		MealIngredient mealIngredientOne = mock(MealIngredient.class);
//		when(mealIngredientRepo.findById(1L)).thenReturn(Optional.of(mealIngredientOne));
//		when(mealRepo.findById(2L)).thenReturn(Optional.of(meal));
//		
//		
//		underTest.deleteIngredientFromMeal(2L, 1L);
//		
//		verify(meal).remove(mealIngredientOne);
//	}
	
	
}

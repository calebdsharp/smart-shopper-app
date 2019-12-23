package com.lazygrocer.smartshoppinglist.models;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MealPlanTest {

	@Test
	public void canAddOneMealToMealPlan() {
		MealPlan underTest = new MealPlan();
		Meal testMeal = new Meal("testMeal", 1);
		underTest.addMeal(testMeal);
		assertThat(underTest.mealCount(), is(1));
	}

	@Test
	public void canAddTwoMealToMealPlan() {
		MealPlan underTest = new MealPlan();
		Meal testMeal = new Meal("testMeal", 1);
		Meal testMeal2 = new Meal("testMeal2", 2);
		underTest.addMeal(testMeal);
		underTest.addMeal(testMeal2);

		assertThat(underTest.mealCount(), is(2));
	}

	@Test
	public void canRemoveMealFromPlan() {
		MealPlan underTest = new MealPlan();
		Meal testMeal = new Meal("testMeal", 1);
		Meal testMeal2 = new Meal("testMeal2", 2);
		underTest.addMeal(testMeal);
		underTest.addMeal(testMeal2);
		underTest.removeMeal(testMeal);

		assertThat(underTest.getMeals(), contains(testMeal2));
	}

	@Test
	public void canIncreaseMealCount() {
		MealPlan underTest = new MealPlan();
		Meal testMeal = new Meal("testMeal", 1);
		underTest.addMeal(testMeal);
		underTest.addMeal(testMeal);

		assertThat(underTest.mealCount(), is(2));
	}

	@Test
	public void canDecreaseMealCount() {
		MealPlan underTest = new MealPlan();
		Meal testMeal = new Meal("testMeal", 1);
		underTest.addMeal(testMeal);
		underTest.addMeal(testMeal);
		underTest.removeMeal(testMeal);

		assertThat(underTest.mealCount(), is(1));
	}

	@Test
	public void canFetchMealCountForSpecificMeal() {
		MealPlan underTest = new MealPlan();
		Meal testMeal = new Meal("testMeal", 1);
		Meal testMeal2 = new Meal("testMeal2", 1);
		underTest.addMeal(testMeal);
		underTest.addMeal(testMeal);
		underTest.addMeal(testMeal2);
		int specificMealCount = underTest.fetchMealCount(testMeal);
		int specificMealCount2 = underTest.fetchMealCount(testMeal2);


		assertThat(specificMealCount, is(2));
		assertThat(specificMealCount2, is(1));
	}

}


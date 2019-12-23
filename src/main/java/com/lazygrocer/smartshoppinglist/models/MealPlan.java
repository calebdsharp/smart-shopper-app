package com.lazygrocer.smartshoppinglist.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MealPlan {

	private List<Meal> meals;

	public void addMeal(Meal meal) {
		getMeals().add(meal);
	}

	public int mealCount() {
		return getMeals().size();
	}

	public void removeMeal(Meal meal) {
		getMeals().remove(meal);
	}

	public List<Meal> getMeals() {
		if (meals == null) {
			meals = new ArrayList<>();
		}
		return meals;
	}

	public Integer fetchMealCount(Meal mealToCount) {
		int count = 0;
		for (Meal meal : getMeals()) {
			if (meal.equals(mealToCount)) {
				count++;
			}
		}
		return count;
	}

	
}

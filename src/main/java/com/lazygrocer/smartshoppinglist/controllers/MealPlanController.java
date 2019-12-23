package com.lazygrocer.smartshoppinglist.controllers;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lazygrocer.smartshoppinglist.MealNotFoundException;
import com.lazygrocer.smartshoppinglist.models.Meal;
import com.lazygrocer.smartshoppinglist.models.MealPlan;
import com.lazygrocer.smartshoppinglist.repositories.MealRepository;

@RequestMapping("/api/mealPlan")
@RestController
public class MealPlanController {
	@Resource
	private MealRepository mealRepo;
	
	@Resource
	private MealPlan mealPlan;
	
//	@ResponseBody
	@GetMapping("/mealCount/{id}")
	public String findOneMealCount(@PathVariable Long id) {
		Optional<Meal> mealOptional = mealRepo.findById(id);
		if(!mealOptional.isPresent()) {
			throw new MealNotFoundException();
		}
		Meal meal = mealRepo.findById(id).get();
		return "{\"count\":\""+mealPlan.fetchMealCount(meal)+"\"}";
	}
	
	@GetMapping("/increaseCount/{id}")
	public void increaseMealCount(@PathVariable Long id) {
		Optional<Meal> mealOptional = mealRepo.findById(id);
		if(!mealOptional.isPresent()) {
			throw new MealNotFoundException();
		}
		Meal meal = mealRepo.findById(id).get();
		mealPlan.addMeal(meal);
	}
	
	@GetMapping("/decreaseCount/{id}")
	public void decreaseMealCount(@PathVariable Long id) {
		Optional<Meal> mealOptional = mealRepo.findById(id);
		if(!mealOptional.isPresent()) {
			throw new MealNotFoundException();
		}
		Meal meal = mealRepo.findById(id).get();
		mealPlan.removeMeal(meal);
	}
	
	
	
}



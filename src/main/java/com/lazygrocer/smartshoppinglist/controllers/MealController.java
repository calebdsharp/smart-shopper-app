package com.lazygrocer.smartshoppinglist.controllers;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lazygrocer.smartshoppinglist.MealNotFoundException;
import com.lazygrocer.smartshoppinglist.models.Meal;
import com.lazygrocer.smartshoppinglist.models.MealPlan;
import com.lazygrocer.smartshoppinglist.repositories.MealIngredientRepository;
import com.lazygrocer.smartshoppinglist.repositories.MealRepository;

@Controller
public class MealController {

	@Resource
	private MealRepository mealRepo;
	@Resource
	private MealIngredientRepository mealIngredientRepo;

	@Resource
	private MealPlan mealPlan;

	@RequestMapping("/meals")
	public String findAllMeals(Model model) {
		model.addAttribute("meals", mealRepo.findAll());
		model.addAttribute("mealPlan", mealPlan);
		return ("meals");

	}
	
	
	@RequestMapping("/edit-meal/{id}")
	public String findOneMeal(@PathVariable long id, Model model) throws MealNotFoundException {
		Optional<Meal> meal = mealRepo.findById(id);

		if (meal.isPresent()) {
			model.addAttribute("meal", meal.get());
			return "edit-meal";
		}
		throw new MealNotFoundException();
	}

	@RequestMapping("/add-meal")
	public String addMeal(Model model) {
		return "AddMeal";
	}


//	@GetMapping("/total-meals-count")
//	public String findTotalMealCount(Model model) {
//
//	}

	// @PostMapping("/add-meal")
	// public String addMeal(@RequestParam String mealName, @RequestParam int
	// servings,
	// @RequestParam MealIngredient... mealIngredients) {
	// MealIngredient mealIngredient =
	// mealIngredientRepo.findByName(mealIngredients);
	//
	// if (mealIngredient == null) {
	// mealIngredient = new MealIngredient(ingredient, 12);
	// mealIngredientRepo.save(mealIngredient);
	// }
	//
	// Meal newMeal = mealRepo.findByName(mealName);
	//
	// if (newMeal == null) {
	// newMeal = new Meal(mealName, servings, mealIngredients);
	// mealRepo.save(newMeal);
	// }
	// return "redirect:/meals";
	// }

	@DeleteMapping("/delete-meal")
	public String deleteMealByName(String mealName) {
		if (mealRepo.findByName(mealName) != null) {
			Meal deleteMeal = mealRepo.findByName(mealName);
			mealRepo.delete(deleteMeal);
		}
		return "redirect:/meals";
	}

	// @RequestMapping("/find-meal")
	// public String findMeal(String mealName, Model model) {
	// model.addAttribute("meals", mealRepo.findByName(mealName));
	// return "/meal";
	// }

	// @RequestMapping("/sort-meals")
	// public String sortMeals(Model model) {
	// model.addAttribute("meals", mealRepo.findAllByOrderByNameAsc());
	// return "redirect:/meals";
	// }

	// @RequestMapping("/change-meal-name/{id}/{newMealName}")
	// public String changeMealName(@PathVariable Long id, @PathVariable String
	// newMealName) {
	//
	// Meal meal = mealRepo.findById(id).get();
	//
	// meal.changeName(newMealName);
	// mealRepo.save(meal);
	//
	// return "redirect:/meal";
	// }
	//
	// @RequestMapping("/meal/{mealId}/remove-ingredient/{ingredientId}")
	// public String deleteIngredientFromMeal(@PathVariable Long mealId,
	// @PathVariable Long ingredientId) {
	//
	// Meal meal = mealRepo.findById(mealId).get();
	// MealIngredient mealIngredient =
	// mealIngredientRepo.findById(ingredientId).get();
	// meal.remove(mealIngredient);
	//
	//// get meal
	//// get ingredient
	//// remove ingredient
	//
	// return "/meal";
	// }

}

package com.lazygrocer.smartshoppinglist;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lazygrocer.smartshoppinglist.models.Ingredient;
import com.lazygrocer.smartshoppinglist.models.Meal;
import com.lazygrocer.smartshoppinglist.models.MealIngredient;
import com.lazygrocer.smartshoppinglist.repositories.IngredientRepository;
import com.lazygrocer.smartshoppinglist.repositories.MealIngredientRepository;
import com.lazygrocer.smartshoppinglist.repositories.MealRepository;

@Component
public class Populator implements CommandLineRunner {

	@Resource
	private MealRepository mealRepo;

	@Resource
	MealIngredientRepository mealIngredientRepo;
	@Resource
	IngredientRepository ingredientRepo;

	@Override
	public void run(String... args) throws Exception {

		Ingredient iButter = ingredientRepo.save(new Ingredient("butter"));

		Ingredient iMilk = ingredientRepo.save(new Ingredient("milk"));

		Ingredient iMacaroni = ingredientRepo.save(new Ingredient("macaroni"));

		Ingredient iVelveeta = ingredientRepo.save(new Ingredient("velveeta"));

		Ingredient iBread = ingredientRepo.save(new Ingredient("bread"));

		Ingredient iEgg = ingredientRepo.save(new Ingredient("egg"));

//piri-piri chicken. 		
		Ingredient iCilantro = ingredientRepo.save(new Ingredient("cilantro"));
		
		Ingredient iGinger = ingredientRepo.save(new Ingredient("ginger"));
		
		Ingredient iShallot = ingredientRepo.save(new Ingredient("shallot"));
		
		Ingredient iGarlicClove  = ingredientRepo.save(new Ingredient("garlic clove"));
		
		Ingredient iHotPepperSause = ingredientRepo.save(new Ingredient("hot pepper sauce"));
		
		Ingredient iVirginOil = ingredientRepo.save(new Ingredient("virgin oil"));
		
		Ingredient iWholeChicken = ingredientRepo.save(new Ingredient("whole chicken"));

	//Green beans:
		//green beans:
		Ingredient iGreenBeans = ingredientRepo.save(new Ingredient("1lb green beans"));
		Ingredient iYellowOnion = ingredientRepo.save(new Ingredient("yellow onion"));
		Ingredient iMushrooms = ingredientRepo.save(new Ingredient("mushrooms"));
		Ingredient iAllPurposeFloor = ingredientRepo.save(new Ingredient("all purpose floor"));
		Ingredient iFrenchOnion = ingredientRepo.save(new Ingredient("french onion"));
		
		

	//Meal ingredients for green beans:
		//green beans:
		MealIngredient greenBeans1 = mealIngredientRepo.save(new MealIngredient(iGreenBeans, 1));
		MealIngredient yellowOnion1 = mealIngredientRepo.save(new MealIngredient(iYellowOnion, 1));
		MealIngredient mushrooms1 = mealIngredientRepo.save(new MealIngredient(iMushrooms, 1));
		MealIngredient garlicClove2 = mealIngredientRepo.save(new MealIngredient(iGarlicClove, 1));
		MealIngredient allPurposeFloor1 = mealIngredientRepo.save(new MealIngredient(iAllPurposeFloor, 1));
		MealIngredient frenchOnion1 = mealIngredientRepo.save(new MealIngredient(iFrenchOnion, 1));
		
		Meal meal5 = new Meal("Green Bean Casserole", 1,greenBeans1, yellowOnion1, mushrooms1, garlicClove2, allPurposeFloor1, frenchOnion1 
								);
		meal5 = mealRepo.save(meal5);
		
		greenBeans1 = mealIngredientRepo.save(greenBeans1);
		yellowOnion1 = mealIngredientRepo.save(yellowOnion1);
		mushrooms1 = mealIngredientRepo.save(mushrooms1);
		garlicClove2 = mealIngredientRepo.save(garlicClove2);
		allPurposeFloor1 = mealIngredientRepo.save(allPurposeFloor1);
		frenchOnion1 = mealIngredientRepo.save(frenchOnion1);
	
		
	//Meal Ingridients for Piri Piri Chicken:
		MealIngredient cilantro1 = mealIngredientRepo.save(new MealIngredient(iCilantro, 2));
		MealIngredient ginger1 = mealIngredientRepo.save(new MealIngredient(iGinger, 1));
		MealIngredient shallot1 = mealIngredientRepo.save(new MealIngredient(iShallot, 1));
		MealIngredient butter4 = mealIngredientRepo.save(new MealIngredient(iButter, 2));
		MealIngredient garlicClove1 = mealIngredientRepo.save(new MealIngredient(iGarlicClove, 2));
		MealIngredient hotPeperSause1 = mealIngredientRepo.save(new MealIngredient(iHotPepperSause, 1));
		MealIngredient virginOil1 = mealIngredientRepo.save(new MealIngredient(iVirginOil, 1));
		MealIngredient wholeChicken1 = mealIngredientRepo.save(new MealIngredient(iWholeChicken, 1));
		Meal meal4 = new Meal("Piri Piri Chicken", 1, cilantro1, ginger1, shallot1, butter4, hotPeperSause1, 
								virginOil1, wholeChicken1 );
		meal4 = mealRepo.save(meal4);
		
		cilantro1 = mealIngredientRepo.save(cilantro1);
		ginger1 = mealIngredientRepo.save(ginger1);
		shallot1 = mealIngredientRepo.save(shallot1);
		butter4 = mealIngredientRepo.save(butter4);
		garlicClove1 = mealIngredientRepo.save(garlicClove1);
		hotPeperSause1 = mealIngredientRepo.save(hotPeperSause1);
		virginOil1 = mealIngredientRepo.save(virginOil1);
		wholeChicken1 = mealIngredientRepo.save(wholeChicken1);
		

	//Meal Ingredients for Mac & Cheese.	
		MealIngredient butter1 = mealIngredientRepo.save(new MealIngredient(iButter, 1));
		MealIngredient milk1 = mealIngredientRepo.save(new MealIngredient(iMilk, 1));
		MealIngredient macaroni1 = mealIngredientRepo.save(new MealIngredient(iMacaroni, 1));
		MealIngredient velveeta1 = mealIngredientRepo.save(new MealIngredient(iVelveeta, 1));
		Meal meal1 = new Meal("Mac & Cheese", 2, butter1, milk1, macaroni1, velveeta1);
		meal1 = mealRepo.save(meal1);
		butter1 = mealIngredientRepo.save(butter1);
		milk1 = mealIngredientRepo.save(milk1);
		macaroni1 = mealIngredientRepo.save(macaroni1);
		velveeta1 = mealIngredientRepo.save(velveeta1);
		
	//Meal Ingredients for Grilled Cheese.
		MealIngredient butter2 = mealIngredientRepo.save(new MealIngredient(iButter, 1));
		MealIngredient velveeta2 = mealIngredientRepo.save(new MealIngredient(iVelveeta, 1));
		MealIngredient bread2 = mealIngredientRepo.save(new MealIngredient(iBread, 2));
		Meal meal2 = new Meal("Grilled Cheese", 1, butter2, bread2, velveeta2);
		meal2 = mealRepo.save(meal2);
		butter2 = mealIngredientRepo.save(butter2);
		velveeta2 = mealIngredientRepo.save(velveeta2);
		bread2 = mealIngredientRepo.save(bread2);
		
	//Meal ingredients for Scrambled Eggs.
		MealIngredient butter3 = mealIngredientRepo.save(new MealIngredient(iButter, 1));
		MealIngredient milk3 = mealIngredientRepo.save(new MealIngredient(iMilk, 1));
		MealIngredient egg3 = mealIngredientRepo.save(new MealIngredient(iEgg, 1));
		Meal meal3 = new Meal("Scrambled Eggs", 1, butter3, egg3, milk3);
		meal3 = mealRepo.save(meal3);

		butter3 = mealIngredientRepo.save(butter3);
		milk3 = mealIngredientRepo.save(milk3);
		egg3 = mealIngredientRepo.save(egg3);

		
		
		
		
		
	}

}

package com.lazygrocer.smartshoppinglist;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.lazygrocer.smartshoppinglist.models.Ingredient;
import com.lazygrocer.smartshoppinglist.models.Meal;
import com.lazygrocer.smartshoppinglist.models.MealIngredient;
import com.lazygrocer.smartshoppinglist.repositories.IngredientRepository;
import com.lazygrocer.smartshoppinglist.repositories.MealIngredientRepository;
import com.lazygrocer.smartshoppinglist.repositories.MealRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaWiringTest {

	@Resource
	private MealIngredientRepository mealIngredientRepo;
	@Resource
	private IngredientRepository ingredientRepo;
	@Resource
	private MealRepository mealRepo;
	@Resource
	private TestEntityManager entityManager;
	
	
	@Test
	public void mealsShouldHaveAListOfIngs() throws Exception {
		Ingredient iName = new Ingredient("name");
		Ingredient iName2= new Ingredient("name2");
		iName = ingredientRepo.save(iName);
		iName2 = ingredientRepo.save(iName2);
		MealIngredient testMealIngredient = new MealIngredient(iName, 1);
		testMealIngredient = mealIngredientRepo.save(testMealIngredient);
		MealIngredient testMealIngredient2 = new MealIngredient(iName, 2);
		testMealIngredient2 = mealIngredientRepo.save(testMealIngredient2);
		Meal testMeal = new Meal("name", 1, testMealIngredient, testMealIngredient2);
		testMeal = mealRepo.save(testMeal);
		
		entityManager.flush();
		entityManager.clear();
		
		Meal retrievedMeal=mealRepo.findById(testMeal.getId()).get();
		assertThat(retrievedMeal.getMealIngredients(),
				containsInAnyOrder(testMealIngredient2, testMealIngredient));
		assertThat(testMealIngredient.getMeal(), is(retrievedMeal));
		assertThat(mealIngredientRepo.findById(testMealIngredient.getId()).get().getMeal(),
				is(testMeal));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package com.lazygrocer.smartshoppinglist.models;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ShoppingListTest {

    private ShoppingList underTest;
    private Meal testMeal;
    @Before
    public void setUp() {
        createTestMeal();
        underTest = new ShoppingList();
    }

    @Test
    public void shouldAddMealToShoppingList() {
        underTest.addMealToShoppingList(testMeal);
        List<ShoppingListItem> shoppingListItems = underTest.getShoppingListItems();
        assertThat(shoppingListItems).containsExactly(new ShoppingListItem(new Ingredient("butter"),1));
    }
    @Test
    public void shouldAddSameMealTwiceToShoppingList() {
        underTest.addMealToShoppingList(testMeal);
        underTest.addMealToShoppingList(testMeal);
        List<ShoppingListItem> shoppingListItems = underTest.getShoppingListItems();
        assertThat(shoppingListItems).containsExactly(new ShoppingListItem(new Ingredient("butter"),2));
    }


    private void createTestMeal() {
        Ingredient iButter = new Ingredient("butter");
//        Ingredient iMilk = new Ingredient("milk");
//        Ingredient iMacaroni = new Ingredient("macaroni");
//        Ingredient iVelveeta = new Ingredient("velveeta");

        MealIngredient butter1 = new MealIngredient(iButter, 1);
//        MealIngredient milk1 = new MealIngredient(iMilk, 1);
//        MealIngredient macaroni1 = new MealIngredient(iMacaroni, 1);
//        MealIngredient velveeta1 = new MealIngredient(iVelveeta, 1);
        testMeal= new Meal("Mac & Cheese", 2, butter1/*, milk1, macaroni1, velveeta1*/);
    }
}
package com.lazygrocer.smartshoppinglist.models;

import com.lazygrocer.smartshoppinglist.repositories.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingList {
    private List<ShoppingListItem> shoppingListItems;
    @Autowired
    private MealRepository mealRepo;
    public List<ShoppingListItem> getShoppingListItems() {
        if (shoppingListItems == null) {
            shoppingListItems = new ArrayList<>();
        }
        return shoppingListItems;
    }

    public void addMealToShoppingList(Meal meal) {

        for (MealIngredient mealIngredient : meal.getMealIngredients()) {
            boolean itemMatched = false;
            Ingredient ingredientToMatch = mealIngredient.getIngredient();
            for (ShoppingListItem itemToMatch : getShoppingListItems()) {
                if (itemToMatch.getIngredient().equals(ingredientToMatch)) {
                    itemMatched = true;
                    itemToMatch.updateQuantity(mealIngredient.getQuantity());
                }
            }
            if (!itemMatched) {
                ShoppingListItem itemToAdd = new ShoppingListItem(mealIngredient.getIngredient(), mealIngredient.getQuantity());
                getShoppingListItems().add(itemToAdd);
            }
        }
    }

    public void populateShoppingList(MealPlan mealPlan) {
        getShoppingListItems().clear();

        for(Meal mealToAdd: mealPlan.getMeals()){
            addMealToShoppingList(mealRepo.findById(mealToAdd.getId()).get());
        }
    }
}

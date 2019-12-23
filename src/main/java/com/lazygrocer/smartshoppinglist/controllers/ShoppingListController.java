package com.lazygrocer.smartshoppinglist.controllers;

import com.lazygrocer.smartshoppinglist.models.MealPlan;
import com.lazygrocer.smartshoppinglist.models.ShoppingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ShoppingListController {
    @Autowired
    private ShoppingList shoppingList;
    @Autowired
    private MealPlan mealPlan;
    @RequestMapping("/shopping-list")
    public String shoppingList(Model model) {
       shoppingList.populateShoppingList(mealPlan);

        model.addAttribute("shoppingListItems", shoppingList.getShoppingListItems());
        return "ShoppingList";
    }
}


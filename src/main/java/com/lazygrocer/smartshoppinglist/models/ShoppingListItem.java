package com.lazygrocer.smartshoppinglist.models;

public class ShoppingListItem {

    private Ingredient ingredient;
    private int quantity;

    public ShoppingListItem(Ingredient ingredient, int quantity) {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public int getQuantity() {
        return quantity;
    }

    public void updateQuantity(int quantity) {
        this.quantity+=quantity;
    }

    @Override
    public String toString() {
        return "ShoppingListItem{" +
                "ingredient=" + ingredient +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingListItem)) return false;

        ShoppingListItem that = (ShoppingListItem) o;

        if (getQuantity() != that.getQuantity()) return false;
        return getIngredient() != null ? getIngredient().equals(that.getIngredient()) : that.getIngredient() == null;
    }

    @Override
    public int hashCode() {
        int result = getIngredient() != null ? getIngredient().hashCode() : 0;
        result = 31 * result + getQuantity();
        return result;
    }
}


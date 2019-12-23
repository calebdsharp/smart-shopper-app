package com.lazygrocer.smartshoppinglist.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MealIngredient {

	@ManyToOne
	private Ingredient ingredient;
	private int quantity;
	@Id
	@GeneratedValue
	private Long id;
	@JsonIgnore
	@ManyToOne
	private Meal meal;

	public MealIngredient(Ingredient ingredient, int quantity) {
		this.ingredient = ingredient;
		this.quantity = quantity;

	}

	protected MealIngredient() {
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public int getQuantity() {
		return quantity;
	}

	public Long getId() {
		return id;
	}

	public Meal getMeal() {
		return meal;
	}

	public void updateIngredient(Ingredient ingredient){
		this.ingredient=ingredient;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof MealIngredient)) return false;

		MealIngredient that = (MealIngredient) o;

		if (getQuantity() != that.getQuantity()) return false;
		if (getIngredient() != null ? !getIngredient().equals(that.getIngredient()) : that.getIngredient() != null)
			return false;
		if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
		return getMeal() != null ? getMeal().equals(that.getMeal()) : that.getMeal() == null;
	}

	@Override
	public int hashCode() {
		int result = getIngredient() != null ? getIngredient().hashCode() : 0;
		result = 31 * result + getQuantity();
		result = 31 * result + (getId() != null ? getId().hashCode() : 0);
		result = 31 * result + (getMeal() != null ? getMeal().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "MealIngredient [ingredient=" + ingredient + ", quantity=" + quantity + ", id=" + id + "]";
	}

	public void addMeal(Meal meal) {
	this.meal=meal;
		
	}

}

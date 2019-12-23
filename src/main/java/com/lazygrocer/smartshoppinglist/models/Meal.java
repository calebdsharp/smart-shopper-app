package com.lazygrocer.smartshoppinglist.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;

@Entity
public class Meal {

	private String name;
	private int servingCount;

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(mappedBy = "meal")
	private List<MealIngredient> mealIngredients;

		public Meal(String name, int servingCount, MealIngredient... mealIngredients) {
		this.name = name;
		this.servingCount = servingCount;
		this.mealIngredients = new ArrayList<>(Arrays.asList(mealIngredients));
			updateMealIngredientReferences();

		}

	public void updateMealIngredientReferences() {
		this.mealIngredients.stream().forEach((mealIngredient) -> {
			mealIngredient.addMeal(this);
		});
	}

	protected Meal() {
	}

	public String getName() {
		return name;
	}

	public int getServingCount() {
		return servingCount;
	}

	public List<MealIngredient> getMealIngredients() {
		return mealIngredients;
	}

	public Long getId() {
		return id;
	}

	public void remove(MealIngredient mealIngredient) {
		mealIngredients.remove(mealIngredient);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + servingCount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meal other = (Meal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (servingCount != other.servingCount)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Meal{" +
				"name='" + name + '\'' +
				", servingCount=" + servingCount +
				", id=" + id +
				", mealIngredients=" + mealIngredients +
				'}';
	}

	public void changeName(String newName) {
		this.name = newName;
	}
}

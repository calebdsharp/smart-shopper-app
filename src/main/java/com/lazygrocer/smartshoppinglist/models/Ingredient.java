package com.lazygrocer.smartshoppinglist.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Ingredient {

    private String name;
    @Id
	@GeneratedValue
	private Long id;
    @JsonIgnore
    @OneToMany(mappedBy="ingredient")
	private List<MealIngredient> mealIngredients;
    
    protected Ingredient() {}
    public Ingredient(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Ingredient [name=" + name + ", id=" + id + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Ingredient)) return false;

		Ingredient that = (Ingredient) o;

		if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
		return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
	}

	@Override
	public int hashCode() {
		int result = getName() != null ? getName().hashCode() : 0;
		result = 31 * result + (getId() != null ? getId().hashCode() : 0);
		return result;
	}
}

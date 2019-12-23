package com.lazygrocer.smartshoppinglist.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.lazygrocer.smartshoppinglist.models.Meal;

public interface MealRepository extends CrudRepository<Meal, Long> {

	Meal findByName(String mealName);

	Collection<Meal> findAllByOrderByNameAsc();

}

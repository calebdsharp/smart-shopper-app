package com.lazygrocer.smartshoppinglist.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lazygrocer.smartshoppinglist.models.Ingredient;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    Optional<Ingredient> findByName(String name);
}

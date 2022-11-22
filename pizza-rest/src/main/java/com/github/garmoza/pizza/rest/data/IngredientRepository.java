package com.github.garmoza.pizza.rest.data;

import com.github.garmoza.pizza.rest.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}

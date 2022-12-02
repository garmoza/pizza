package com.github.garmoza.pizza.admin.data;

import com.github.garmoza.pizza.admin.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}

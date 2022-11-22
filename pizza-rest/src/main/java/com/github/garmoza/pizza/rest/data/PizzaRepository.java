package com.github.garmoza.pizza.rest.data;

import com.github.garmoza.pizza.rest.domain.Pizza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Long> {
}
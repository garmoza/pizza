package com.github.garmoza.pizza.admin.data;

import com.github.garmoza.pizza.admin.domain.Pizza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Long> {
}
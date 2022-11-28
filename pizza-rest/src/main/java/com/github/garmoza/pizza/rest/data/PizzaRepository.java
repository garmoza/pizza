package com.github.garmoza.pizza.rest.data;

import com.github.garmoza.pizza.rest.domain.Pizza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:5173")
public interface PizzaRepository extends CrudRepository<Pizza, Long> {
}
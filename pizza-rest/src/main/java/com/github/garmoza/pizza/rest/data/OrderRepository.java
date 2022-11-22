package com.github.garmoza.pizza.rest.data;

import com.github.garmoza.pizza.rest.domain.PizzaOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<PizzaOrder, Long> {
}

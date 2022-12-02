package com.github.garmoza.pizza.admin.data;

import com.github.garmoza.pizza.admin.domain.PizzaOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<PizzaOrder, Long> {
}

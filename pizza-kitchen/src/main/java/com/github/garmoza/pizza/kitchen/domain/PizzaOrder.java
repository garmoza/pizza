package com.github.garmoza.pizza.kitchen.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class PizzaOrder {

    private Long id;

    private Date placedAt = new Date();

    List<Pizza> pizzas = new ArrayList<>();

}

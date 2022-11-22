package com.github.garmoza.pizza.rest.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderModel {

    private Long orderId;
    private Long[] pizzaIds;

}
package com.github.garmoza.pizza.rest.messaging;

import com.github.garmoza.pizza.rest.domain.PizzaOrder;

public interface OrderMessagingService {

    void sendOrder(String topic, PizzaOrder pizzaOrder);

}

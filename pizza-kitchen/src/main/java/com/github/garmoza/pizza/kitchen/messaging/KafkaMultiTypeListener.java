package com.github.garmoza.pizza.kitchen.messaging;

import com.github.garmoza.pizza.kitchen.domain.PizzaOrder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(id = "foo", topics = "kitchen")
@Slf4j
@RequiredArgsConstructor
public class KafkaMultiTypeListener {

    private final KitchenService kitchenService;

    @KafkaHandler
    public void handlePizzaOrder(PizzaOrder pizzaOrder) {
        log.info("PizzaOrder received: {}", pizzaOrder.toString());
        kitchenService.processOrder(pizzaOrder);
    }

    @KafkaHandler(isDefault = true)
    public void unknown(Object object) {
        log.info("Unknown type received: {}", object);
    }

}

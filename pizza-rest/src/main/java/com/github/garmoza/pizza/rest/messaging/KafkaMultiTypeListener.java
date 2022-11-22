package com.github.garmoza.pizza.rest.messaging;

import com.github.garmoza.pizza.rest.domain.PizzaOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(id = "foo", topics = "ready")
@Slf4j
public class KafkaMultiTypeListener {

    @KafkaHandler
    public void handlePizzaOrder(PizzaOrder pizzaOrder) {
        log.info("PizzaOrder received: {}", pizzaOrder.toString());
    }

    @KafkaHandler(isDefault = true)
    public void unknown(Object object) {
        log.info("Unknown type received: {}", object);
    }

}

package com.github.garmoza.pizza.kitchen.messaging;

import com.github.garmoza.pizza.kitchen.domain.PizzaOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KitchenService {

    @Value("${kitchen.broker-topic.application}")
    private String topic;

    private final KafkaTemplate<String, Object> multiTypeKafkaTemplate;

    public void processOrder(PizzaOrder pizzaOrder) {
        multiTypeKafkaTemplate.send(topic, pizzaOrder);
    }

}

package com.github.garmoza.pizza.kitchen.messaging;

import com.github.garmoza.pizza.kitchen.domain.PizzaOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KitchenService {

    private final KafkaTopicProperties kafkaTopicProperties;

    private final KafkaTemplate<String, Object> multiTypeKafkaTemplate;

    public void processOrder(PizzaOrder pizzaOrder) {
        multiTypeKafkaTemplate.send(kafkaTopicProperties.app(), pizzaOrder);
    }

}

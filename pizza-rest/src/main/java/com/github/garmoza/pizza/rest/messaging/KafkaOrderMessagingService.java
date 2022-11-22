package com.github.garmoza.pizza.rest.messaging;

import com.github.garmoza.pizza.rest.domain.PizzaOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaOrderMessagingService implements OrderMessagingService {

    private final KafkaTemplate<String, Object> multiTypeKafkaTemplate;

    @Override
    public void sendOrder(String topic, PizzaOrder pizzaOrder) { multiTypeKafkaTemplate.send(topic, pizzaOrder); }

}

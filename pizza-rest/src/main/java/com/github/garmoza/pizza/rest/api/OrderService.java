package com.github.garmoza.pizza.rest.api;

import com.github.garmoza.pizza.rest.data.OrderRepository;
import com.github.garmoza.pizza.rest.data.PizzaRepository;
import com.github.garmoza.pizza.rest.domain.Pizza;
import com.github.garmoza.pizza.rest.domain.PizzaOrder;
import com.github.garmoza.pizza.rest.messaging.KafkaOrderMessagingService;
import com.github.garmoza.pizza.rest.messaging.KafkaTopicProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final KafkaTopicProperties kafkaTopicProperties;

    private final PizzaRepository pizzaRepo;
    private final OrderRepository orderRepo;

    private final KafkaOrderMessagingService kafkaOrderMessagingService;

    public PizzaOrder createOrder(OrderModel orderModel) {
        PizzaOrder pizzaOrder = new PizzaOrder();
        Iterable<Long> pizzaIds = Arrays.asList(orderModel.getPizzaIds());
        List<Pizza> pizzas = (List<Pizza>) pizzaRepo.findAllById(pizzaIds);
        pizzaOrder.setPizzas(pizzas);

        return orderRepo.save(pizzaOrder);
    }

    public PizzaOrder changeOrder(OrderModel orderModel) {
        Optional<PizzaOrder> optionalPizzaOrder = orderRepo.findById(orderModel.getOrderId());
        if (optionalPizzaOrder.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        PizzaOrder pizzaOrder = optionalPizzaOrder.get();
        Iterable<Long> pizzaIds = Arrays.asList(orderModel.getPizzaIds());
        List<Pizza> pizzas = (List<Pizza>) pizzaRepo.findAllById(pizzaIds);
        pizzaOrder.setPizzas(pizzas);

        return orderRepo.save(pizzaOrder);
    }

    public void deleteOrder(OrderModel orderModel) {
        try {
            orderRepo.deleteById(orderModel.getOrderId());
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_MODIFIED);
        }
    }

    public void confirmOrder(OrderModel orderModel) {
        Optional<PizzaOrder> optionalPizzaOrder = orderRepo.findById(orderModel.getOrderId());
        if (optionalPizzaOrder.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        PizzaOrder pizzaOrder = optionalPizzaOrder.get();
        kafkaOrderMessagingService.sendOrder(kafkaTopicProperties.kitchen(), pizzaOrder);
    }

}

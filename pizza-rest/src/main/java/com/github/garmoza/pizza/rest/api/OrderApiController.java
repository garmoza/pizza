package com.github.garmoza.pizza.rest.api;

import com.github.garmoza.pizza.rest.domain.PizzaOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/orders", produces = "application/json", consumes = "application/json")
@RequiredArgsConstructor
public class OrderApiController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PizzaOrder postOrder(@RequestBody OrderModel orderModel) {
        return orderService.createOrder(orderModel);
    }

    @PutMapping
    public PizzaOrder putOrder(@RequestBody OrderModel orderModel) {
        return orderService.changeOrder(orderModel);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@RequestBody OrderModel orderModel) {
        orderService.deleteOrder(orderModel);
    }

    @PostMapping(path = "confirm")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void confirmOrder(@RequestBody OrderModel orderModel) {
        orderService.confirmOrder(orderModel);
    }

}

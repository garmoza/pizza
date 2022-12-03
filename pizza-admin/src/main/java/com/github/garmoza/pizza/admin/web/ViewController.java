package com.github.garmoza.pizza.admin.web;

import com.github.garmoza.pizza.admin.data.PizzaRepository;
import com.github.garmoza.pizza.admin.domain.Pizza;
import com.github.garmoza.pizza.admin.domain.Pizza.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ViewController {

    private final PizzaRepository pizzaRepository;

    @ModelAttribute
    public void addPizzasToModel(Model model) {
        List<Pizza> pizzas = new ArrayList<>();
        pizzaRepository.findAll().forEach(pizzas::add);

        Type[] types = Pizza.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(pizzas, type));
        }
    }

    @GetMapping
    public String showPizzas() {
        return "view-pizzas";
    }

    private Iterable<Pizza> filterByType(List<Pizza> pizzas, Type type) {
        return pizzas
                .stream()
                .filter(x -> x.getSize().equals(type))
                .collect(Collectors.toList());
    }

}

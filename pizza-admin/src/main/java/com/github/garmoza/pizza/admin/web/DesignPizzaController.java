package com.github.garmoza.pizza.admin.web;

import com.github.garmoza.pizza.admin.data.IngredientRepository;
import com.github.garmoza.pizza.admin.data.PizzaRepository;
import com.github.garmoza.pizza.admin.domain.Pizza;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/design")
@RequiredArgsConstructor
public class DesignPizzaController {

    private final IngredientRepository ingredientRepository;
    private final PizzaRepository pizzaRepository;

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        model.addAttribute("ingredients", ingredientRepository.findAll());
    }

    @ModelAttribute
    public void addSizeToModel(Model model) {
        model.addAttribute("sizes", Pizza.Type.values());
    }


    @ModelAttribute(name = "pizza")
    public Pizza pizza() {
        return new Pizza();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processPizza(Pizza pizza) {
        pizzaRepository.save(pizza);

        return "redirect:/";
    }

}

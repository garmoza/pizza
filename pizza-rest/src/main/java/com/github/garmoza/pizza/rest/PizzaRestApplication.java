package com.github.garmoza.pizza.rest;

import com.github.garmoza.pizza.rest.data.IngredientRepository;
import com.github.garmoza.pizza.rest.data.OrderRepository;
import com.github.garmoza.pizza.rest.data.PizzaRepository;
import com.github.garmoza.pizza.rest.domain.Ingredient;
import com.github.garmoza.pizza.rest.domain.Pizza;
import com.github.garmoza.pizza.rest.domain.PizzaOrder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class PizzaRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaRestApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository ingredientRepo, PizzaRepository pizzaRepo, OrderRepository orderRepo) {
        return args -> {
            Ingredient dough = new Ingredient("DOUG", "Magic Dough");
            Ingredient tomatoSauce = new Ingredient("TOSA", "Tomato Sauce");
            Ingredient freshBasil = new Ingredient("FRBA", "Fresh Basil");
            Ingredient shrimps = new Ingredient("SHRI", "Shrimps");
            Ingredient sunDriedTomatoes = new Ingredient("SDTO", "Sun-dried Tomatoes");
            Ingredient mozzarella = new Ingredient("MOZZ", "Mozzarella");
            Ingredient olives = new Ingredient("OLIV", "Olives");

            Ingredient pepperoni = new Ingredient("PEPP", "Pepperoni");
            Ingredient oliveOil = new Ingredient("OLOI", "Olive Oil");
            Ingredient driedBasil = new Ingredient("DRBA", "Dried Basil");

            ingredientRepo.save(dough);
            ingredientRepo.save(tomatoSauce);
            ingredientRepo.save(freshBasil);
            ingredientRepo.save(shrimps);
            ingredientRepo.save(sunDriedTomatoes);
            ingredientRepo.save(mozzarella);
            ingredientRepo.save(olives);

            ingredientRepo.save(pepperoni);
            ingredientRepo.save(oliveOil);
            ingredientRepo.save(driedBasil);

            Pizza pizza1 = new Pizza();
            pizza1.setName("Coscarelli");
            pizza1.setPrice(495);
            pizza1.setWeight(320);
            pizza1.setSize(Pizza.Type.REGULAR);
            pizza1.setIngredients(Arrays.asList(dough, tomatoSauce, freshBasil, shrimps, sunDriedTomatoes, mozzarella, olives));
            pizzaRepo.save(pizza1);

            Pizza pizza2 = new Pizza();
            pizza2.setName("Pepperoni Classico");
            pizza2.setPrice(495);
            pizza2.setWeight(320);
            pizza2.setSize(Pizza.Type.REGULAR);
            pizza2.setIngredients(Arrays.asList(dough, tomatoSauce, mozzarella, pepperoni, oliveOil, driedBasil));
            pizzaRepo.save(pizza2);

            Pizza pizza3 = new Pizza();
            pizza3.setName("Mini Pepperoni");
            pizza3.setPrice(295);
            pizza3.setWeight(270);
            pizza3.setSize(Pizza.Type.MINI);
            pizza3.setIngredients(Arrays.asList(dough, tomatoSauce, mozzarella, pepperoni, oliveOil, driedBasil));
            pizzaRepo.save(pizza3);

            PizzaOrder pizzaOrder1 = new PizzaOrder();
            pizzaOrder1.setPizzas(Arrays.asList(pizza1, pizza2));
            orderRepo.save(pizzaOrder1);

            PizzaOrder pizzaOrder2 = new PizzaOrder();
            pizzaOrder2.setPizzas(Arrays.asList(pizza3, pizza1));
            orderRepo.save(pizzaOrder2);
        };
    }

}

package com.github.garmoza.pizza.kitchen.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Pizza {

    private Long id;

    private String name;
    private Integer price;
    private Integer weight;
    private Type size;

    private List<Ingredient> ingredients = new ArrayList<>();

    public enum Type {
        REGULAR, MINI
    }

}

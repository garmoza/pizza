package com.github.garmoza.pizza.rest.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer price;
    private Integer weight;
    private Type size;

    @ManyToMany
    private List<Ingredient> ingredients = new ArrayList<>();

    public enum Type {
        REGULAR, MINI
    }

}

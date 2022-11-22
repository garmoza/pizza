package com.github.garmoza.pizza.kitchen.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class Ingredient {

    private final String id;
    private final String name;

}
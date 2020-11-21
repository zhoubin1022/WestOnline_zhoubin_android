package com.company;

/**
 * create By zb on 2020/11/5.
 */
public class IngredientSortOutException extends RuntimeException {
    public IngredientSortOutException(SetMeal meal){
        System.out.println("The "+meal.getDrink().name+" is not enough.");
    }
}

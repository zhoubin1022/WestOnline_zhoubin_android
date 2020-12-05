package com.company;

import java.util.ArrayList;

/**
 * create By zb on 2020/11/5.
 */
public interface FriedChickenRestaurant {
    double sale(ArrayList<SetMeal> foods);
    void purchase(int num_beer,int num_juice);
}

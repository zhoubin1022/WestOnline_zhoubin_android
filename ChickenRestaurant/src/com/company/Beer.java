package com.company;

import java.time.LocalDate;

/**
 * create By zb on 2020/11/5.
 */
public class Beer extends Drinks {
    public static double beer_Purchase_Price=3.0;
    public static double beer_Sell_Price=10.0;
    private float alcohol;

    public Beer(String name, LocalDate dateOfManufacture, float alcohol) {
        super(name, beer_Purchase_Price, dateOfManufacture, 30);
        this.alcohol = alcohol;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "alcohol=" + alcohol +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", DateOfManufacture=" + DateOfManufacture +
                ", SafetyDate=" + SafetyDate +
                '}';
    }
}

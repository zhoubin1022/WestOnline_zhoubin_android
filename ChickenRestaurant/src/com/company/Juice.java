package com.company;

import java.time.LocalDate;

/**
 * create By zb on 2020/11/5.
 */
public class Juice extends Drinks {
    public static double juice_Purchase_Price=5.0;
    public static double juice_Sell_Price=15.0;
    public Juice(String name, LocalDate dateOfManufacture) {
        super(name, juice_Purchase_Price, dateOfManufacture, 20);
    }

    @Override
    public String toString() {
        return "Juice{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", DateOfManufacture=" + DateOfManufacture +
                ", SafetyDate=" + SafetyDate +
                '}';
    }
}

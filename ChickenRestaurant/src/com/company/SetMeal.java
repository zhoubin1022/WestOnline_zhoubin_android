package com.company;

/**
 * create By zb on 2020/11/5.
 */
public class SetMeal {
    public static double price_chicken=25.0;
    private int id;
    private String setName;
    private double setPrice;
    private String chickenName;
    private Drinks drink;

    public SetMeal(int id,String setName, String chickenName, Drinks drink) {
        this.id=id;
        this.setName = setName;
        this.chickenName = chickenName;
        this.drink = drink;
        if(drink instanceof Beer){
            setPrice=Beer.beer_Sell_Price+price_chicken;
        }else if(drink instanceof Juice){
            setPrice=Juice.juice_Sell_Price+price_chicken;
        }else{
            System.out.println("Drink error!");
        }
    }

    @Override
    public String toString() {
        return "SetMeal{" +
                "setName='" + setName + '\'' +
                ", setPrice=" + setPrice +
                ", chickenName='" + chickenName + '\'' +
                ", drink=" + drink +
                '}';
    }

    public static double getPrice_chicken() {
        return price_chicken;
    }

    public int getId() {
        return id;
    }

    public String getSetName() {
        return setName;
    }

    public double getSetPrice() {
        return setPrice;
    }

    public String getChickenName() {
        return chickenName;
    }

    public Drinks getDrink() {
        return drink;
    }
}

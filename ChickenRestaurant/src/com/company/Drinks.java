package com.company;

import java.time.LocalDate;

/**
 * create By zb on 2020/11/5.
 */
public abstract class Drinks {
    protected String name;
    protected double cost;
    protected LocalDate DateOfManufacture;
    protected int SafetyDate;

    @Override
    public String toString() {
        return "Drinks{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", DateOfManufacture=" + DateOfManufacture +
                ", SafetyDate=" + SafetyDate +
                '}';
    }

    public Drinks(String name, double cost, LocalDate dateOfManufacture, int safetyDate) {
        this.name = name;
        this.cost = cost;
        DateOfManufacture = dateOfManufacture;
        SafetyDate = safetyDate;
    }
    boolean isOutOfDate(){
        LocalDate today=LocalDate.now();
        today.minusDays(SafetyDate);
        if(today.isBefore(DateOfManufacture)){
           // System.out.println("out");
            return true;
        }
        else return false;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public LocalDate getDateOfManufacture() {
        return DateOfManufacture;
    }

    public void setDateOfManufacture(LocalDate dateOfManufacture) {
        DateOfManufacture = dateOfManufacture;
    }

    public int getSafetyDate() {
        return SafetyDate;
    }

    public void setSafetyDate(int safetyDate) {
        SafetyDate = safetyDate;
    }
}

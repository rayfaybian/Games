package io.CarGenerator;

import java.util.Scanner;

public class Car {
    Scanner input = new Scanner(System.in);
    Engine engine;
    String brand;
    String color;

    public Car(String brand, Engine engine, String color) {
        this.brand = brand;
        this.engine = engine;
        this.color = color;
    }

    @Override
    public String toString() {
        return brand + ";" + color + ";" + engine.toString() + ";" + calculatePrice() + "\n";
    }

    public int calculatePrice() {
        int priceBrand = 0;
        int priceColor = 0;

        switch (brand) {
            case "Mercedes":
                priceBrand = 50000;
                break;
            case "Audi":
                priceBrand = 55000;
                break;
            case "BMW":
                priceBrand = 60000;
                break;
        }
        switch (color) {
            case "Black":
                priceColor = 5000;
                break;
            case "White":
                priceColor = 8000;
                break;
            case "Red":
                priceColor = 10000;
                break;
        }
        return priceBrand + priceColor + engine.calculatePrice();
    }
}

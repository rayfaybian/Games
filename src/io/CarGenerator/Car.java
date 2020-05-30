package io.CarGenerator;

import java.util.Scanner;

public class Car {
    Scanner input = new Scanner(System.in);
    Engine engine;
    String brand;
    String model;
    String color;

    public Car(String brand, String model, Engine engine, String color) {
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.color = color;
    }

    @Override
    public String toString() {
        return brand + ";" + model + ";" + color + ";" + engine.toString() + ";" + calculatePrice() + "\n";
    }

    public int calculatePrice() {
        int priceBrand = 0;
        int priceModel = 0;
        int priceColor = 0;

        switch (brand) {
            case "Mercedes":
                priceBrand = 25000;
                break;
            case "Audi":
                priceBrand = 40000;
                break;
            case "BMW":
                priceBrand = 30000;
                break;
            case"Seat":
                priceBrand = 5000;
                break;
            case"Skoda":
                priceBrand = 10000;
                break;
            case"Opel":
                priceBrand = 15000;
                break;
            case"Volkswagen":
                priceBrand = 20000;
        }
        switch(model){
            case "A Klasse":
            case "A3":
            case "3er":
            case "Golf":
                priceModel = 10000;
                break;
            case "C Klasse":
            case "A4":
            case "4er":
            case "Passat":
                priceModel = 15000;
                break;
            case "E Klasse":
            case "A5":
            case "5er":
                priceModel = 20000;
                break;
            case "Ibiza":
            case "Fabia":
                priceModel = 2500;
                break;
            case "Leon":
            case "Octavia":
            case "Polo":
                priceModel = 5000;
                break;
            case "Arteca":
            case "Superb":
                priceModel = 7500;
                break;
            case "Astra":
                priceModel = 3000;
                break;
            case "Corsa":
                priceModel = 6000;
                break;
            case "Insignia":
                priceModel = 9000;
                break;


        }
        switch (color) {
            case "Black":
                priceColor = 2000;
                break;
            case "White":
                priceColor = 4000;
                break;
            case "Red":
                priceColor = 6000;
                break;
            case "Yellow":
                priceColor = 8000;
                break;
            case "Green":
                priceColor = 10000;
                break;
            case "Blue":
                priceColor = 12000;
                break;
        }
        return priceBrand + priceModel + priceColor + engine.calculatePrice();
    }
}

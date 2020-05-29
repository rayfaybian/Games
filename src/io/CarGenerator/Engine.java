package io.CarGenerator;

public class Engine {
    Drivetype dt;
    int horsepower;

    public Engine(Drivetype dt, int horsepower) {
        this.dt = dt;
        this.horsepower = horsepower;
    }

    public String getDT() {
        String driveType = "";
        if (dt == Drivetype.GAS) {
            driveType = "Gas";
        }
        if (dt == Drivetype.DIESEL) {
            driveType = "Diesel";
        }

        if (dt == Drivetype.ELECTRIC) {
            driveType = "Electric";
        }
        return driveType;
    }

    @Override
    public String toString() {
        return getDT() + ";" + horsepower;
    }

    public int calculatePrice(){
        int priceDT = 0;
        int priceHP = 0;

        switch (dt){
            case GAS: priceDT = 5000;
            break;
            case DIESEL: priceDT = 8000;
            break;
            case ELECTRIC: priceDT = 10000;
        }
        switch (horsepower){
            case 100: priceHP = 5000;
            break;
            case 150: priceHP = 8000;
            break;
            case 200: priceHP = 10000;
            break;
        }
        return priceDT + priceHP;
    }
}

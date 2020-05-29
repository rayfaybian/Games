package io.CarGenerator;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static io.CarGenerator.Drivetype.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String brand;
        String color;
        int horsepower;
        Drivetype dt;

        List<Car> cars = new ArrayList<>();
        Scanner input = new Scanner(System.in);


        boolean repeat = true;

        while (repeat) {

            brand = setBrand(input);
            color = setColor(input);
            horsepower = setHorsepower(input);
            dt = setDriveType(input);

            Engine myEngine = new Engine(dt, horsepower);
            Car myCar = new Car(brand,myEngine,color);

            cars.add(myCar);

            System.out.println("Do you want to generate another car? y/n");
            char userinput = input.next().charAt(0);
            if (userinput == 'n') {
            repeat = false;
            }
        }
        File carFile = new File("C:\\Coding\\Games\\src\\io\\files\\carFile.txt");
        FileWriter myFileWriter = new FileWriter(carFile);
        myFileWriter.write("brand;color;drivetype;horsepower;price\n");
        System.out.println("brand;color;drivetype;horsepower;price");
        for (Car car: cars) {
            System.out.print(car.toString());
            myFileWriter.write(car.toString());

        }
        myFileWriter.close();
    }

    public static Drivetype setDriveType(Scanner input) {
        System.out.println("Choose Drivetype");
        System.out.println(" -1- Gas\n -2- Diesel\n -3- Electric");

        Drivetype dt = null;
        try {

            int userinput = input.nextInt();
            switch (userinput) {
                case 1:
                    dt = GAS;

                    break;
                case 2:
                    dt = DIESEL;

                    break;
                case 3:
                    dt = ELECTRIC;

                    break;
                default:
                    System.out.println("Please select 1,2 or 3");

            }
        } catch (Exception e) {
            System.out.println("Wrong input. Exit Program.");
            System.exit(0);
        }
        return dt;
    }


    public static int setHorsepower(Scanner input) {
        System.out.println("Choose horsepower");
        System.out.println(" -1- 100\n -2- 150\n -3- 200");

        int horsepower = 0;
        try {

            int userinput = input.nextInt();
            switch (userinput) {
                case 1:
                    horsepower = 100;

                    break;
                case 2:
                    horsepower = 150;

                    break;
                case 3:
                    horsepower = 200;

                    break;
                default:
                    System.out.println("Please select 1,2 or 3");

            }
        } catch (Exception e) {
            System.out.println("Wrong input. Exit Program.");
            System.exit(0);
        }
        return horsepower;
    }


    public static String setColor(Scanner input) {
        System.out.println("Pick a color");
        System.out.println(" -1- Black\n -2- White\n -3- Red");

        String color = "";
        try {

            int userinput = input.nextInt();
            switch (userinput) {
                case 1:
                    color = "Black";

                    break;
                case 2:
                    color = "White";

                    break;
                case 3:
                    color = "Red";

                    break;
                default:
                    System.out.println("Please select 1,2 or 3");

            }
        } catch (Exception e) {
            System.out.println("Wrong input. Exit Program.");
            System.exit(0);
        }

        return color;
    }


    public static String setBrand(Scanner input) {

        System.out.println("Welcome to the car generator.");
        System.out.println("Pick a brand");
        System.out.println(" -1- Mercedes\n -2- Audi\n -3- BMW\n");

        String brand = "";
        try {

            int userinput = input.nextInt();
            switch (userinput) {
                case 1:
                    brand = "Mercedes";

                    break;
                case 2:
                    brand = "Audi";

                    break;
                case 3:
                    brand = "BMW";

                    break;
                default:
                    System.out.println("Please select 1,2 or 3");

            }
        } catch (Exception e) {
            System.out.println("Wrong input. Exit Program.");
            System.exit(0);
        }

        return brand;
    }
}



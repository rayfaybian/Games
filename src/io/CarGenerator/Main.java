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
        String model;
        String color;
        int horsepower;
        Drivetype dt;

        List<Car> cars = new ArrayList<>();
        Scanner input = new Scanner(System.in);


        boolean repeat = true;

        while (repeat) {

            brand = setBrand(input);
            model = setModel(input,brand);
            color = setColor(input);
            dt = setDriveType(input);
            horsepower = setHorsepower(input);

            Engine myEngine = new Engine(dt, horsepower);
            Car myCar = new Car(brand, model, myEngine, color);

            cars.add(myCar);

            System.out.println("Do you want to generate another car?");
            System.out.println(" -y- Yes\n -n- No");
            char userinput = input.next().charAt(0);
            if (userinput == 'n') {
                repeat = false;
            }
        }
        File carFile = new File("C:\\Coding\\Games\\src\\io\\files\\carFile.txt");
        FileWriter myFileWriter = new FileWriter(carFile);
        myFileWriter.write("brand;model;color;drivetype;horsepower;price\n");
        System.out.println("brand;model;color;drivetype;horsepower;price");
        for (Car car : cars) {
            System.out.print(car.toString());
            myFileWriter.write(car.toString());
        }
        myFileWriter.close();
    }


    public static String setBrand(Scanner input) {
        boolean brandSet = false;
        String brand = "";

        System.out.println("Welcome to the car generator.");

        System.out.println("Pick a brand");

        while (!brandSet) {
            System.out.println(" -1- Mercedes\n -2- Audi\n -3- BMW\n -4- Seat\n -5- Skoda\n -6- Opel\n" +
                    " -7- Volkswagen\n");

            try {

                int userinput = input.nextInt();
                switch (userinput) {
                    case 1:
                        brand = "Mercedes";
                        brandSet = true;
                        break;
                    case 2:
                        brand = "Audi";
                        brandSet = true;
                        break;
                    case 3:
                        brand = "BMW";
                        brandSet = true;
                        break;
                    case 4:
                        brand = "Seat";
                        brandSet = true;
                        break;
                    case 5:
                        brand = "Skoda";
                        brandSet = true;
                        break;
                    case 6:
                        brand = "Opel";
                        brandSet = true;
                        break;
                    case 7:
                        brand = "Volkswagen";
                        brandSet = true;
                        break;
                    default:
                        System.out.println("\n+++++ Please select 1,2 or 3 +++++");
                        brandSet = false;
                }
            } catch (
                    Exception e) {
                System.out.println("Wrong input. Exit Program.");
                System.exit(0);
            }
        }

        return brand;
    }

    public static String setModel(Scanner input, String brand) {
        String model = "";
        boolean modelSet = false;

        System.out.println("Pick a model");

        while (!modelSet) {
            if (brand.equals("Mercedes")) {
                System.out.println(" -1- A Klasse\n -2- C Klasse\n -3- E Klasse");

                try {

                    int userinput = input.nextInt();
                    switch (userinput) {
                        case 1:
                            model = "A Klasse";
                            modelSet = true;
                            break;
                        case 2:
                            model = "C Klasse";
                            modelSet = true;
                            break;
                        case 3:
                            model = "E Klasse";
                            modelSet = true;
                            break;
                        default:
                            System.out.println("\n+++++ Please select 1,2 or 3 +++++");
                            modelSet = false;
                    }
                } catch (Exception e) {
                    System.out.println("Wrong input. Exit Program.");
                    System.exit(0);
                }
            }
            if (brand.equals("Audi")) {
                System.out.println(" -1- A3\n -2- A4\n -3- A5");

                try {

                    int userinput = input.nextInt();
                    switch (userinput) {
                        case 1:
                            model = "A3";
                            modelSet = true;
                            break;
                        case 2:
                            model = "A4";
                            modelSet = true;
                            break;
                        case 3:
                            model = "A5";
                            modelSet = true;
                            break;
                        default:
                            System.out.println("\n+++++ Please select 1,2 or 3 +++++");
                            modelSet = false;
                    }
                } catch (Exception e) {
                    System.out.println("Wrong input. Exit Program.");
                    System.exit(0);
                }
            }
            if (brand.equals("BMW")) {
                System.out.println(" -1- 3er\n -2- 4er\n -3- 5er");

                try {

                    int userinput = input.nextInt();
                    switch (userinput) {
                        case 1:
                            model = "3er";
                            modelSet = true;
                            break;
                        case 2:
                            model = "4er";
                            modelSet = true;
                            break;
                        case 3:
                            model = "5er";
                            modelSet = true;
                            break;
                        default:
                            System.out.println("\n+++++ Please select 1,2 or 3 +++++");
                            modelSet = false;
                    }
                } catch (Exception e) {
                    System.out.println("Wrong input. Exit Program.");
                    System.exit(0);
                }
            }
            if (brand.equals("Seat")) {
                System.out.println(" -1- Ibiza\n -2- Leon\n -3- Ateca");

                try {

                    int userinput = input.nextInt();
                    switch (userinput) {
                        case 1:
                            model = "Ibiza";
                            modelSet = true;
                            break;
                        case 2:
                            model = "Leon";
                            modelSet = true;
                            break;
                        case 3:
                            model = "Ateca";
                            modelSet = true;
                            break;
                        default:
                            System.out.println("\n+++++ Please select 1,2 or 3 +++++");
                            modelSet = false;
                    }
                } catch (Exception e) {
                    System.out.println("Wrong input. Exit Program.");
                    System.exit(0);
                }
            }
            if (brand.equals("Skoda")) {
                System.out.println(" -1- Fabia\n -2- Octavia\n -3- Superb");

                try {

                    int userinput = input.nextInt();
                    switch (userinput) {
                        case 1:
                            model = "Fabia";
                            modelSet = true;
                            break;
                        case 2:
                            model = "Otavia";
                            modelSet = true;
                            break;
                        case 3:
                            model = "Superb";
                            modelSet = true;
                            break;
                        default:
                            System.out.println("\n+++++ Please select 1,2 or 3 +++++");
                            modelSet = false;
                    }
                } catch (Exception e) {
                    System.out.println("Wrong input. Exit Program.");
                    System.exit(0);
                }
            }
            if (brand.equals("Opel")) {
                System.out.println(" -1- Astra\n -2- Corsa\n -3- Insignia");

                try {

                    int userinput = input.nextInt();
                    switch (userinput) {
                        case 1:
                            model = "Astra";
                            modelSet = true;
                            break;
                        case 2:
                            model = "Corsa";
                            modelSet = true;
                            break;
                        case 3:
                            model = "Insignia";
                            modelSet = true;
                            break;
                        default:
                            System.out.println("\n+++++ Please select 1,2 or 3 +++++");
                            modelSet = false;
                    }
                } catch (Exception e) {
                    System.out.println("Wrong input. Exit Program.");
                    System.exit(0);
                }
            }
            if (brand.equals("Volkswagen")) {
                System.out.println(" -1- Polo\n -2- Golf\n -3- Passat");

                try {

                    int userinput = input.nextInt();
                    switch (userinput) {
                        case 1:
                            model = "Polo";
                            modelSet = true;
                            break;
                        case 2:
                            model = "Golf";
                            modelSet = true;
                            break;
                        case 3:
                            model = "Passat";
                            modelSet = true;
                            break;
                        default:
                            System.out.println("\n+++++ Please select 1,2 or 3 +++++");
                            modelSet = false;
                    }
                } catch (Exception e) {
                    System.out.println("Wrong input. Exit Program.");
                    System.exit(0);
                }
            }
        }
        return model;
    }

    public static String setColor(Scanner input) {
        String color = "";
        boolean colorSet = false;

        System.out.println("Pick a color");

        while (!colorSet) {
            System.out.println(" -1- Black\n -2- White\n -3- Red\n -4- Yellow\n -5- Green\n -6- Blue\n");


            try {

                int userinput = input.nextInt();
                switch (userinput) {
                    case 1:
                        color = "Black";
                        colorSet = true;
                        break;
                    case 2:
                        color = "White";
                        colorSet = true;
                        break;
                    case 3:
                        color = "Red";
                        colorSet = true;
                        break;
                    case 4:
                        color = "Yellow";
                        colorSet = true;
                        break;
                    case 5:
                        color = "Green";
                        colorSet = true;
                        break;
                    case 6:
                        color = "Blue";
                        colorSet = true;
                        break;
                    default:
                        System.out.println("\n+++++ Please select 1,2 or 3 +++++");
                        colorSet = false;
                }
            } catch (Exception e) {
                System.out.println("Wrong input. Exit Program.");
                System.exit(0);
            }
        }
        return color;
    }

    public static Drivetype setDriveType(Scanner input) {
        Drivetype dt = null;
        boolean dtSet = false;
        System.out.println("Choose Drivetype");
        while (!dtSet) {
            System.out.println(" -1- Gas\n -2- Diesel\n -3- Electric");


            try {

                int userinput = input.nextInt();
                switch (userinput) {
                    case 1:
                        dt = GAS;
                        dtSet = true;
                        break;
                    case 2:
                        dt = DIESEL;
                        dtSet = true;
                        break;
                    case 3:
                        dt = ELECTRIC;
                        dtSet = true;
                        break;
                    default:
                        System.out.println("Please select 1,2 or 3");
                        dtSet = false;
                }
            } catch (Exception e) {
                System.out.println("\n+++++ Please select 1,2 or 3 +++++");
                System.exit(0);
            }
        }
        return dt;
    }

    public static int setHorsepower(Scanner input) {
        int horsepower = 0;
        boolean horsepowerSet = false;

        System.out.println("Choose horsepower");

        while (!horsepowerSet) {
            System.out.println(" -1- 100\n -2- 150\n -3- 200");


            try {

                int userinput = input.nextInt();
                switch (userinput) {
                    case 1:
                        horsepower = 100;
                        horsepowerSet = true;
                        break;
                    case 2:
                        horsepower = 150;
                        horsepowerSet = true;
                        break;
                    case 3:
                        horsepower = 200;
                        horsepowerSet = true;
                        break;
                    default:
                        System.out.println("\n+++++ Please select 1,2 or 3 +++++");
                        horsepowerSet = false;
                }
            } catch (Exception e) {
                System.out.println("Wrong input. Exit Program.");
                System.exit(0);
            }
        }
        return horsepower;
    }
}



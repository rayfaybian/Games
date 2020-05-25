package io.ioTest;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        /*A Company with People working in various Departments imported from a .txt file*/

        Department vorstand = new Department("Vorstand");
        Department einkauf = new Department("Einkauf");
        Department einkaufEuropa = new Department("Einkauf Europa");
        Department einkaufItalien = new Department("Einkauf Italien");
        Department einkaufUSA = new Department("Einkauf USA");
        Department vertrieb = new Department("Vertrieb");
        Department vertriebEuropa = new Department("Vertrieb Europa");

        Company myCompany = new Company("Hello World Company");
        myCompany.addDepartment(vorstand);
        myCompany.addDepartment(einkauf);
        myCompany.addDepartment(einkaufEuropa);
        myCompany.addDepartment(einkaufItalien);
        myCompany.addDepartment(einkaufUSA);
        myCompany.addDepartment(vertrieb);
        myCompany.addDepartment(vertriebEuropa);

        File file = new File("src/io/files/Abteilungen.txt");

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineArray = line.split(";");

                for (int i = 0; i < myCompany.getDepartments().size(); i++) {
                    if (myCompany.getDepartments().get(i).getName().equalsIgnoreCase(lineArray[1])) {
                        Person person = new Person(lineArray[0]);
                        myCompany.getDepartments().get(i).addPeople(person);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Your file was not found!");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        myCompany.printCompanyDetails();
    }

}

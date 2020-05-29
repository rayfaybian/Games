package io.ioTest2;

import io.ioTest.Company;
import io.ioTest.Department;
import io.ioTest.Person;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        Company myCompany = new Company("Ländle Code");

        File file = new File("src/io/files/Abteilungen2.txt");

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineArray = line.split(";");

                if (!lineArray[0].equalsIgnoreCase("PersonenName")) {

                    if ((myCompany.getDepartments().isEmpty()) || (!myCompany.checkDepartments(lineArray[1]))) {
                        Department department = new Department(lineArray[1]);
                        myCompany.addDepartment(department);
                        if (lineArray.length > 2) {
                            for (Department department3 : myCompany.getDepartments()) {
                                if ((department3.getName().equals(lineArray[2])) &&
                                        !department3.getSubdivisionsName().contains(department.getName())) {
                                    department3.addSubdivisions(department);
                                }
                            }
                        }
                    }

                    for (int i = 0; i < myCompany.getDepartments().size(); i++) {
                        if (myCompany.getDepartments().get(i).getName().equalsIgnoreCase(lineArray[1])) {
                            Person person = new Person(lineArray[0]);
                            myCompany.getDepartments().get(i).addPeople(person);

                        }
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

package io.ioTest;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void printCompanyDetails() {
        System.out.println(name + "\n");
        for (Department department : departments) {
            System.out.println(department.getName() + ": " + department.getPeople());
        }
        System.out.println("--------------------------------------------");

        for (Department department : departments) {
            department.printDepartmentStructure();

        }
    }

    public boolean checkDepartments(String name) {
        boolean departementExists = false;

            for (Department department : departments) {
                if (department.getName().equalsIgnoreCase(name)) {
                    departementExists = true;
                    break;
                }
            }

        return departementExists;
    }
}

package io.ioTest;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Person> people;
    private List<Department> subdivisions;

    public Department(String name) {
        this.name = name;
        this.people = new ArrayList<>();
        this.subdivisions = new ArrayList<>();
    }

    public void addPeople(Person person) {
        people.add(person);
    }

    public String getName() {
        return name;
    }

    public String getPeople() {
        for (Person person : people) {
            return person.getName();
        }
        return null;
    }

    public void addSubdivisions(Department department) {
        subdivisions.add(department);
    }

    public List<Department> getSubdivisions() {
        return subdivisions;
    }

    public String getSubdivisionsName() {
        if (subdivisions.size() > 0) {
            for (Department department : subdivisions) {
                return department.name;
            }
        }
        return "list is empty";
    }

    public void printDepartmentStructure() {
        if (subdivisions.size() > 0) {
            System.out.println(getName() + " subdivisions:");
            for (Department department : subdivisions) {
                System.out.println("- " + department.getName());

            }
            System.out.println();
        }
    }

}

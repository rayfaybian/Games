package io.ioTest;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Person> people;

    public Department(String name) {
        this.name = name;
        this.people = new ArrayList<>();
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

}

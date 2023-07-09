package org.blbulyandavbulyan.seminar3.studentapp.domen;

import org.blbulyandavbulyan.seminar3.studentapp.domen.protypes.EmployeePrototype;

public class Employee extends EmployeePrototype<String, Integer, String> {
    private String special;
    public Employee(String firstName, int age, String special) {
        super(firstName, age, special);
        this.special = special;
    }

    public String getSpecial() {
        return special;
    }
}
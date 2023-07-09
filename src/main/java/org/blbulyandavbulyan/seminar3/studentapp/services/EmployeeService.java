package org.blbulyandavbulyan.seminar3.studentapp.services;

import org.blbulyandavbulyan.seminar3.studentapp.domen.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeService implements IPersonService<Employee>{
    private final List<Employee> employees;
    public EmployeeService() {
        this.employees = new ArrayList<>();
    }
    @Override
    public List<Employee> getAll() {
        return Collections.unmodifiableList(employees);
    }
    @Override
    public void create(String firstName, int age) {
        employees.add(new Employee(firstName, age, "unknown"));
    }
}

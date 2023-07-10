package org.blbulyandavbulyan.seminar3.studentapp.services;

import org.blbulyandavbulyan.seminar3.studentapp.domen.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Предоставляет сервис сотрудников
 */
public class EmployeeService implements IPersonService<Employee>{
    private final List<Employee> employees;

    /**
     * Создаёт экземпляр сервиса сотрудников
     */
    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    /**
     * Получает всех сотрудников
     * @return неизменяемый список сотрудников
     */
    @Override
    public List<Employee> getAll() {
        return Collections.unmodifiableList(employees);
    }

    /**
     * Создаёт сотрудника с заданным именем и возрастом
     * @param firstName имя
     * @param age возраст
     */
    @Override
    public void create(String firstName, int age) {
        employees.add(new Employee(firstName, age, "unknown"));
    }
}

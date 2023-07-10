package org.blbulyandavbulyan.seminar3.studentapp.domen;

import org.blbulyandavbulyan.seminar3.studentapp.domen.protypes.EmployeePrototype;

/**
 * Предоставляет сотрудника со строковым именем, строковой специальностью и с целочисленным ид
 */
public class Employee extends EmployeePrototype<String, Integer, String> {
    /**
     * Создаёт сотрудника с заданным именем, возрастом и специальностью
     * @param firstName имя
     * @param age возраст
     * @param speciality специальность
     */
    public Employee(String firstName, int age, String speciality) {
        super(firstName, age, speciality);
    }
}
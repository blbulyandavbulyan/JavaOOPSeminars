package org.blbulyandavbulyan.seminar3.studentapp.domen;

import org.blbulyandavbulyan.seminar3.studentapp.domen.protypes.StudentPrototype;

/**
 * Предоставляет студента<br>
 * Тип имени - строка<br>
 * Тип возраста - Integer<br>
 * Тип ид - Integer<br>
 */
public class Student extends StudentPrototype<String, Integer, Integer> {

    /**
     * Создаёт экземпляр человека с переданным возрастом и именем
     *
     * @param name имя человека
     * @param age  возраст человека
     */
    public Student(String name, Integer age, Integer id) {
        super(age, name, id);
    }

    public Student(String name, int age) {
        this(name, age, null);
    }
}

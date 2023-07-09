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
     * @param age  возраст человека
     * @param name имя человека
     */
    public Student(Integer age, String name, Integer id) {
        super(age, name, id);
    }
}

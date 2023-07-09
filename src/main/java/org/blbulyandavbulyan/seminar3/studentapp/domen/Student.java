package org.blbulyandavbulyan.seminar3.studentapp.domen;

import org.blbulyandavbulyan.seminar3.studentapp.domen.protypes.GenericStudent;

/**
 * Предоставляет студента, наследника человека
 */
public class Student extends GenericStudent<String, Integer, Integer> {

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

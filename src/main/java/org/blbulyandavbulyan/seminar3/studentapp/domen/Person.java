package org.blbulyandavbulyan.seminar3.studentapp.domen;

import org.blbulyandavbulyan.seminar3.studentapp.domen.protypes.GenericPerson;

/**
 * Предоставляет человека, у которого есть возраст и имя
 */
public class Person extends GenericPerson<String, Integer> {

    /**
     * Создаёт экземпляр человека с переданным возрастом и именем
     *
     * @param age  возраст человека
     * @param name имя человека
     */
    public Person(Integer age, String name) {
        super(age, name);
    }
}

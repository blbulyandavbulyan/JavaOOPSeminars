package org.blbulyandavbulyan.seminar3.studentapp.domen;
import org.blbulyandavbulyan.seminar3.studentapp.domen.protypes.PersonPrototype;
/**
 * Предоставляет человека, у которого есть возраст и имя
 * Возраст - целое число
 * Имя - строка
 */
public class Person extends PersonPrototype<String, Integer> {

    /**
     * Создаёт экземпляр человека с переданным возрастом и именем
     *
     * @param age  возраст человека
     * @param name имя человека
     */
    public Person(Integer age, String name) {
        super(name, age);
    }
}

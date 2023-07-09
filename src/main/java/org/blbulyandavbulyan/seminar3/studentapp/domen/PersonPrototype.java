package org.blbulyandavbulyan.seminar3.studentapp.domen;

/**
 * Предоставляет человека, у которого есть возраст и имя
 */
public class PersonPrototype extends org.blbulyandavbulyan.seminar3.studentapp.domen.protypes.PersonPrototype<String, Integer> {

    /**
     * Создаёт экземпляр человека с переданным возрастом и именем
     *
     * @param age  возраст человека
     * @param name имя человека
     */
    public PersonPrototype(Integer age, String name) {
        super(age, name);
    }
}

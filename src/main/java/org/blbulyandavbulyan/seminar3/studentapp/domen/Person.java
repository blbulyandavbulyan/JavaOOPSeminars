package org.blbulyandavbulyan.seminar3.studentapp.domen;

/**
 * Предоставляет человека, у которого есть возраст и имя
 */
public class Person {
    /**
     * Возраст человека
     */
    protected int age;
    /**
     * Имя человека
     */
    protected String name;

    /**
     * Создаёт экземпляр человека с переданным возрастом и именем
     * @param age возраст человека
     * @param name имя человека
     */
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    /**
     * Устанавливает возраст данного человека
     * @param age возраст, который нужно установить данному человеку
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Устанавливает имя человека
     * @param name имя, которое нужно установить данному человеку
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получает возраст человека
     * @return возраст данного человека
     */
    public int getAge() {
        return age;
    }

    /**
     * Получает имя человека
     * @return имя, данного человека
     */
    public String getName() {
        return name;
    }
}

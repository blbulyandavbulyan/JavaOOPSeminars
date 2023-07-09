package org.blbulyandavbulyan.seminar3.studentapp.domen.protypes;

/**
 * Предоставляет шаблонизированного человека
 * @param <NT>
 * @param <AT>
 */
public class GenericPerson <NT, AT extends Number>{
    /**
     * Возраст человека
     */
    protected AT age;
    /**
     * Имя человека
     */
    protected NT name;

    /**
     * Создаёт экземпляр человека с переданным возрастом и именем
     * @param age возраст человека
     * @param name имя человека
     */
    public GenericPerson(AT age, NT name) {
        this.age = age;
        this.name = name;
    }

    /**
     * Устанавливает возраст данного человека
     * @param age возраст, который нужно установить данному человеку
     */
    public void setAge(AT age) {
        this.age = age;
    }

    /**
     * Устанавливает имя человека
     * @param name имя, которое нужно установить данному человеку
     */
    public void setName(NT name) {
        this.name = name;
    }

    /**
     * Получает возраст человека
     * @return возраст данного человека
     */
    public AT getAge() {
        return age;
    }

    /**
     * Получает имя человека
     * @return имя, данного человека
     */
    public NT getName() {
        return name;
    }
}
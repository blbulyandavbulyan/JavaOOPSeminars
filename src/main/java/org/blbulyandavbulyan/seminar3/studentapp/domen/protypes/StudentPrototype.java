package org.blbulyandavbulyan.seminar3.studentapp.domen.protypes;

/**
 * Предоставляет шаблонизированного студента
 * @param <NT> тип имени(такой же будет и в родителе)
 * @param <AT> тип возраста(такой же будет и в родителе)
 * @param <IT> тип ИД
 */

public class StudentPrototype<NT, AT extends Number, IT> extends PersonPrototype<NT, AT> {
    /**
     * ИД студента
     */
    private IT id;

    /**
     * Создаёт студента с переданным возрастом, именем и ИД
     * @param age возраст студента
     * @param name имя студента
     * @param id ИД студента
     */
    public StudentPrototype(AT age, NT name, IT id) {
        super(name, age);
        this.id = id;
    }

    /**
     * Получает ИД студента
     * @return ИД студента
     */
    public IT getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

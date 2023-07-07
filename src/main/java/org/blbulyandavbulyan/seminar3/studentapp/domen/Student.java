package org.blbulyandavbulyan.seminar3.studentapp.domen;

/**
 * Предоставляет студента, наследника человека
 */
public class Student extends Person{
    /**
     * ИД студента
     */
    private int id;

    /**
     * Создаёт студента с переданным возрастом, именем и ИД
     * @param age возраст студента
     * @param name имя студента
     * @param id ИД студента
     */
    public Student(int age, String name, int id) {
        super(age, name);
        this.id = id;
    }

    /**
     * Получает ИД студента
     * @return ИД студента
     */
    public int getId() {
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

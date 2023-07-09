package org.blbulyandavbulyan.seminar3.studentapp.domen.protypes;


public class GenericStudent<NT, AT extends Number, IT> extends GenericPerson<NT, AT> {
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
    public GenericStudent(AT age, NT name, IT id) {
        super(age, name);
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

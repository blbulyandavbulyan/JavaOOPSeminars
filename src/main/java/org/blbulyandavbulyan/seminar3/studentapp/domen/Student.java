package org.blbulyandavbulyan.seminar3.studentapp.domen;

public class Student extends Person{
    private int id;
    public Student(int age, String name, int id) {
        super(age, name);
        this.id = id;
    }

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

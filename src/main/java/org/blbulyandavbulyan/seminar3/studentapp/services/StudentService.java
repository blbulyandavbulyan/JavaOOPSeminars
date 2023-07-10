package org.blbulyandavbulyan.seminar3.studentapp.services;

import org.blbulyandavbulyan.seminar3.studentapp.domen.Student;
import org.blbulyandavbulyan.seminar3.studentapp.utils.PersonComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentService implements IPersonService<Student> {
    private int count;
    private final List<Student> students;
    private final List<Student> unmodifiableStudents;

    public StudentService() {
        this.students = new ArrayList<>();
        unmodifiableStudents = Collections.unmodifiableList(students);
    }

    @Override
    public List<Student> getAll() {
        return unmodifiableStudents;
    }

    @Override
    public void create(String name, int age) {
        Student per = new Student(name, age, count);
        count++;
        students.add(per);
    }

    public void sortByFioAndThanByAge() {
        //здесь мне повезло и diamond operator магическим образом вывел за меня все generics параметры
        students.sort(new PersonComparator<>());
    }
}

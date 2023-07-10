package org.blbulyandavbulyan.seminar3.studentapp.services;

import org.blbulyandavbulyan.seminar3.studentapp.domen.Student;
import org.blbulyandavbulyan.seminar3.studentapp.utils.PersonComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Предоставляет сервис студентов
 */
public class StudentService implements IPersonService<Student> {
    /**
     * Количество созданных студентов и будущее ИД
     */
    private int count;
    /**
     * Список студентов, с которыми работает данный сервис
     */
    private final List<Student> students;
    /**
     * Не модифицируемое view над {@link StudentService#students}
     */
    private final List<Student> unmodifiableStudents;

    /**
     * Создаёт пустой сервис студентов
     */
    public StudentService() {
        this.students = new ArrayList<>();
        unmodifiableStudents = Collections.unmodifiableList(students);
    }

    /**
     * Получает всех студентов в данном сервисе
     * @return не модифицируемый список студентов
     */
    @Override
    public List<Student> getAll() {
        return unmodifiableStudents;
    }

    /**
     * Создаёт студента в данном сервисе
     * @param name имя будущего студента
     * @param age возраст будущего студента
     */
    @Override
    public void create(String name, int age) {
        Student per = new Student(name, age, count);
        count++;
        students.add(per);
    }

    /**
     * Сортирует студентов по имени, а затем по возрасту
     */
    public void sortByNameAndThanByAge() {
        //здесь мне повезло и diamond operator магическим образом вывел за меня все generics параметры
        students.sort(new PersonComparator<>());
    }
}

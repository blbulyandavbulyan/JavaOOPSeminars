package org.blbulyandavbulyan.seminar3.studentapp.services;

import org.blbulyandavbulyan.seminar3.studentapp.domen.Teacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Сервис учителей
 */
public class TeacherService implements IPersonService<Teacher>{
    /**
     * Список учителей
     */
    private final List<Teacher> teachers;
    /**
     * Не модифицируемое view над списком учителей
     */
    private final List<Teacher> unmodifiableTeachers;

    /**
     * Создаёт экземпляр сервиса учителей
     */
    public TeacherService(){
        teachers = new ArrayList<>();
        this.unmodifiableTeachers = Collections.unmodifiableList(teachers);
    }

    /**
     * Получает список учителей в данном сервисе
     * @return не модифицируемый список учителей
     */
    @Override
    public List<Teacher> getAll() {
        return unmodifiableTeachers;
    }

    @Override
    public void create(String name, int age) {
        teachers.add(new Teacher(name, age, "unknown"));
    }

    /**
     * Метод сортирует учителей в соответствии с переданным компаратором
     * @param teacherComparator компаратор, который будет использоваться для сортировки
     */
    public void sort(Comparator<? super Teacher> teacherComparator){
        teachers.sort(teacherComparator);
    }
}

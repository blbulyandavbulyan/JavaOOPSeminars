package org.blbulyandavbulyan.seminar5.studentmvc.controllers;

import org.blbulyandavbulyan.seminar3.studentapp.domen.Student;

import java.util.Collection;

/**
 * Предоставляет интерфейс для модели студентов
 */
public interface IModel {
    /**
     * Находит всех студентов в модели
     * @return всех студентов в модели
     */
    Collection<Student> findAll();

    /**
     * Добавляет студента в модель
     * @param student студент, которого нужно добавить
     */
    void add(Student student);

    void update(Student student);

    /**
     * Удаляет студента из модели
     * @param student студент, которого нужно удалить
     * @return true если такой студент был, иначе false
     */
    boolean delete(Student student);
}

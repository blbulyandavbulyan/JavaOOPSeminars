package org.blbulyandavbulyan.seminar5.studentmvc.controllers;

import org.blbulyandavbulyan.seminar3.studentapp.domen.Student;

import java.util.Collection;

/**
 * Предоставляет интерфейс для модели студентов
 */
public interface IModel {
    /**
     * Находит всех студентов в модели
     * @return всех студентов в модели или пустую коллекцию, если таковых нет
     */
    Collection<Student> findAll();

    /**
     * Добавляет студента в модель
     * @param student студент, которого нужно добавить
     * @throws IllegalArgumentException если студент null
     * @throws org.blbulyandavbulyan.seminar5.studentmvc.controllers.exceptions.StudentAlreadyExistsException если студент уже существует
     */
    void add(Student student);
    /**
     * Удаляет студента из модели
     * @param student студент, которого нужно удалить
     * @return true если такой студент был, иначе false
     */
    boolean delete(Student student);
}

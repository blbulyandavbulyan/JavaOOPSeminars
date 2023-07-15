package org.blbulyandavbulyan.seminar5.studentmvc.controllers;

import org.blbulyandavbulyan.seminar3.studentapp.domen.Student;

import java.util.Collection;
import java.util.function.Supplier;

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
     * @param idForDelete ИД студента, которого нужно удалить
     * @return true если такой студент был, иначе false
     */
    boolean delete(int idForDelete);

    /**
     * Проверяет, содержится ли студент с заданным ИД в модели
     * @param studentId ид студента для проверки
     * @return true если такой студент в модели есть
     */
    boolean contains(int studentId);

    /**
     * Устанавливает источник новых ИД для студентов
     * @param nextStudentIdSupplier функция, возвращающая уникальное целое число при каждом вызове
     */
    void setNextStudentIdSupplier(Supplier<Integer> nextStudentIdSupplier);
}

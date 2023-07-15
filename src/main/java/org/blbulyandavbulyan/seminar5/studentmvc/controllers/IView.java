package org.blbulyandavbulyan.seminar5.studentmvc.controllers;

import org.blbulyandavbulyan.seminar3.studentapp.domen.Student;

import java.util.Collection;

/**
 * Данный интерфейс предоставляет view для контроллера
 */
public interface IView {
    /**
     * Метод отображает студентов
     * @param students студенты, которых нужно отобразить
     */
    void displayStudents(Collection<Student> students);
    void updateView(Collection<Student> students);

    /**
     * Метод получает ИД студента для удаления
     * @return ИД студента, которого нужно удалить
     */
    int getStudentIdForDelete();
    Student selectStudentForUpdate(Collection<Student> students);

    /**
     * Метод получает студента для добавления
     * @return студент, которого нужно добавить
     */
    Student getStudentForAdd();

    /**
     * Метод получает команду для обработки в цикле команд
     * @return команда, которую нужно обработать
     */
    Command getCommand();
}

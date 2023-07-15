package org.blbulyandavbulyan.seminar5.studentmvc.controllers;

/**
 * Перечисление команд для контроллера
 */
public enum Command {
    /**
     * Получить список студентов
     */
    LIST,
    /**
     * Удалить студента
     */
    DELETE,
    /**
     * Добавить студента
     */
    ADD,
    /**
     * Выход из цикла обработки команд
     */
    EXIT
}

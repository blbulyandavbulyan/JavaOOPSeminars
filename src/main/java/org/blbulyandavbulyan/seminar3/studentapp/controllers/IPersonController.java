package org.blbulyandavbulyan.seminar3.studentapp.controllers;

import org.blbulyandavbulyan.seminar3.studentapp.domen.protypes.PersonPrototype;

/**
 * Предоставляет обобщённый контроллер над персонами
 * @param <PT> тип персоны, которыми будет оперировать контроллер
 */
public interface IPersonController <PT extends PersonPrototype<String, Integer>> {
    /**
     * Метод создаёт персону с заданным именем и возрастом
     * @param firstName имя будущей персоны
     * @param age возраст будущей персоны
     */
    void create(String firstName, int age);
}

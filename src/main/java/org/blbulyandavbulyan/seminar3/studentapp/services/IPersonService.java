package org.blbulyandavbulyan.seminar3.studentapp.services;

import org.blbulyandavbulyan.seminar3.studentapp.domen.protypes.PersonPrototype;

import java.util.List;

/**
 * Сервис для персон
 * @param <PT> тип персоны, обрабатываемой данным сервисом
 */
public interface IPersonService <PT extends PersonPrototype<String, Integer>> {
    /**
     * Получает всех персон
     * @return неизменяемый список персон
     */
    List<PT> getAll();

    /**
     * Создаёт персону с заданным именем и возрастом
     * @param name имя будущей персоны
     * @param age возраст будущей персоны
     */
    void create(String name, int age);
}

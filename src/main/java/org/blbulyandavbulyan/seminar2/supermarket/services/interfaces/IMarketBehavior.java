package org.blbulyandavbulyan.seminar2.supermarket.services.interfaces;

import org.blbulyandavbulyan.seminar2.supermarket.domen.Actor;

import java.util.List;

/**
 * Данный интерфейс предоставляет абстракцию над поведением магазина
 */
public interface IMarketBehavior {
    /**
     * Принимает клиента в магазин
     * @param actor клиент, которого нужно принять
     */
    void acceptToMarket(Actor actor);

    /**
     * Выводит клиентов из магазина
     * @param actors список клиентов, которых нужно вывести из магазина
     */
    void releaseFromMarket(List<Actor> actors);

    /**
     * Возвращает заказы клиентам
     */
    void returnOrders();

    /**
     * Управляющий и основной метод, отвечает за всю логику магазина
     */
    void update();

}

package org.blbulyandavbulyan.seminar2.supermarket.services.interfaces;

import org.blbulyandavbulyan.seminar2.supermarket.domen.Actor;

/**
 * Данный интерфейс предоставляет абстракцию над поведением очереди для заказов в магазине
 */
public interface IQueueBehavior {
    /**
     * Освобождает очередь на возврат товаров
     */
    void releaseFromReturnQueue();

    /**
     * Принимает клиента в очередь
     * @param actor клиент, которого нужно принять
     */
    void takeInQueue(Actor actor);

    /**
     * Освобождает очередь для заказов в магазине
     */
    void releaseFromQueue();

    /**
     * Просит клиентов сделать свой заказ
     */
    void makeOrder();

    /**
     * Выдаёт клиентам заказы
     */
    void giveOrder();
}

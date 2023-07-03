package org.blbulyandavbulyan.seminar2.supermarket.services.interfaces;

/**
 * Интерфейс для возврата товаров
 */
public interface IReturnOrder {
    /**
     * Метод по возвращению товара, будет вызываться, пока isItNeededToReturnOrder не вернёт false
     * работает в паре с wasOrdersReturn
     */
    void returnOrder();

    /**
     * Данный метод проверяет, нужно ли данному пользователю возвращать товар
     * @return true если нужно, иначе false
     */
    boolean isItNeededToReturnOrder();
}

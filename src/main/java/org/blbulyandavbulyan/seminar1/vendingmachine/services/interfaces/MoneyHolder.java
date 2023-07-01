package org.blbulyandavbulyan.seminar1.vendingmachine.services.interfaces;

/**
 * Данный интерфейс описывает держатель денег с поддержкой
 */
public interface MoneyHolder {
    /**
     * Берёт сумму и добавляет её в хранилище
     * @param amountOfMoney сумма, которую нужно
     * @throws IllegalArgumentException если amountOfMoney <= 0
     */
    void addAmount(int amountOfMoney);

    /**
     * Сливает сдачу пользователю
     * @param change сдача, которую нужно вернуть пользователю
     */
    void drain(int change);

}

package org.blbulyandavbulyan.seminar2.supermarket.domen;

import org.blbulyandavbulyan.seminar2.supermarket.services.interfaces.IReturnOrder;

/**
 * Данный класс предоставляет абстрактного клиента для нашего магазина
 */
abstract public class Actor implements IReturnOrder {
    /**
     * Имя клиента
     */
    protected String name;
    /**
     * Получил ли клиент заказ
     */
    protected boolean isTakeOrder;
    /**
     * Сделал ли клиент заказ
     */
    protected boolean isMakeOrder;

    /**
     * Создаёт экземпляр клиента с заданным именем
     * (хотя абстрактный класс нельзя создать)
     * @param name имя, с которым будет проинициализирован данный экземпляр клиента
     */
    protected Actor(String name) {
        this.name = name;
    }

    /**
     * Получает переданное в конструкторе имя
     * @return имя, переданное в конструкторе
     */
    public String getName(){
        return name;
    }

    /**
     * @return взял ли клиент заказ
     */
    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    /**
     * @return сделал ли клиент заказ
     */
    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    /**
     * Меняет состояние взятия заказа
     * @param takeOrder новое состояние
     */
    public void setTakeOrder(boolean takeOrder) {
        isTakeOrder = takeOrder;
    }

    /**
     * Меняет состояние сделания заказа
     * @param makeOrder новое состояние
     */
    public void setMakeOrder(boolean makeOrder) {
        isMakeOrder = makeOrder;
    }

    @Override
    public void returnOrder() {
        //это самая странная имплементация интерфейса которую я когда-либо делал
        //но поскольку в магазине же нет товаров, значит нам как бы и возвращать нечего
        //будет пустой
    }

    @Override
    public boolean isItNeededToReturnOrder() {
        return false;
    }
}

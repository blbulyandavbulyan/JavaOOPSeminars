package org.blbulyandavbulyan.seminar2.supermarket.domen;

import org.blbulyandavbulyan.seminar2.supermarket.services.interfaces.IReturnOrder;

abstract public class Actor implements IReturnOrder {
    protected String name;
    protected boolean isTakeOrder;
    protected boolean isMakeOrder;

    public Actor(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    public void setTakeOrder(boolean takeOrder) {
        isTakeOrder = takeOrder;
    }

    public void setMakeOrder(boolean makeOrder) {
        isMakeOrder = makeOrder;
    }

    @Override
    public void returnOrder() {
        //это самая странная имплементация интерфейса которую я когда-либо делал
        //но поскольку в магазине же нет товаров, значит нам как бы и возвращать нечего
        System.out.println("Вернул товар");
    }
}

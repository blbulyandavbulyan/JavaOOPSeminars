package org.blbulyandavbulyan.seminar1.vendingmachine.services;

import org.blbulyandavbulyan.seminar1.vendingmachine.services.interfaces.MoneyHolder;

public class SimpleMoneyHolder implements MoneyHolder {
    private int amount = 0;
    @Override
    public void addAmount(int amountOfMoney) {
        if(amountOfMoney <= 0)throw new IllegalArgumentException("amount must be greater than 0");
        this.amount+=amountOfMoney;
    }

    @Override
    public void drain(int change) {
        this.amount-=change;
    }
}

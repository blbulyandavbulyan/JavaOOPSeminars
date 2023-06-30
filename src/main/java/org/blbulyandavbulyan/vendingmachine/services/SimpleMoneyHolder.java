package org.blbulyandavbulyan.vendingmachine.services;

import org.blbulyandavbulyan.vendingmachine.services.interfaces.MoneyHolder;

public class SimpleMoneyHolder implements MoneyHolder {
    private boolean isTransactionBegin = false;
    private int transactionalAmount = 0;
    private int commonAmount = 0;
    private int currentAmountToAdd;
    @Override
    public void beginTransaction(int amount) {
        if(isTransactionBegin)throw new IllegalStateException("Transaction is already began!");
        isTransactionBegin = true;
        currentAmountToAdd = amount;
    }

    @Override
    public int transactionalAmount() {
        checkIsTransactionBegin();
        return transactionalAmount;
    }

    @Override
    public int commonAmount() {
        return commonAmount;
    }

    @Override
    public void take(int amountOfMoney) {
        checkIsTransactionBegin();
        if(amountOfMoney <= 0)throw new IllegalArgumentException("amount must be greater than 0");
        this.transactionalAmount+=amountOfMoney;
    }

    @Override
    public int commit() {
        checkIsTransactionBegin();
        int result = transactionalAmount - currentAmountToAdd;
        if(result >= 0){
            this.commonAmount+=currentAmountToAdd;
            return result;
        }
        else throw new RuntimeException("вы внесли недостаточно денег!");
    }

    @Override
    public int rollback() {
        checkIsTransactionBegin();
        int result = transactionalAmount;
        resetTransaction();
        return result;
    }
    private void checkIsTransactionBegin(){
        if(!isTransactionBegin)throw new IllegalStateException("transaction is not began!");
    }
    private void resetTransaction(){
        isTransactionBegin = false;
        currentAmountToAdd = 0;
        transactionalAmount = 0;
    }
}

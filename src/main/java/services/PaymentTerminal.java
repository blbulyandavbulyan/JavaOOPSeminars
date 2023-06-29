package services;

public interface PaymentTerminal {
    int requestAmountOfMoney(int amount);
    void giveBack(int change);
}

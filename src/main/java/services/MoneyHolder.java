package services;

public interface MoneyHolder {

    int amount();
    void take(int amountOfMoney);
    int clear();
}

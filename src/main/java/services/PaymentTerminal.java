package services;

/**
 * Данный класс предназначен для запрашивания у пользователя суммы денег и возвращению ему сдачи
 */
public interface PaymentTerminal {
    /**
     * Запросить сумму денег у пользователя
     * @param amount сумма денег, которую мы запрашиваем
     * @return число >= amount
     */
    int requestAmountOfMoney(int amount);

    /**
     * Отдать пользователю сдачу
     * @param change сдача
     */
    void giveBack(int change);
}

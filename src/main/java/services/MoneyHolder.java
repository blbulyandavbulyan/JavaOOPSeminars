package services;

/**
 * Данный интерфейс описывает держатель денег с поддержкой транзакций
 */
public interface MoneyHolder {
    /**
     * Начинает транзакцию по внесению суммы
     * @param amount сумма для внесения
     * @throws IllegalStateException если транзакция уже начата
     */
    void beginTransaction(int amount);
    /**
     * Получает текущую транзакционную сумму
     * @return внесённая транзакционная сумма
     * @throws IllegalStateException если транзакция не начата
     */
    int transactionalAmount();

    /**
     * Получает текущую сумму в хранителе
     * @return текущая не транзакционная сумма в хранителе
     */
    int commonAmount();

    /**
     * Берёт сумму и добавляет её к текущей транзакционной сумме
     * @param amountOfMoney сумма, которую нужно добавить к транзакционной
     * @throws IllegalStateException если транзакция не начата
     * @throws IllegalArgumentException если amountOfMoney <= 0
     */
    void take(int amountOfMoney);

    /**
     * Данный метод добавляет текущую транзакционную сумму к общей и очищает транзакционную сумму
     * @return сдачу, если таковая имеется(0 если сдачи нет)
     * @throws IllegalStateException если транзакция не начата
     */
    int commit();

    /**
     * Данный метод очищает текущую транзакцию сумму и возвращает её
     * @return внесённую сумму в рамках транзакции
     * @throws IllegalStateException если транзакция не начата
     */
    int rollback();
}

package org.blbulyandavbulyan.vendingmachine.services;

import org.blbulyandavbulyan.vendingmachine.domen.Product;
import org.blbulyandavbulyan.vendingmachine.services.exceptions.ProductIsNotAvailableException;

import java.util.Collection;

public class VendingMachine {
    private Display display;
    private MoneyHolder moneyHolder;
    private ItemSelector itemSelector;
    private ItemHolder itemHolder;
    private PaymentTerminal paymentTerminal;
    public VendingMachine(Display display, MoneyHolder moneyHolder, ItemSelector itemSelector, PaymentTerminal paymentTerminal, Collection<Product> products) {
        this.display = display;
        this.moneyHolder = moneyHolder;
        this.itemSelector = itemSelector;
        this.paymentTerminal = paymentTerminal;
        itemHolder = new ItemHolder(products);
    }
    public VendingMachine(Display display, MoneyHolder moneyHolder, ItemSelector itemSelector, PaymentTerminal paymentTerminal) {
        this.display = display;
        this.moneyHolder = moneyHolder;
        this.itemSelector = itemSelector;
        this.paymentTerminal = paymentTerminal;
        itemHolder = new ItemHolder();
    }
    public Product buySomething(){
        //даём выбрать продукт, смотреть можно, трогать нельзя
        long productId = itemSelector.select(itemHolder.getProducts());
        if(productId != -1){//операция не отменена
            try{
                int price = itemHolder.getPrice(productId);
                moneyHolder.beginTransaction(price);//начинаем транзакцию по внесению суммы в наше хранилище
                while (moneyHolder.transactionalAmount() < price){
                    int givenAmountOfMoney = paymentTerminal.requestAmountOfMoney(price - moneyHolder.transactionalAmount());//запрос суммы у терминала
                    if(givenAmountOfMoney > 0){//проверка на всяких жуликов
                        moneyHolder.take(givenAmountOfMoney);//добавляем сумму к транзакции
                    }
                    else {
                        paymentTerminal.giveBack(moneyHolder.rollback());//возвращаем деньги назад и откатываем транзакцию
                        throw new RuntimeException("жулик не воруй");//падаем
                    }
                }
                int change = moneyHolder.commit();//добавляем сумму в хранилище и получаем сдачу
                if(change != 0)paymentTerminal.giveBack(change);//даём сдачу, если она есть
                //если мы сюда дошли, значит нам уже заплатили денег
                return itemHolder.release(productId);//возвращаем купленный товар
            }
            catch (ProductIsNotAvailableException e){
                display.displayError("Запрашиваемый вами продукт не доступен!");
                throw e;
            }
        }
        else throw new RuntimeException("Операция отменена!");
    }

    /**
     * @see ItemHolder#getProducts()
     * @return Возвращает неизменяемую коллекцию с доступными продуктами
     */
    public Collection<Product> getProducts(){
        return itemHolder.getProducts();
    }
    public void addProduct(Product product){
        itemHolder.add(product);
    }
}

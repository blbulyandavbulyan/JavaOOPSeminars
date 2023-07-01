package org.blbulyandavbulyan.seminar1.vendingmachine.services;

import org.blbulyandavbulyan.seminar1.vendingmachine.domen.Product;
import org.blbulyandavbulyan.seminar1.vendingmachine.services.interfaces.MoneyHolder;

import java.util.Collection;

/**
 * Данный класс предоставляет некое подобие торгового автомата со всякой всячиной
 */
public class VendingMachine {
    //вообще я делал делал всё по uml диаграмме, но я не понимаю зачем нужны все остальные классы, и я их просто повырезал :/
    /**
     * Поле с управляющим деньгами
     */
    private final MoneyHolder moneyHolder;
    /**
     * Поле с управляющим продуктами
     */
    private final ItemHolder itemHolder;

    /**
     * Создаёт автомат с заданным управляющим деньгами
     * @param moneyHolder управляющий деньгами
     */

    public VendingMachine(MoneyHolder moneyHolder) {
        //на самом деле, и MoneyHolder можно было бы создавать внутри
        //да и большого смысла в нём как-то нет
        this.moneyHolder = moneyHolder;
        itemHolder = new ItemHolder();
    }

    /**
     * Метод покупает продукт из хранилища
     * @param id ИД продукта
     * @param money сумма денег, которые нужно заплатить за продукт
     * @return возвращает сдачу
     */
    public int buy(long id, int money){
        int price = itemHolder.getPrice(id);
        if(money < price)throw new RuntimeException("not enough money for buy this product!");
        else {
            int change = money - price;
            moneyHolder.addAmount(money);
            if(change != 0)moneyHolder.drain(change);
            itemHolder.release(id);//освобождаем продукт из автомата
            return change;//возвращаем сдачу
        }
    }
    /**
     * @see ItemHolder#getProducts()
     * @return Возвращает неизменяемую коллекцию с доступными продуктами
     */
    public Collection<Product> getProducts(){
        return itemHolder.getProducts();
    }

    /**
     * Данный метод добавляет продукт в торговый аппарат
     * @param product продукт, который нужно добавить
     */
    public void addProduct(Product product){
        itemHolder.add(product);
    }
}

package org.blbulyandavbulyan.seminar1.vendingmachine.services;

import org.blbulyandavbulyan.seminar1.vendingmachine.domen.Product;
import org.blbulyandavbulyan.seminar1.vendingmachine.services.interfaces.MoneyHolder;

import java.util.Collection;

public class VendingMachine {
    private final MoneyHolder moneyHolder;
    private final ItemHolder itemHolder;

    public VendingMachine(MoneyHolder moneyHolder) {
        this.moneyHolder = moneyHolder;
        itemHolder = new ItemHolder();
    }
    public Product buy(long id, int money){
        int price = itemHolder.getPrice(id);
        if(money < price)throw new RuntimeException("not enough money for buy this product!");
        else {
            int change = money - price;
            if(change != 0)moneyHolder.drain(change);
            return itemHolder.release(id);
        }
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

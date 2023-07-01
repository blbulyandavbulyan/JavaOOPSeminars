package org.blbulyandavbulyan.seminar1.vendingmachine;

import org.blbulyandavbulyan.seminar1.vendingmachine.domen.Chocolate;
import org.blbulyandavbulyan.seminar1.vendingmachine.domen.HotDrink;
import org.blbulyandavbulyan.seminar1.vendingmachine.services.VendingMachine;

/**
 * Вспомогательный класс, заполняющий торговый автомат продуктами
 */
public class VendingMachineFiller {
    /**
     * Метод заполняет торговый автомат продуктами
     * @param vendingMachine автомат для заполнения
     */
    public static void fill(VendingMachine vendingMachine){
        vendingMachine.addProduct(new Chocolate(1L, "AlpenGold", 100, "black"));
        vendingMachine.addProduct(new HotDrink(2L, "Coffee capucino", 50, 90));
        vendingMachine.addProduct(new HotDrink(3L, "Tea", 25, 90));
    }
}

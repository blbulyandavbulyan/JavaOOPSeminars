package org.blbulyandavbulyan.vendingmachine;

import org.blbulyandavbulyan.vendingmachine.domen.Chocolate;
import org.blbulyandavbulyan.vendingmachine.domen.HotDrink;
import org.blbulyandavbulyan.vendingmachine.domen.Product;
import org.blbulyandavbulyan.vendingmachine.services.SimpleMoneyHolder;
import org.blbulyandavbulyan.vendingmachine.services.VendingMachine;
import org.blbulyandavbulyan.vendingmachine.services.interfaces.MoneyHolder;
import org.blbulyandavbulyan.vendingmachine.services.interfaces.ui.Display;
import org.blbulyandavbulyan.vendingmachine.services.interfaces.ui.ItemSelector;
import org.blbulyandavbulyan.vendingmachine.services.interfaces.ui.PaymentTerminal;
import org.blbulyandavbulyan.vendingmachine.ui.console.ConsoleDisplay;
import org.blbulyandavbulyan.vendingmachine.ui.console.ConsoleItemSelector;
import org.blbulyandavbulyan.vendingmachine.ui.console.ConsolePaymentTerminal;

import java.util.Scanner;

/**
 * Данный класс является точкой входа в программу
 */
public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = createVendingMachine();
        Product product = vendingMachine.buySomething();
        System.out.println(product);
    }
    private static VendingMachine createVendingMachine(){
        Display display = new ConsoleDisplay(System.out);
        Scanner scanner = new Scanner(System.in);
        MoneyHolder moneyHolder = new SimpleMoneyHolder();
        PaymentTerminal paymentTerminal = new ConsolePaymentTerminal(scanner, display);
        ItemSelector itemSelector = new ConsoleItemSelector(scanner, System.out);
        VendingMachine vendingMachine = new VendingMachine(display, moneyHolder, itemSelector, paymentTerminal);
        vendingMachine.addProduct(new Chocolate(1L, "AlpenGold", 100, "black"));
        vendingMachine.addProduct(new HotDrink(2L, "Coffee capucino", 50, 90));
        vendingMachine.addProduct(new HotDrink(3L, "Tea", 25, 90));
        return vendingMachine;
    }
}

import domen.Chocolate;
import domen.HotDrink;
import domen.Product;
import services.*;
import ui.console.ConsoleDisplay;
import ui.console.ConsoleItemSelector;
import ui.console.ConsolePaymentTerminal;

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

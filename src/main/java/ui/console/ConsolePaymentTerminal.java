package ui.console;

import services.Display;
import services.PaymentTerminal;

import java.util.Scanner;

public class ConsolePaymentTerminal implements PaymentTerminal{
    private final Scanner scanner;
    private final Display display;

    public ConsolePaymentTerminal(Scanner scanner, Display display){
        if(scanner == null)throw new IllegalArgumentException("scanner is null!");
        if(display == null)throw new IllegalArgumentException("display is null!");
        this.display = display;
        this.scanner = scanner;
    }
    @Override
    public int requestAmountOfMoney(int amount) {
        display.displayMessage("Запрашивается сумма " + amount);
        display.displayMessage("Введите сумму >0: ");
        return scanner.nextInt();
    }

    @Override
    public void giveBack(int change) {
        display.displayMessage("Вам возвращено " + change);
    }
}

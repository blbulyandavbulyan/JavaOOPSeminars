package org.blbulyandavbulyan.seminar1.vendingmachine;

import org.blbulyandavbulyan.seminar1.vendingmachine.services.SimpleMoneyHolder;
import org.blbulyandavbulyan.seminar1.vendingmachine.services.VendingMachine;
import org.blbulyandavbulyan.seminar1.vendingmachine.ui.gui.VendingMachineWindow;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GuiMain {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(new SimpleMoneyHolder());
        VendingMachineFiller.fill(vendingMachine);
        VendingMachineWindow vendingMachineWindow = new VendingMachineWindow(vendingMachine);
        vendingMachineWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
        vendingMachineWindow.setVisible(true);
    }
}

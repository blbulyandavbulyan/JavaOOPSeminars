package org.blbulyandavbulyan.vendingmachine.ui.console;

import org.blbulyandavbulyan.vendingmachine.services.interfaces.ui.Display;

import java.io.PrintStream;

public class ConsoleDisplay implements Display {
    private final PrintStream ps;
    public ConsoleDisplay(PrintStream ps){
        if(ps == null)throw new IllegalArgumentException("print stream is null!");
        this.ps = ps;
    }

    @Override
    public void displayMessage(String msg) {
        ps.println(msg);
    }
}

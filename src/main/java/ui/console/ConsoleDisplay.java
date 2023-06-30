package ui.console;

import services.Display;

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

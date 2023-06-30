package ui.console;

public interface ConsoleTerminal {
    void printError(String errorMsg);
    void printMessage(String msg);
    int readInt(String tipMsg);
}

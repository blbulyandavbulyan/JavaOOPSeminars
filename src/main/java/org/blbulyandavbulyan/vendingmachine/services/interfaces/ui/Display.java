package org.blbulyandavbulyan.vendingmachine.services.interfaces.ui;

public interface Display {
    void displayMessage(String msg);
    default void displayError(String errorMsg){
        displayMessage(errorMsg);
    }
}

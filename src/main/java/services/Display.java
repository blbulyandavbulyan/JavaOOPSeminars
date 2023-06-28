package services;

import domen.Product;

import java.util.Collection;

public interface Display {
    void displayMessage(String msg);
    default void displayError(String errorMsg){
        displayMessage(errorMsg);
    }
}

package services;

import domen.Product;

import java.util.Collection;

public interface Display {
    void displayMessage(String msg);
    void showAvailableProductTypes(Collection<Class<? extends Product>> productTypes);
    default void displayError(String errorMsg){
        displayMessage(errorMsg);
    }
}

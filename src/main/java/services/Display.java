package services;

public interface Display {
    void displayMessage(String msg);
    default void displayError(String errorMsg){
        displayMessage(errorMsg);
    }
}

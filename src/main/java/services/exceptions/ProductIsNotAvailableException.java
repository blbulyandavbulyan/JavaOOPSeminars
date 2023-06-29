package services.exceptions;

public class ProductIsNotAvailableException extends RuntimeException{
    public ProductIsNotAvailableException(long productNumber){
        super("proudct " + productNumber + " is not available!");
    }
}

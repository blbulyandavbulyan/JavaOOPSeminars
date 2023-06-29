package services;
import domen.Product;

import java.util.Collection;
import java.util.Map;

public interface ItemSelector {

     long select(Collection<Product> availableNumbers);

}

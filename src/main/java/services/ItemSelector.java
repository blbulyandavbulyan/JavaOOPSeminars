package services;

import domen.Product;

import java.util.Collection;

public interface ItemSelector {

     long select(Collection<Product> availableNumbers);

}

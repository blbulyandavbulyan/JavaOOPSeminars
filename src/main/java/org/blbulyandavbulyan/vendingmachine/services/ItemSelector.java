package org.blbulyandavbulyan.vendingmachine.services;

import org.blbulyandavbulyan.vendingmachine.domen.Product;

import java.util.Collection;

public interface ItemSelector {

     long select(Collection<Product> products);

}

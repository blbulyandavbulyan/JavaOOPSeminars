package org.blbulyandavbulyan.vendingmachine.services.interfaces.ui;

import org.blbulyandavbulyan.vendingmachine.domen.Product;

import java.util.Collection;

public interface ItemSelector {

     long select(Collection<Product> products);

}

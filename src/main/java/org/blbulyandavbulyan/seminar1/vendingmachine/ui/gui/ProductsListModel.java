package org.blbulyandavbulyan.seminar1.vendingmachine.ui.gui;

import org.blbulyandavbulyan.seminar1.vendingmachine.domen.Product;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.Collection;

public class ProductsListModel implements ListModel<Product> {
    private final Collection<Product> products;
    public ProductsListModel(Collection<Product> products){
        this.products = products;
    }
    @Override
    public int getSize() {
        return products.size();
    }

    @Override
    public Product getElementAt(int index) {
        return null;
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}

package services;

import domen.Product;

import java.util.Collection;

public interface ItemSelector {
     Class<? extends Product> select(Collection<Class<? extends Product>> productTypes);

}

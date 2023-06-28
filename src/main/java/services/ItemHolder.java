package services;

import domen.Product;

import java.util.*;

/**
 * Данный класс должен описывать ту штуку со спиральками в торговой машине
 * Она хранит товары по типам
 */
public class ItemHolder {
    /**
     * список с очередями продуктов, индекс в списке сопоставлен с номером продукта для выбора
     */
    private final List<Queue<Product>> productQueues;
    private final int maxDepth;
    private final int rows;
    private final int columns;
    public ItemHolder(int rows, int columns, int maxDepth){
        if(rows <= 0 || columns <= 0)throw new IllegalArgumentException("rows and columns must be greater than 0");
        if(maxDepth <= 0)throw new IllegalArgumentException("max depth must be greater than zero");
        this.rows = rows;
        this.columns = columns;
        this.maxDepth = maxDepth;
        productQueues = new ArrayList<>(rows*columns);
        //начальная инициализация пустыми очередями
        for(int i = 0; i < rows*columns; i++){
            productQueues.add(new ArrayDeque<>());
        }
    }
    public void add(Product product){
        //чтобы автомат заполнялся равномерно, нам нужно найти ячейку с минимальным количеством элементов, которые меньше чем max depth
        var products = productQueues.stream()
                .filter(q->q.size() < maxDepth)
                .min(Comparator.comparingInt(Collection::size))
                .orElseThrow(()-> new RuntimeException("Машина уже полная!"));
        products.add(product);
    }
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}

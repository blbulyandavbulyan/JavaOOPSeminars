package org.blbulyandavbulyan.vendingmachine.domen;

public abstract class Product{
    protected long id;
    protected String name;
    protected int price;

    public Product(long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

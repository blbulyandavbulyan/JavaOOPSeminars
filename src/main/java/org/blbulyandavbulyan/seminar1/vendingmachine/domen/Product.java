package org.blbulyandavbulyan.seminar1.vendingmachine.domen;

/**
 * Данный класс предоставляет некий абстрактный продукт, с именем id и ценой
 */
public abstract class Product{
    /**
     * ID продукта
     */
    protected long id;
    /**
     * Наименование продукта
     */
    protected String name;
    /**
     * Цена продукта
     */
    protected int price;

    /**
     *
     * @param id ИД
     * @param name наименование
     * @param price цена
     */
    protected Product(long id, String name, int price) {
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

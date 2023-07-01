package org.blbulyandavbulyan.seminar1.vendingmachine.domen;

/**
 * Данный класс предоставляет продукт "Шоколад" у которого есть цвет
 */
public class Chocolate extends Product{
    /**
     * Цвет шоколада
     */
    private final String color;

    /**
     * Создаёт экземпляр шоколада
     * @param id ИД
     * @param name наименование
     * @param price цена
     * @param color цвет шоколада
     */
    public Chocolate(long id, String name, int price, String color) {
        super(id, name, price);
        this.color = color;
    }
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Chocolate{" +
                "color='" + color + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

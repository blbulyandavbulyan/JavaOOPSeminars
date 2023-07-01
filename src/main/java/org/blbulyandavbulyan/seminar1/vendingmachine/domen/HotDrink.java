package org.blbulyandavbulyan.seminar1.vendingmachine.domen;

/**
 * Данный класс предоставляет продукт "Горячий напиток", у которого есть температура
 */
public class HotDrink extends Product{
    /**
     * Температура данного напитка
     */
    private int temperature;

    /**
     * Создаёт экземпляр горячего напитка
     * @param id ИД
     * @param name наименование
     * @param price цена
     * @param temperature температура
     */
    public HotDrink(long id, String name, int price, int temperature) {
        super(id, name, price);
        setTemperature(temperature);
    }

    /**
     * Устанавливает температуру для данного горячего напитка
     * @param temperature новая температура
     * @throws IllegalArgumentException если temperature <= 0
     */
    private void setTemperature(int temperature) {
        if(temperature <= 0)throw new IllegalArgumentException("temperature must be greater than 0");
        this.temperature = temperature;
    }
    public int getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "HotDrink{" +
                "temperature=" + temperature +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

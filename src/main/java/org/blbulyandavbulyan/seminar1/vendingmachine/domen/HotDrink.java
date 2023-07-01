package org.blbulyandavbulyan.seminar1.vendingmachine.domen;

public class HotDrink extends Product{
    private int temperature;
    public HotDrink(long id, String name, int price, int temperature) {
        super(id, name, price);
        setTemperature(temperature);
    }
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

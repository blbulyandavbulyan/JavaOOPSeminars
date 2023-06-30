package domen;

public class Chocolate extends Product{
    private final String color;
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

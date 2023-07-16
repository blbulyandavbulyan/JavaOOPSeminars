package org.blbulyandavbulyan.seminar6.solid.shapes;

public class Circle implements Areal {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return 2 * 3.14 * radius;
    }
}

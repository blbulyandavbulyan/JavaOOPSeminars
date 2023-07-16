package org.blbulyandavbulyan.seminar6.solid.vehicles;

public class Car extends Vehicle{
    public Car(int maxSpeed) {
        super(maxSpeed, "Car");
    }
    @Override
    double calculateAllowedSpeed() {
        return getMaxSpeed() * 0.8;
    }
}

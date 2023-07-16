package org.blbulyandavbulyan.seminar6.solid.vehicles;

public class Car extends Vehicle{
    public Car(int maxSpeed, String type) {
        super(maxSpeed, type);
    }
    @Override
    double calculateAllowedSpeed() {
        return getMaxSpeed() * 0.8;
    }
}

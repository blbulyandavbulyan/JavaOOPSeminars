package org.blbulyandavbulyan.seminar6.solid.vehicles;

public class Bus extends Vehicle{
    public Bus(int maxSpeed, String type) {
        super(maxSpeed, type);
    }

    @Override
    double calculateAllowedSpeed() {
        return getMaxSpeed() * 0.6;
    }
}

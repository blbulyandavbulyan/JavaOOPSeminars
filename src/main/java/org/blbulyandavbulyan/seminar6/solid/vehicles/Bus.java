package org.blbulyandavbulyan.seminar6.solid.vehicles;

public class Bus extends Vehicle{
    public Bus(int maxSpeed) {
        super(maxSpeed, "Bus");
    }

    @Override
    double calculateAllowedSpeed() {
        return getMaxSpeed() * 0.6;
    }
}

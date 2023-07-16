package org.blbulyandavbulyan.seminar6.solid.vehicles;

public abstract class Vehicle {
    private final int maxSpeed;
    private final String type;

    public Vehicle(int maxSpeed, String type) {
        this.maxSpeed = maxSpeed;
        this.type = type;
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public String getType() {
        return this.type;
    }
    abstract double calculateAllowedSpeed();
}
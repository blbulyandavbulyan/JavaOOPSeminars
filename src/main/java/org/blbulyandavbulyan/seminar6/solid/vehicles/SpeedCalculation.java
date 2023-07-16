package org.blbulyandavbulyan.seminar6.solid.vehicles;

public class SpeedCalculation {
    public double calculateAllowedSpeed(Vehicle vehicle) {
        // FIXME: 16.07.2023 Переписать этот код, используя наследование
        if (vehicle.getType().equalsIgnoreCase("Car")) {
            return vehicle.getMaxSpeed() * 0.8;
        } else if (vehicle.getType().equalsIgnoreCase("Bus")) {
            return vehicle.getMaxSpeed() * 0.6;
        }
        return 0.0;
    }
}
package org.blbulyandavbulyan.seminar6.solid.car;

public class Car {
    private PetrolEngine engine;

    public Car(PetrolEngine engine) {
        this.engine = engine;
    }

    public void start() {
        this.engine.start();
    }
}


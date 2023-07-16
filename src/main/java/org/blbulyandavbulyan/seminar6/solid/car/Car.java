package org.blbulyandavbulyan.seminar6.solid.car;

public class Car {
    private AbstractEngine engine;

    public Car(AbstractEngine engine) {
        this.engine = engine;
    }

    public void start() {
        this.engine.start();
    }
}


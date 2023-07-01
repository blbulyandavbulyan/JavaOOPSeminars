package org.blbulyandavbulyan.seminar2.supermarket.domen;

abstract public class Actor {
    protected String name;
    protected boolean isTakeOrder;
    protected boolean isMakeOrder;

    public Actor(String name) {
        this.name = name;
    }

    abstract public String getName();
}

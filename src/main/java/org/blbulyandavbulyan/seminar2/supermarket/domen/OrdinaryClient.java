package org.blbulyandavbulyan.seminar2.supermarket.domen;

public class OrdinaryClient extends Actor{
    public OrdinaryClient(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return name;
    }
    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    public void setTakeOrder(boolean takeOrder) {
        isTakeOrder = takeOrder;
    }

    public void setMakeOrder(boolean makeOrder) {
        isMakeOrder = makeOrder;
    }
    public Actor getActor(){
        return this;
    }
}

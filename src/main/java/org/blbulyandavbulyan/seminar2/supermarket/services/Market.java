package org.blbulyandavbulyan.seminar2.supermarket.services;

import org.blbulyandavbulyan.seminar2.supermarket.domen.Actor;
import org.blbulyandavbulyan.seminar2.supermarket.services.interfaces.IMarketBehavior;
import org.blbulyandavbulyan.seminar2.supermarket.services.interfaces.IQueueBehavior;

import java.util.ArrayList;
import java.util.List;

public class Market implements IQueueBehavior, IMarketBehavior {
    private final List<Actor> queue;
    public Market(){
        queue = new ArrayList<>();
    }
    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + " пришёл в магазин");
        takeInQueue(actor);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for(var actor : actors){
            System.out.println(actor.getName() + " вышел из магазина");
            queue.remove(actor);
        }
    }

    @Override
    public void update() {
        takeOrder();
        giveOrder();
        releaseFromQueue();
    }

    @Override
    public void takeInQueue(Actor actor) {
        this.queue.add(actor);
        System.out.println(actor.getName() + " встал в очередь");
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> actorsForRelease = new ArrayList<>();
        queue.stream().filter(Actor::isTakeOrder).forEach(actor -> {
            actorsForRelease.add(actor);
            System.out.println(actor.getName() + " ушёл из очереди");
        });
        releaseFromMarket(actorsForRelease);
    }

    @Override
    public void takeOrder() {
        queue.stream().filter(actor -> !actor.isMakeOrder()).forEach(actor -> {
            actor.setMakeOrder(true);
            System.out.println(actor.getName() + " сделал свой заказ");
        });
    }

    @Override
    public void giveOrder() {
        queue.stream().filter(Actor::isMakeOrder).forEach(actor -> {
            actor.setTakeOrder(true);
            System.out.println(actor.getName() + " получил свой заказ");
        });
    }
}

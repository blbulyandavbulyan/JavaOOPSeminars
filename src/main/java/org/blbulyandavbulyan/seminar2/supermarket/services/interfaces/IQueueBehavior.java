package org.blbulyandavbulyan.seminar2.supermarket.services.interfaces;

import org.blbulyandavbulyan.seminar2.supermarket.domen.Actor;

public interface IQueueBehavior {
    void takeInQueue(Actor actor);
    void releaseFromQueue();
    void takeOrder();
    void giveOrder();
}

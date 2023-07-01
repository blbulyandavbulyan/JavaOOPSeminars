package org.blbulyandavbulyan.seminar2.supermarket.services.interfaces;

import org.blbulyandavbulyan.seminar2.supermarket.domen.Actor;

import java.util.List;

public interface IMarketBehavior {
    void acceptToMarket(Actor actor);
    void releaseFromMarket(List<Actor> actors);
    void update();
}

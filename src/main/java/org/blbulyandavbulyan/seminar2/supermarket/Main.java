package org.blbulyandavbulyan.seminar2.supermarket;

import org.blbulyandavbulyan.seminar2.supermarket.domen.OrdinaryClient;
import org.blbulyandavbulyan.seminar2.supermarket.domen.SpecialClient;
import org.blbulyandavbulyan.seminar2.supermarket.services.Market;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        market.acceptToMarket(new OrdinaryClient("Вася"));
        market.acceptToMarket(new SpecialClient("Петя", 1));
        market.acceptToMarket(new OrdinaryClient("Женя"));
        market.update();
    }
}

package org.blbulyandavbulyan.seminar2.supermarket;

import org.blbulyandavbulyan.seminar2.supermarket.domen.OrdinaryClient;
import org.blbulyandavbulyan.seminar2.supermarket.domen.PromotionClient;
import org.blbulyandavbulyan.seminar2.supermarket.domen.SpecialClient;
import org.blbulyandavbulyan.seminar2.supermarket.services.Market;

import java.io.IOException;
import java.util.logging.FileHandler;

/**
 * Данный класс предоставляет точку входа в магазин
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Market market = new Market();
        //создаём fileHandler и добавляем его к логгеру магазина
        FileHandler fileHandler = new FileHandler("log.txt");
        market.getLogger().addHandler(fileHandler);
        market.acceptToMarket(new OrdinaryClient("Вася"));
        market.acceptToMarket(new SpecialClient("Петя", 1));
        market.acceptToMarket(new OrdinaryClient("Женя"));
        market.acceptToMarket(new PromotionClient("Анатолий", "какая-то акция", 1));
        market.update();
    }
}

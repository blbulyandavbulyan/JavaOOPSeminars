package org.blbulyandavbulyan.seminar2.supermarket.domen.exceptions;

public class PromotionIsOver extends RuntimeException{
    public PromotionIsOver(String promotionName, int maxCountOfClients){
        super("maximum count " + maxCountOfClients + " in promotion " + promotionName + " has been reached!");
    }
}

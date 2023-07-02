package org.blbulyandavbulyan.seminar2.supermarket.domen.exceptions;

public class PromotionIsOverException extends RuntimeException{
    public PromotionIsOverException(String promotionName, int maxCountOfClients){
        super("maximum count " + maxCountOfClients + " in promotion " + promotionName + " has been reached!");
    }
}

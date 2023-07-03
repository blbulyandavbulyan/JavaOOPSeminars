package org.blbulyandavbulyan.seminar2.supermarket.domen;

import org.blbulyandavbulyan.seminar2.supermarket.domen.exceptions.PromotionIsOverException;

import java.util.HashMap;
import java.util.Map;

/**
 * Данный класс предоставляет клиента, который пришёл по акции
 */
public class PromotionClient extends Actor{
    /**
     * Имя акции в количество клиентов для этой акции
     */
    private static Map<String, Integer> countOfClientInAction = new HashMap<>();
    /**
     * Максимальное количество клиентов для любой акции
     */
    private static int maxActionClients = 5;
    /**
     * ИД клиента по акции
     */
    private int clientID;
    /**
     * Имя акции для текущего клиента
     */
    private final String actionName;

    /**
     * Создаёт экземпляр акционного клиента
     * @param clientName имя клиента
     * @param actionName имя акции
     * @param clientID ИД клиента
     * @throws PromotionIsOverException если превышено максимальное количество клиентов для акции с именем actionName
     */
    public PromotionClient(String clientName, String actionName, int clientID) {
        super(clientName);
        this.clientID = clientID;
        this.actionName = actionName;
        //проверяем на то, превышено ли максимальное количество клиентов для текущей акции
        if(countOfClientInAction.getOrDefault(actionName, 0) < maxActionClients){
            //если нет, то высчитываем новое количество клиентов для текущей акции
            //попутно проверяя, а была ли у нас такая акция добавлена
            //если акции не было добавлено, то она будет добавлена с количеством 1
            //иначе просто увеличится количество клиентов у акции на 1
            countOfClientInAction.compute(actionName, (k, v)-> v == null ? 1 : v + 1);
        }
        //логика такая, если превышено допустимое количество клиентов по акции, то мы бросим исключение
        else throw new PromotionIsOverException(actionName, countOfClientInAction.get(actionName));
    }

    /**
     * @return ID клиента
     */
    public int getClientID() {
        return clientID;
    }

    /**
     * @return имя акции
     */
    public String getActionName() {
        return actionName;
    }

    @Override
    public String toString() {
        return "PromotionClient{" +
                "clientID=" + clientID +
                ", actionName='" + actionName + '\'' +
                ", name='" + name + '\'' +
                ", isTakeOrder=" + isTakeOrder +
                ", isMakeOrder=" + isMakeOrder +
                '}';
    }
}

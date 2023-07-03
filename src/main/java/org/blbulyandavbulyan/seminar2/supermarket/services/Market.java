package org.blbulyandavbulyan.seminar2.supermarket.services;

import org.blbulyandavbulyan.seminar2.supermarket.domen.Actor;
import org.blbulyandavbulyan.seminar2.supermarket.services.interfaces.IMarketBehavior;
import org.blbulyandavbulyan.seminar2.supermarket.services.interfaces.IQueueBehavior;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class Market implements IQueueBehavior, IMarketBehavior {
    private final List<Actor> queue;
    private final List<Actor> returnQueue;
    private final Logger logger;

    /**
     * Создаёт экземпляр магазина с заданным логгером
     * @param logger логгер, к которому данный магазин будет привязан
     */
    private Market(Logger logger){
        this.logger = logger;
        this.returnQueue = new ArrayList<>();
        queue = new ArrayList<>();
    }
    public Market(){
        this(Logger.getLogger(Market.class.getName()));
    }

    /**
     * Данный метод принимает клиента в магазин
     * @param actor клиент, которого нужно принять
     */
    @Override
    public void acceptToMarket(Actor actor) {
        logger.info(()->actor.getName() + " пришёл в магазин");
        takeInQueue(actor);
    }

    /**
     * Данный метод удаляет список клиентов из очереди для заказов
     * @param actors клиенты, которых нужно удалить
     */
    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for(var actor : actors){
            logger.info(()->actor.getName() + " вышел из магазина");
            queue.remove(actor);
        }
    }

    /**
     * Метод, управляющий всей логикой магазина
     */
    @Override
    public void update() {
        makeOrder();
        giveOrder();
        buildQueueForReturnFromBuyingQueue();
        releaseFromQueue();
        returnOrders();
        releaseFromReturnQueue();
    }

    /**
     * Данный метод освобождает очередь для возврата товаров
     */
    private void releaseFromReturnQueue() {
        Iterator<Actor> iterator = returnQueue.iterator();
        while (iterator.hasNext()){
            Actor actor = iterator.next();
            logger.info(()->actor.getName() + " покинул очередь возврата");
            iterator.remove();
        }
    }

    /**
     * Данный метод очередь для возврата товаров
     */
    private void buildQueueForReturnFromBuyingQueue() {
        for(Actor actor : queue){
            if(actor.isItNeededToReturnOrder()){
                logger.info(()->actor.getName() + " встал в очередь на возврат");
                returnQueue.add(actor);
            }
        }
    }

    /**
     * Данный метод отвечает за запрос возврата товара у пользователей, которые стоят в очереди на возврат
     */
    private void returnOrders(){
        for(var actor : returnQueue){
            logger.info(()->actor.getName() + " начал процедуру возврата заказа");
            //идея в чём, пока данный метод не вернёт false, мы будем считать что данный клиент нуждается в том чтобы вернуть заказ
            //этим и поддерживается возврат нескольких заказов
            while (actor.isItNeededToReturnOrder()){
                actor.returnOrder();
                logger.info(()->actor.getName() + " вернул заказ");
            }
        }
    }

    /**
     * Данный метод принимает клиента в очередь на заказ
     * @param actor клиент, которого нужно принять
     */
    @Override
    public void takeInQueue(Actor actor) {
        this.queue.add(actor);
        logger.info(()->actor.getName() + " встал в очередь");
    }

    /**
     * Данный метод освобождает очередь на заказ от клиентов
     */
    @Override
    public void releaseFromQueue() {
        List<Actor> actorsForRelease = new ArrayList<>();
        queue.stream().filter(Actor::isTakeOrder).forEach(actor -> {
            actorsForRelease.add(actor);
            logger.info(()->actor.getName() + " ушёл из очереди");
        });
        releaseFromMarket(actorsForRelease);
    }

    /**
     * Данный метод просит людей в очереди сделать заказ
     */
    @Override
    public void makeOrder() {
        queue.stream().filter(actor -> !actor.isMakeOrder()).forEach(actor -> {
            actor.setMakeOrder(true);
            logger.info(()->actor.getName() + " сделал свой заказ");
        });
    }

    /**
     * Данный метод выдаёт заказ клиентам
     */
    @Override
    public void giveOrder() {
        queue.stream().filter(Actor::isMakeOrder).forEach(actor -> {
            actor.setTakeOrder(true);
            logger.info(()->actor.getName() + " получил свой заказ");
        });
    }

    /**
     * @return логгер, привязанный к данному магазину
     */
    public Logger getLogger() {
        return logger;
    }
}

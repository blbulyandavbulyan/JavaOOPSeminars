package org.blbulyandavbulyan.seminar2.supermarket.domen;

/**
 * Предоставляет самого обычного клиента с именем
 */
public class OrdinaryClient extends Actor{
    /**
     * Создаёт клиента с заданным именем
     * @param name имя, с которым нужно создать клиента
     */
    public OrdinaryClient(String name) {
        super(name);
    }
}

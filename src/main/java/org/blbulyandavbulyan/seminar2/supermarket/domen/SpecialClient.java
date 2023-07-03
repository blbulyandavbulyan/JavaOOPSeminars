package org.blbulyandavbulyan.seminar2.supermarket.domen;

/**
 * Предоставляет VIP клиента
 */
public class SpecialClient extends Actor{
    /**
     * VIP ID клиента
     */
    private int idVip;

    /**
     * Создаёт экземпляр VIP клиента
     * @param name имя
     * @param idVip VIP ID
     */
    public SpecialClient(String name, int idVip) {
        super(name);
        this.idVip = idVip;
    }

    /**
     * Получает VIP ID клиента
     * @return VIP ID
     */
    public int getIdVip() {
        return idVip;
    }
}

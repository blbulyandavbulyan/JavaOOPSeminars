package org.blbulyandavbulyan.seminar2.supermarket.domen;

public class SpecialClient extends Actor{
    private int idVip;
    public SpecialClient(String name, int idVip) {
        super(name);
        this.idVip = idVip;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getIdVip() {
        return idVip;
    }
}

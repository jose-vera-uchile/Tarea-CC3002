package cl.uchile.dcc.citricliquid.model.unidades;

public interface InterfaceUnit {

    String getName();

    int getMaxHp();

    int getCurrentHp();

    int getAtk();

    int getDef();

    int getEvd();

    int getStars();

    void increaseStarsBy(final int amount);

    void reduceStarsBy(final int amount);

    InterfaceUnit copy();

}

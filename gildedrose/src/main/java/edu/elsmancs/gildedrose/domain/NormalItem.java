package edu.elsmancs.gildedrose.domain;

public class NormalItem {

    /**
     * Item 18: Favorece la composición sobre la herencia.
     * Cada método de instancia en la nueva clase invoca
     * el método correspondiente en la instancia contenida
     * de la clase existente y devuelve los resultados.
     * Esto se conoce como reenvío y los métodos en
     * La nueva clase se conoce como métodos de reenvío.
     * Bloch, Joshua; Efectivo Java, Tercera Edición.
     */

    /** 
     * Item 17: Minimiza la mutabilidad.
     * Bloch, Joshua; Effective Java, Third Edition.
     */
    private final Item item;
    
    public NormalItem(String name, int sell_in, int quality) {
        this.item = new Item(name, sell_in, quality);
    }
    
    @Override
    public String toString() {
        return item.toString();
    }

    public String getName() {
        return item.getName();
    }

    public int getSell_in() {
        return item.getSell_in();
    }

    public void setSell_in() {
        item.setSell_in();
    }

    public int getQuality() {
        return item.getQuality();
    }

    void computeQuality(int value) {

        /**
         * Backstage pierde toda la quality
         * cuando caduca el pase
         */
        if (value == 0) {
            item.setQuality(0);
            return;
        }

        if (getQuality() + value > 50) {
            item.setQuality(50);
        }
        else if (getQuality() + value >= 0) {
            item.setQuality(getQuality() + value);
        }
        else {
            item.setQuality(0);
        }
    }
    public void updateQuality() {

        if (getSell_in() > 0) {
            computeQuality(-1);
        } else {
            computeQuality(-2);
        }
        item.setSell_in();
    }
}
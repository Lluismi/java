package edu.elsmancs.gildedrose.domain;

/**
 * Item 17: Minimiza la mutabilidad
 * Asegúrese de que la clase no se puede extender.
 * Bloch, Joshua; Effective Java, Third Edition.
 */
final class Item {

    /** 
     * Item 17: Minimiza la mutabilidad
     * Bloch, Joshua; Effective Java, Third Edition.
     */
    private final String name;
    /** 
     * Item 61: Prefiere los tipos primitivos a los primitivos en caja.
     * Bloch, Joshua; Effective Java, Third Edition.
    */
    private int sell_in = 0;
    private int quality = 0;

    Item(String name, int sell_in, int quality) {
        this.name = name;
        this.sell_in = sell_in;
        this.quality = quality;
    }

    /**
     * Devuelve una breve descripción del artículo.
     * Los detalles exactos de la representación no están especificados
     * y sujeto a cambios, pero se puede considerar lo siguiente
     * como típico.
     * [name=Sulfuras, sell_in=10, quality=20]
     * 
     * Item 12: anular siempre toString
     * Item 63: Cuidado con el rendimiento de la concatenación de cadenas

     * Bloch, Joshua; Effective Java, Third Edition.
     */
    @Override
    public String toString() {
        StringBuilder itemDescription = new StringBuilder();
        itemDescription.append("name=" + getName());
        itemDescription.append(", sell_in=" + getSell_in());
        itemDescription.append(", quality=" + getQuality());
        return itemDescription.toString();
    }

    String getName() {
        return this.name;
    }

    int getSell_in() {
        return this.sell_in;
    }

    void setSell_in() {
        this.sell_in = this.getSell_in() - 1;
    }

    int getQuality() {
        return this.quality;
    }

    void setQuality(int value) {
        this.quality = value;
    }
}
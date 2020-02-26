package edu.elsmancs.gildedrose.domain;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {
	/* Creamos una Lista de NormalItem con el nombre inventory de una lista nueva de NormalItem*/
	List<NormalItem> inventory = new ArrayList<NormalItem>();
	
	/* Devuelve la lista inventory */
	public List<NormalItem> inventory() {
		return this.inventory;
	}
	
	/* Añade los item la lista inventory */
	public void addItem(NormalItem Item) {
		inventory().add(Item);
	}
	
	/* Le hace un updateQuality a los items de la lista inventory */
	public void updateQuality() {
        for (NormalItem item : inventory()) {
            item.updateQuality();
        }
    }
	
	/* Se sobreescribe siempre con el Override,
	 * lo que hace es que crea un string con los nombres 
	 * de los items y sus valores en pantalla */
	 @Override
	 public String toString() {
	     StringBuilder representation = new StringBuilder();
	        for (NormalItem item : inventory()) {
	            representation.append(item.toString());
	            representation.append('\n');
	        }
	        return representation.toString();
	    }
}
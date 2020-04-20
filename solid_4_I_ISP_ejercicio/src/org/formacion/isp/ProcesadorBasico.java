package org.formacion.isp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProcesadorBasico implements Basica {

    List<String> texto = new ArrayList<String>();
	
	@Override
	public void nueva (String palabra) {
		texto.add(palabra);
	}

	@Override
	public String texto () {
		return texto.stream().collect(Collectors.joining(" "));
    }
    
}
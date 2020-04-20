package org.formacion.isp;


public class ProcesadorComplejo extends ProcesadorBasico implements Compleja {

    // Puede implementarse la interfaz Basica
    // e implementar de nuevo sus metodos
	@Override
	public boolean correcto (Idioma idioma) {
		for (String palabra: texto) {
			if (! idioma.diccionario.contains(palabra.toLowerCase())) {
				return false;
			}
		}
		return true;
	}

}
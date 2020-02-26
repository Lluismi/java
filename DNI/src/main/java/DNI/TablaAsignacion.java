package DNI;

public class TablaAsignacion {
	
	private char[] Letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 
			'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T',
			'V', 'W', 'X', 'Y', 'Z'};
	
	char calcularLetra(String DNI){
		
		int dni = Integer.parseInt(DNI);
		int posicion = dni % getModulo();
		return getLetra(posicion);
	}

	char getLetra(int posicion) { 
			return this.Letras[posicion];
	}
	
	private int getModulo() {
		return this.Letras.length;
	}
	
	Boolean letraPermitida(char letra) {
		String tablaString = String.valueOf(Letras);
		return tablaString.contains(Character.toString(letra));
	}
}

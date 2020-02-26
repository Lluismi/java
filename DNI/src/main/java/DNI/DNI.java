package DNI;
	
public class DNI {
	
	private final String DNI;
	private Boolean NumeroDNI = false;
	private Boolean LetraDNI = false;
	private Boolean DNIBueno = false;
	private final byte LONGITUDNI = 9;
	private TablaAsignacion tabla = new TablaAsignacion();

	public DNI(String DNI) {
		this.DNI = DNI;
	}
	
	private String getDNI() {
		return this.DNI;
	}
	
	@Override
	public String toString() {
		return getDNI();
	}
		
	public Boolean getNumeroDNI() {
		return NumeroDNI;
	}

	public void setNumeroDNI(Boolean numeroDNI) {
		NumeroDNI = numeroDNI;
	}
	
	/* Comprobamos si el numero del DNI es bueno **/
	public Boolean checkNumeroDni() {
		setNumeroDNI(checkLongitudDni() 
						&& isDniNumero(extraerParteNumericaDni()));
		return getNumeroDNI();
	}
	
	public Boolean getLetraDNI() {
		return LetraDNI;
	}

	public void setLetraDNI(Boolean letraDNI) {
		LetraDNI = letraDNI;
	}
	
	/* Comprobamos si la letra del DNI es buena **/
	public Boolean checkLetra() {
		checkNumeroDni();
		if (getLetraDNI()) {
			setLetraDNI(Character.isUpperCase(extraerParteAlfabeticaDni()) 
							&& checkLetraValida());
			return getLetraDNI();
		} else {
			return false;
		}
	}
	
	public Boolean getDNIBueno() {
		return DNIBueno;
	}

	public void setDNIBueno(Boolean dNIBueno) {
		DNIBueno = dNIBueno;
	}
	
	/* Comprobamos si el DNI es bueno **/
	public Boolean checkDni() {
		setDNIBueno(checkNumeroDni() && checkLetra());
		return getDNIBueno();
	}
	
	private TablaAsignacion getTablaAsignacion(){
		return this.tabla;
	}
	
	public Character obtenerLetra() {
		checkNumeroDni();
		if (getNumeroDNI()) {
			return getTablaAsignacion().calcularLetra(extraerParteNumericaDni());
		} else {
			return Character.MIN_VALUE;
		}
	}

	private Boolean checkLongitudDni() {
		return getDNI().length() == this.LONGITUDNI;
	}

	Boolean isDniNumero(String cadena) {
		for (int i = 0; i < cadena.length(); i++) {
			if (!Character.isDigit(cadena.charAt(i))) {
				return false;
			} else
				;
		}
		return true;
	}

	String extraerParteNumericaDni() {
		return (String) DNI.substring(0, DNI.length() - 1);
	}

	Character extraerParteAlfabeticaDni() {
		return DNI.charAt(DNI.length() - 1);
	}

	private Boolean checkLetraValida() {
		return extraerParteAlfabeticaDni() == obtenerLetra();
	}
}

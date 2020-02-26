package cotxox.conductores;

import java.util.ArrayList;

public class Conductor {
	
	private String nombre = null;
	private String Matricula = null;
	private String Modelo = null;
	private double ValoracionMedia = 0d;
	private boolean Ocupado = false;
	private ArrayList<Byte> valoraciones = new ArrayList<Byte>();
	
	/** Constructor */
	
	public Conductor(String nombre) {
		this.nombre = nombre;
	}
	
	public Conductor() {}

	/** getters y setters */

	public String getNombre() {
		return this.nombre;
	}

	public String getMatricula() {
		return this.Matricula;
	}

	public void setMatricula(String matricula) {
		this.Matricula = matricula;
	}

	public String getModelo() {
		return this.Modelo;
	}

	public void setModelo(String modelo) {
		this.Modelo = modelo;
	}

	public double getValoracion() {
		return this.ValoracionMedia;
	}
		
	private double calcularValoracionMedia() {
		int SumaValoraciones = 0;
		for (byte valoracion : this.valoraciones) {
			SumaValoraciones += valoracion;
		}
		this.ValoracionMedia = SumaValoraciones / this.valoraciones.size();
		return this.ValoracionMedia;
	}
	
	public void setValoracion(byte valoracion) {
		this.valoraciones.add(valoracion);
		this.calcularValoracionMedia();
	}
	
	public void setOcupado(boolean ocupado) {
		this.Ocupado = ocupado;
	}

	public boolean isOcupado() {
		return this.Ocupado;
	}
}

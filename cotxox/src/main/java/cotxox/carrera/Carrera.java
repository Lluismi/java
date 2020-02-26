package cotxox.carrera;

import cotxox.conductores.Conductor;
import cotxox.conductores.PoolConductores;

public class Carrera {
	
	private Conductor conductor = null;
	private String tarjetaCredito = null;
	private String Origen = null;
	private String Destino = null;
	private double Distancia = 0d;
	private double CosteTotal = 0;
	private int TiempoEsperado = 0;
	private int TiempoCarrera = 0;
	private int propina = 0;

		
	/** Constructor */
	
	public Carrera(String tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}
	
	/** getters y setters */
	
	public String getTarjetaCredito() {
		return tarjetaCredito;
	}
	
	public String getOrigen() {
		return this.Origen;
	}
	
	public void setOrigen(String origen) {
		this.Origen = origen;
	}

	public String getDestino() {
		return this.Destino;
	}

	public void setDestino(String destino) {
		this.Destino = destino;	
	}

	public double getDistancia() {
		return this.Distancia;
	}

	public void setDistancia(double distancia) {
		this.Distancia = distancia;
	}
	
	public double getCosteEsperado() {
		return 0;
	}

	public int getTiempoEsperado() {
		return TiempoEsperado;
	}

	public void setTiempoEsperado(int tiempoEsperado) {
		this.TiempoEsperado = tiempoEsperado;
	}

	public int getTiempoCarrera() {
		return TiempoCarrera;
	}

	public void setTiempoCarrera(int tiempoCarrera) {
		this.TiempoCarrera = tiempoCarrera;
	}

	public Conductor getConductor() {
		return this.conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	public void asignarConductor(PoolConductores conductores) {
		setConductor(conductores.asignarConductor());
	}

	public void realizarPago(double pago) {
		this.CosteTotal = pago;
	}
	
	public double getCosteTotal() {
		return this.CosteTotal;
	}
	
	public int getPropina() {
		return this.propina;
	}

	public void recibirPropina(int propina) {
		this.propina = propina;
	}
	
	public void liberarConductor() {
		getConductor().setOcupado(false);
	}

}

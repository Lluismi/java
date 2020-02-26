package cotxox.conductores;

import java.util.ArrayList;
import java.util.Random;

public class PoolConductores {
		
	private ArrayList<Conductor> poolConductores = new ArrayList<>();
	
	/** Constructor */
	
	public PoolConductores(ArrayList<Conductor> poolConductores) {
		this.poolConductores = poolConductores;
	}
	
	/** getters y setters */
	
	public ArrayList<Conductor> getpoolConductores() {
		return this.poolConductores;
	}
	
	/** Logica */
	
	public Conductor asignarConductor() {
		 Conductor conductor = new Conductor();
		 Random aleatorio = new Random();
		 boolean asignado = false;
		 while (!asignado) {
			 int index = aleatorio.nextInt(getpoolConductores().size());
			 conductor = getpoolConductores().get(index);
			 if (!conductor.isOcupado()) {
				 conductor.setOcupado(true);
				 asignado = true;
			 }
		 }
		 return conductor;
	}
}

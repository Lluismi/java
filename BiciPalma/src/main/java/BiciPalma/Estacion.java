package BiciPalma;

public class Estacion {
	
	private int id = 0;
	private String address = null;
	private int NumAnclajes = 0;
	private Bicicleta[] Anclajes = null;

	public Estacion(int id, String address, int NumAnclajes) {
		this.id = id;
		this.address = address;
		this.NumAnclajes = NumAnclajes;
		this.Anclajes = new Bicicleta[NumAnclajes];
	}

	public int getId() {
		return id;
	}

	public void consultarEstacion() {
		System.out.println(this.id+" ");
		System.out.println(this.address+" ");
		System.out.println(this.NumAnclajes);
	}
	
	public int anclajesLibres() {
		 int anclajesLibres = 0;
		 
		for (int i=0; i< this.Anclajes.length; i++) {
			if (this.Anclajes[i] == null){
				anclajesLibres++;
			}
		}
		return anclajesLibres;
	}
	
	public void consultarAnclajes() {
		
		for(int i=0; i > this.Anclajes.length; i++) {
			if (Anclajes == null) {
				System.out.println("Esta libre");
			}
			else {
				System.out.println(this.Anclajes[i].getId());
			}
		}
	}
	
	
    public void anclarBicicleta(Bicicleta bicicleta) {

        for(int i=0; i< this.Anclajes.length; i++) {
            if (this.Anclajes[i] == null) {
                mostrarAnclaje(bicicleta,this.NumAnclajes);
                this.Anclajes[i] =  bicicleta;
                NumAnclajes = i+1;
                break;
            }
        }
   }
    
    public void mostrarAnclaje(Bicicleta bicicleta, int numAnclajes) {
    	System.out.println("Bicicleta" + bicicleta.getId() + "anclada en " + NumAnclajes);
    }

	public boolean leerTarjetaUsuario(TarjetaUsuario tarjetaUsuario) {
		return tarjetaUsuario.getActive();
	}

	public void retirarBicicleta(TarjetaUsuario tarjetaUsuario) {
		
		if ( leerTarjetaUsuario(tarjetaUsuario)) {
			boolean anclajeLibre = false;
            while(!anclajeLibre){
                int posicion = generarAnclaje();
                int numeroAnclaje = posicion + 1;
                if (this.Anclajes[posicion]!= null){
                    mostrarBicicleta( this.Anclajes[posicion], numeroAnclaje );
                    this.Anclajes[posicion] = null;
                    anclajeLibre = true;
                }
            }
        }else{
            System.out.print("La tarjeta no esta activada");
        }
    }
	
    public int generarAnclaje(){
        int pos = (int) (Math.random() * this.Anclajes.length);
    return pos;}
}
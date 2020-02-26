package BiciPalma;

public class TarjetaUsuario {
	
	private String id = null;
	private boolean active = false;
	
	public TarjetaUsuario(String id, boolean active) {
		this.active = active;
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public boolean getActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
}

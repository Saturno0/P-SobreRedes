package tipo;

public enum Tipo {
	FUEGO("Fuego"),
	AIRE("Aire"),
	AGUA("Agua");
	
	private String nombre;
	
	private Tipo(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}

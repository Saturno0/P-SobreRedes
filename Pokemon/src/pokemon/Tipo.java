package pokemon;

public enum Tipo {
	ELECTRICO("Electrico"),
	FUEGO("Fuego"),
	AGUA("Agua"),
	VENENO("Veneno"),
	PLANTA("Planta");
	
	private Tipo efectividad;
	String nombre;

	static {
		ELECTRICO.efectividad = AGUA;
		FUEGO.efectividad = PLANTA;
		PLANTA.efectividad = AGUA;
		VENENO.efectividad = PLANTA;
		AGUA.efectividad = FUEGO;
	};
	
	private Tipo(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEfectividad() {
		return efectividad.getNombre();
	}
	
	public String getNombre() {
		return nombre;
	}
}

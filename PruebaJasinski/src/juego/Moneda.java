package juego;

public enum Moneda {
	CARA("Cara"),
	CECA("Ceca");
	
	private String nombre;

	private Moneda(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}

package pokemon;

public enum Ataque {
	PLACAJE("Placaje", 35, 95),
	GRUÑIDO("Gruñido", 0, 100),
	ARAÑAZO("Arañazo", 40, 100),
	LATIGO("Latigo", 0, 70),
	IMPACTRUENO("Impactrueno", 0, 90),
	ONDA_TRUENO("Onda Trueno", 0, 60),
	ASCUAS("Ascuas", 40, 100),
	PANTALLA_HUMO("Pantalla de humo", 0, 60),
	BURBUJA("Burbuja", 40, 100),
	PISTOLA_AGUA("Pistola de agua", 50, 65),
	LATIGO_CEPA("Latigo cepa", 45, 100),
	POLVO_VENENOSO("Polvo venenoso", 0, 70),
	FORTALEZA("Fortaleza", 0, 80),
	RAYO_BURBUJA("Rayo burbuja", 60, 80),
	CONTRICCION("Contriccion", 20, 85),
	MALICIOSO("Malicioso", 0, 65),
	MORDISCO("Mordisco", 35, 95),;
	
	private int daño;
	private int probabilidadAcierto;
	private String nombre;
	
	Ataque(String nombre, int daño, int probabilidadAcierto) {
		this.nombre = nombre;
		this.daño = daño;
		this.probabilidadAcierto = probabilidadAcierto;
	}
	
	public int getProbabilidadAcierto() {
		return probabilidadAcierto;
	}
	
	public int getDaño() {
		return daño;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	
	
}

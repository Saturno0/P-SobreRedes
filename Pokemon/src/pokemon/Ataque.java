package pokemon;

public enum Ataque {
	PLACAJE("Placaje", 35, 95, Tipo.NORMAL),
	GRUÑIDO("Gruñido", 0, 100, Tipo.NORMAL),
	ARAÑAZO("Arañazo", 40, 100, Tipo.NORMAL),
	LATIGO("Latigo", 0, 70, Tipo.PLANTA),
	IMPACTRUENO("Impactrueno", 50, 90, Tipo.ELECTRICO),
	ONDA_TRUENO("Onda Trueno", 0, 60, Tipo.ELECTRICO),
	ASCUAS("Ascuas", 40, 100, Tipo.FUEGO),
	PANTALLA_HUMO("Pantalla de humo", 0, 60, Tipo.NORMAL),
	BURBUJA("Burbuja", 40, 100, Tipo.AGUA),
	PISTOLA_AGUA("Pistola de agua", 50, 65, Tipo.AGUA),
	LATIGO_CEPA("Latigo cepa", 45, 100, Tipo.PLANTA),
	POLVO_VENENOSO("Polvo venenoso", 0, 70, Tipo.VENENO),
	FORTALEZA("Fortaleza", 0, 80, Tipo.NORMAL),
	RAYO_BURBUJA("Rayo burbuja", 60, 80, Tipo.AGUA),
	CONTRICCION("Contriccion", 20, 85, Tipo.NORMAL),
	MALICIOSO("Malicioso", 0, 65, Tipo.NORMAL),
	MORDISCO("Mordisco", 35, 95, Tipo.NORMAL),;
	
	private int daño;
	private int probabilidadAcierto;
	private String nombre;
	private Tipo tipo;
	
	Ataque(String nombre, int daño, int probabilidadAcierto, Tipo tipo) {
		this.nombre = nombre;
		this.daño = daño;
		this.probabilidadAcierto = probabilidadAcierto;
		this.tipo = tipo;
	}
	
	public Tipo getTipo() {
		return tipo;
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

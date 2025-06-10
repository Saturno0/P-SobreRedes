package ataque;

import tipo.Tipo;

public abstract class Ataque {
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
		return this.tipo;
	}
	
	public int getProbabilidadAcierto() {
		return this.probabilidadAcierto;
	}
	
	public int getDaño() {
		return this.daño;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}

package ataque;

import java.util.ArrayList;

import efectos.Efecto;

public abstract class Ataque {
	protected ArrayList <int[]> danio = new ArrayList<int[]>();
	protected String nombre;
	protected int fallo;
	protected int energia;
	protected Efecto efecto;
	
	public Ataque(String nombre, int energia, Efecto efecto) {
		this.nombre = nombre;
		this.energia = energia;
		this.efecto = efecto;
	}
	
	public String getNombre() {
		return nombre;
	}
}

package Artilugios;

public class Arma {
	private int danio = 0;
	private int velAtaque = 0;
	private int precio = 0;
	private String nombre;
	
	public Arma(String nombre, int danio, int velAtaque, int precio) {
		this.danio = danio;
		this.velAtaque = velAtaque;
		this.precio = precio;
		this.nombre = nombre;
	}
	
	public int getDanio() {
		return danio;
	}
	
	public int getVelAtaque() {
		return velAtaque;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public String getNombre() {
		return nombre;
	}
}

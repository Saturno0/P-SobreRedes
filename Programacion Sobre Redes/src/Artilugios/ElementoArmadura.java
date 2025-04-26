package Artilugios;

public class ElementoArmadura {
	private String tipo, nombre;
	private int vidaExtra, velAtaque,precio;
	
	public ElementoArmadura(String tipo, String nombre, int precio, int vidaExtra, int velAtaque) {
		this.tipo = tipo;
		this.nombre = nombre;
		this.precio = precio;
		this.vidaExtra = vidaExtra;
		this.velAtaque = velAtaque;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public int getPrecio() {
		return precio;
	}
	public int getVelAtaque() {
		return velAtaque;
	}
	public int getVidaExtra() {
		return vidaExtra;
	}
}

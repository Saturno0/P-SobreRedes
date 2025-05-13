package pertenencias;

public class Mueble {
	private String nombre;
	private int felicidad;
	private int precio;
	
	public Mueble(String nombre, int felicidad, int precio) {
		this.nombre = nombre;
		this.felicidad = felicidad;
		this.precio = precio;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getFelicidad() {
		return felicidad;
	}
}

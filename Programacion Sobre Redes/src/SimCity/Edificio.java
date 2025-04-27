package SimCity;

public class Edificio {
	//Nombre - Tipo - Seguridad - Prev Incendios - Felicidad - Precio
	private String nombre;
	private String tipo;
	private int seguridad;
	private int prevIncendio;
	private int felicidad;
	private int precio;
	
	public Edificio(String nombre,String tipo, int seguridad, int prevIncendios, int felicidad, int precio) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.seguridad = seguridad;
		this.prevIncendio = prevIncendios;
		this.felicidad = felicidad;
		this.precio = precio;
	}
	
	public int getSeguridad() {
		return seguridad;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public String getTipo() {
		return tipo;
	}
	public int getPrevIncendio() {
		return prevIncendio;
	}
	public int getFelicidad() {
		return felicidad;
	}
	public int getPrecio() {
		return precio;
	}
	
}

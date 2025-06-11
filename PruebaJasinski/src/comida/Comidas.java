package comida;

public enum Comidas {
	MANZANA("Manzana", 1, 15),
	FIDEOS("Fideos", 5, 25),
	SUSHI("Sushi", 10, 40);
	
	private String nombre;
	private int precio;
	private int reduccionHambre;
	
	private Comidas(String nombre, int precio, int reduccionHambre) {
		this.nombre = nombre;
		this.precio = precio;
		this.reduccionHambre = reduccionHambre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getReduccionHambre() {
		return this.reduccionHambre;
	}
	
	public int getPrecio() {
		return this.precio;
	}
}

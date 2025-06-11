package comida;

public abstract class Comida {
	private int precio;
	private String nombre;
	private int reduccionHambre;
	private int cant = 1;
	
	protected Comida(String nombre, int precio, int reduccionHambre) {
		this.nombre = nombre;
		this.precio = precio;
		this.reduccionHambre = reduccionHambre;
	}
	
	public void mostrarDatos() {
		System.out.println("Precio: " + this.precio);
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Reduccion de hambre: " + this.reduccionHambre);
		System.out.println("Cantidad: " + this.cant);
	}
	
	public void agregarComida() {
		this.cant++;
	}
	
	public void comerComida() {
		this.cant--;
	}
	
	public int getReduccionHambre() {
		return this.reduccionHambre;
	}
	
	public int getCantComida() {
		return this.cant;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getPrecio() {
		return this.precio;
	}
}

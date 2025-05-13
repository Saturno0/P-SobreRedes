package pertenencias;

import interfaz.Tienda;
import sim.Jugador;

public class Casa {
	private final int MAX_OBJETOS = 20;
	private Jugador dueño;
	private Mueble[] muebles;
	
	public Casa(Jugador dueño) {
		this.dueño = dueño;
		comprarMuebles();
	}
	
	public void comprarMuebles() {
		Tienda tienda = new Tienda();
		this.muebles = tienda.comprar(this.muebles, this.dueño, this.MAX_OBJETOS);
	}
	
	public void mostrarDatos() {
		System.out.println("Cantidad de muebles: " + this.muebles.length);
		mostrarMuebles();
	}
	
	public void mostrarComodidad() {
		int felicidadTotal = 0;
		for (int i = 0; i < muebles.length; i++) {
			felicidadTotal += muebles[i].getFelicidad();
		}
		float porcentaje = ((Float.valueOf(felicidadTotal)) / 100);
		
		System.out.println("La comodidad total es de %" + porcentaje);
	}
	
	public void mostrarMayorMenorPrecio() {
		int maxPrecio = muebles[0].getPrecio();
		int minPrecio = muebles[0].getPrecio();
		
		for (int i = 1; i < muebles.length; i++) {
			int precio = muebles[i].getPrecio();
			if(maxPrecio < precio) {
				maxPrecio = precio;
			}
			if(minPrecio > precio) {
				minPrecio = precio;
			}
		}
		
		System.out.println("El mayo precio es $" + maxPrecio);
		System.out.println("El menor precio es $" + minPrecio);
	}
	
	public void mostrarValorTotal() {
		int valorTotal = muebles[0].getPrecio();;
		for (int i = 1; i < muebles.length; i++) {
			valorTotal += muebles[i].getPrecio();
		}
		
		System.out.println("El valor total es de $" + valorTotal);
	}

	private void mostrarMuebles() {
		for (int i = 0; i < muebles.length; i++) {
			String nombre = muebles[i].getNombre();
			int felicidad = muebles[i].getFelicidad();
			int precio = muebles[i].getPrecio();
			
			System.out.println((i+1) + ") Nombre: " + nombre + " - Felicidad: " + felicidad + " - Precio: " + precio);
		}
	}
}

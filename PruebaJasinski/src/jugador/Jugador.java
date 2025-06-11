package jugador;

import java.util.ArrayList;

import comida.Comida;
import mascota.*;
import utiles.Utiles;

public class Jugador {
	private String nombre;
	private Mascota mascota;
	private int monedas = 10;
	private ArrayList <Comida> comida = new ArrayList<Comida>();;

	public Jugador(String nombre) {
		this.nombre = nombre;
	}
	
	public void comprar(Comida comida) {
		int precio = comida.getPrecio();
		if(this.monedas < precio) {
			System.out.println("No puedes comprar este item porque no tienes los fondos suficientes");
			System.out.println("Valor del item: " + precio);
			System.out.println("Monedas disponibles: " + this.monedas);
			return;
		} else {
			this.monedas -= precio;
			System.out.println("Compra realizada con exito!");
		}
		
		if(this.comida.isEmpty()) {			
			this.comida.add(comida);
		} else {
			if(!this.comida.contains(comida)) {
				this.comida.add(comida);
			} else {
				int index = 0;
				boolean encontrado = false;
				while(!encontrado && index < this.comida.size()) {
					if(this.comida.get(index).equals(comida)) {
						encontrado = true;
					} else {
						index++;
					}
				}
				
				this.comida.get(index).agregarComida();
			}
		}
	
	}
	
	public void conseguirMascota() {
		System.out.println("Ingrese que mascota quiere elegir");
		for (int i = 0; i < Mascotas.values().length; i++) {
			System.out.println((i+1) + ") Nombre:" + Mascotas.values()[i].getNombre());
		}
		
		int opc = Utiles.ingresarEntero(1, Mascotas.values().length);
	
		switch (opc) {
			case 1:
				mascota = new Nimmo();
				break;
			case 2:
				mascota = new Mecca();
				break;
			case 3:
				mascota = new Koi();
				break;
		}
	}
	
	
	
	public void mostrarComida() {
		for (int i = 0; i < this.comida.size(); i++) {
			System.out.println((i+1) + ") " + this.comida.get(i).getNombre());
		}
	}
	
	public void mostrarDatos() {
		System.out.println("Dinero: " + this.monedas);
	}
	
	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}
	
	public int getMonedas() {
		return this.monedas;
	}
	
	public void aplicarCodigoEspecial() {
		this.monedas += 10;
	}
	
	public ArrayList<Comida> getComida() {
		return comida;
	}
	
	public Mascota getMascota() {
		return this.mascota;
	}

	public String getNombre() {
		return this.nombre;
	}


}

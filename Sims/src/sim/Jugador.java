package sim;

import pertenencias.Casa;

public class Jugador {
	private String nombre;
	private int edad;
	public int dinero = 10000;
	private String signo;
	public Casa casa;
	
	public Jugador(String nombre, int edad) {
		this.edad = edad;
		this.nombre = nombre;
		System.out.println("Elija su signo: ");
		this.signo = elegirSigno();
	}

	
	private String elegirSigno() {
		Signo[] signos = Signo.values();
		for (int i = 0; i < signos.length; i++) {
			System.out.println((i+1) + ") " + signos[i]);
		}
		int opcion = utilidades.Utiles.ingresarEntero(1, 12) - 1;
		String signo = String.valueOf(signos[opcion]);
		
		return signo;
	}

	public void mostrarDatos() {
		System.out.println("Datos sim:");
		System.out.println("Nombre: " + this.nombre + " - Edad: " + this.edad + " - Signo: " + this.signo);
		
		System.out.println("Datos casa: ");
		casa.mostrarDatos();
	}


	
	
	
}

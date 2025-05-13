import interfaz.Interfaz;
import pertenencias.Casa;
import sim.Jugador;

public class Principal {
	public static void main(String[] args) {
		crearJugador();
		
	}

	private static void crearJugador() {
		System.out.println("Ingrese su nombre y apellido");
		String nombre = utilidades.Utiles.s.nextLine();
		
		System.out.println("Ingrese su edad");
		int edad = utilidades.Utiles.ingresarEntero(18, 100);
		
		Jugador sim = new Jugador(nombre,edad);
		Casa casa = new Casa(sim);
		sim.casa = casa;
		
		
		Interfaz interfaz = new Interfaz();
		interfaz.mostrtarMenu(sim);
	}

	
}

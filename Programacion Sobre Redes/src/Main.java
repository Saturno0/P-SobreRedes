//import Tienda.Tienda;
import SimCity.Ciudad;
import SimCity.Edificio;
import SimCity.Jugador;
import SimCity.Tienda;
import Utilidades.utilidades;
//import Curso.Tienda;


public class Main {

	public static void main(String[] args) {
		System.out.println("Vienvenido al juego del SimCity");
		System.out.println("Ingrese el nombre de su ciudad: ");
		String nombreCiudad = utilidades.s.nextLine();
		
		Ciudad ciudad = new Ciudad(nombreCiudad, crearJugador());
		
		Tienda tienda = new Tienda();
		
		Edificio[] edificios = tienda.comprarEdificios(ciudad.getAlcalde());
		ciudad.setEdificios(edificios);
		
		ciudad.menu();
		
		utilidades.s.close();
	}

	

	private static Jugador crearJugador() {
		System.out.println("Ingrese su nombre como alcalde");
		String nombre = utilidades.s.nextLine();
		return new Jugador(nombre);
	}

//	private static String ingresarNombre() {
//		String nombre = utilidades.s.nextLine();
//		return nombre;
//	}

}


//Jugador jugador1 = new Jugador(ingresarNombre());
//Jugador jugador2 = new Jugador(ingresarNombre());
//Tienda tienda = new Tienda();
//
//tienda.comprar(jugador1);
//tienda.comprar(jugador2);
//
//jugador1.mostrarDatos();
//jugador2.mostrarDatos();

package principal;

import java.util.ArrayList;

import comida.*;
import jugador.Jugador;
import mascota.Mascota;
import utiles.Utiles;

public class Principal {

	public static void main(String[] args) {
		boolean salir = false;
		Jugador jugador = crearJugador();
		Utiles.jugador = jugador;
		jugador.conseguirMascota();
		Mascota mascota = jugador.getMascota();
		do {
			
			jugador.mostrarDatos();
			
			System.out.println("Ahora elija que quiere hacer con su mascota: ");
			int opc = elegirMenu();
			switch (opc) {
			case 1:
				mascota.baniar();
				salir = false;
				break;
			case 2:
				if(!jugador.getComida().isEmpty()) {
					alimentarMascota(jugador, mascota);
				} else {
					System.out.println("No tienes ningun alimento en la bolsa de comida");
				}
				salir = false;
				break;
			case 3:
				mascota.dormir();
				salir = false;
				break;
			case 4:
				jugador.setMonedas(mascota.jugar(jugador.getMonedas()));
				salir = false;
				break;
			case 5:
				Comida comida = seleccionarComida();
				jugador.comprar(comida);
				salir = false;
				break;
			case 6:
				salir = true;
				break;
			}
			
			mascota.mostrarDatos();
		} while (!salir);
	}

	private static void alimentarMascota(Jugador jugador, Mascota mascota) {
		int index = elegirComida(jugador) - 1;
		int reduccionHambre = jugador.getComida().get(index).getReduccionHambre();
		mascota.comer(reduccionHambre);
		jugador.getComida().get(index).comerComida();
		if(jugador.getComida().get(index).getCantComida() == 0) {
			jugador.getComida().remove(index);
		}
	}

	private static Comida seleccionarComida() {
		System.out.println("Elija que item quiere comprar: ");
		for (int i = 0; i < Comidas.values().length; i++) {
			Comidas comida = Comidas.values()[i];
			System.out.println((i+1) + ") " + comida.getNombre() + " | Precio: " + comida.getPrecio() + " | Reduccion de hambre: " + comida.getReduccionHambre());
		}
		int opc = Utiles.ingresarEntero(1, Comidas.values().length);
		switch (opc) {
		case 2:
			return new Fideos();
		case 3:
			return new Sushi();
		default:
			return new Manzana();
		}
	}

	private static int elegirComida(Jugador jugador) {
		ArrayList <Comida> comida = jugador.getComida();
		System.out.println("Elija la comida con la que va a alimentar a su mascota");
		jugador.mostrarComida();
		int opc = Utiles.ingresarEntero(1, comida.size());
		return opc;
	}

	private static int elegirMenu() {
		System.out.println("1) Bañar a su mascota");
		System.out.println("2) Darle de comer a su mascota");
		System.out.println("3) Dormir a su mascota");
		System.out.println("4) Jugar con su mascota");
		System.out.println("5) Comprar comida");
		System.out.println("6) Salir");
		
		int opc = Utiles.ingresarEntero(1, 6);
		
		return opc;
	}

	private static Jugador crearJugador() {
		System.out.println("Ingrese su nombre: ");
		Jugador jugador = new Jugador(Utiles.s.nextLine());
		return jugador;
	}

}

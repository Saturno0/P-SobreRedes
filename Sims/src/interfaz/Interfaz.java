package interfaz;

import sim.Jugador;

public class Interfaz {
	
	public void mostrtarMenu(Jugador sim) {
		boolean seguir = true;
		
		do {
			System.out.println("1) Mostrar datos del Sim y objetos que tiene en la casa");
			System.out.println("2) Mostrar promedio de comodidad que brinda la casa en porcentaje");
			System.out.println("3) Mostrar objeto de mayor precio y el de menor precio");
			System.out.println("4) Mostrar valor total de la casa segun los objetos que contiene");
			System.out.println("5) Salir");
			int opc = utilidades.Utiles.ingresarEntero(1, 5);
			
			switch (opc) {
				case 1:
					sim.mostrarDatos();
					break;
				case 2:
					sim.casa.mostrarComodidad();
					break;
				case 3:
					sim.casa.mostrarMayorMenorPrecio();
					break;
				case 4:
					sim.casa.mostrarValorTotal();
					break;
				case 5:
					seguir = false;
					break;
			}
		} while (seguir);
	}

	
}

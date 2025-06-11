package juego;

import utiles.Utiles;

public class CaraCeca extends Juego{

	@Override 
	public boolean jugar() {
		boolean gano = false;
		System.out.println("Elija que cree que va a salir:");
		for (int i = 0; i < Moneda.values().length; i++) {
			System.out.println((i+1) + ") " + Moneda.values()[i].getNombre());
		}
		
		int opc = Utiles.ingresarEntero(1,Moneda.values().length) - 1;
		int r = Utiles.generarEntero(Moneda.values().length);
		
		if (opc == r) {
			gano = true;
			System.out.println("Felicidades has ganado!!");
		} else {
			System.out.println("Que lastima has perdido :(");
		}
		
		return gano;
	}

}

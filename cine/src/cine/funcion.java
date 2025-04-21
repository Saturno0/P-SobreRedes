package cine;

import java.util.Scanner;

public class funcion {
	
	private Scanner s = new Scanner(System.in);
	
	
	private String ingresarFormato(boolean error) {
		String formatoNuevo = "";
		String[] formatosCorrectos;
		try {
			formatosCorrectos = pelicula.getFormato();
		} catch (Exception e) {
			e.printStackTrace();
		}
		do {
			formatoNuevo = s.nextLine().toUpperCase();
			for (int i = 0; i < formatosCorrectos.length; i++) {
				if(formatosCorrectos[i].equals(formatoNuevo)) {
					error = false;
				}
			}
			
			if(error) {
				System.out.println("Ingrese un valor correcto por favor, ´2D´ o ´3D´");
			}
		} while(error);
		return formatoNuevo;
	}
}

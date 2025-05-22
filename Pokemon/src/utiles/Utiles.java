package utiles;

import java.util.Random;
import java.util.Scanner;

public class Utiles {
	public static Scanner s = new Scanner(System.in);
	
	
	public static int randomEntero(int n) {
		Random r = new Random();
		int random = r.nextInt(n);
		return random;
	}
	
	public static int ingresarEntero(final int MIN, final int MAX) {
		boolean error = true;
		int n = 0;
		do {
			try {
				n = s.nextInt();
				if(n < MIN || n > MAX) {
					System.out.println("Ingrese un numero entero entre " + MIN + " y " + MAX);
				} else {
					error = false;
				}
				
			} catch(Exception e) {
				System.err.println("Ah ocurrido un error");
			}  
			
			s.nextLine();
			
		} while(error);
		
		return n;
	}
	
	public static float ingresarFloat(final int MIN, final int MAX) {
		boolean error = true;
		float n = 0;
		do {
			try {
				n = s.nextFloat();
				if(n < MIN || n > MAX) {
					System.out.println("Ingrese un numero entero entre " + MIN + " y " + MAX);
				} else {
					error = false;
				}
				
			} catch(Exception e) {
				System.err.println("Ah ocurrido un error");
			}
			
			s.nextLine();
		} while(error);
		
		n = (float) (Math.round(n * 2) / 2.0);
		
		return n;
	}
	
	public static int[] encontrarEnMatriz(int posicion,int numero, int[][] matriz) {
		int cant = 0;
		
		for (int i = 0; i < matriz.length; i++) {
			if(matriz[i][posicion] == numero) {
				cant++;
			}
		}
		
		int[] posiciones = new int[cant];
		int indice = 0;
		
		
		for(int i = 0; i < matriz.length; i++) {
			if(matriz[i][posicion] == numero) {
				posiciones[indice] = i;
				indice++;
			}
		}
		return posiciones;
		
	}
}

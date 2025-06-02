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
	

}
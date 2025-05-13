package utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utiles {
	public static Scanner s = new Scanner(System.in);
	
	public static int ingresarEntero(final int MIN, final int MAX) {
		int n = 0;
		boolean err = true;
		
		do {
			try {
				n = s.nextInt();
				if(n > MAX || n < MIN) {
					System.out.println("Ingrese un numero que sea mayor a " +  MIN + " y menor a " +  MAX);
				} else {
					err = false;
				}
			} catch(InputMismatchException e) {
				System.err.println("Ingrese un tipo de dato correcto");
			} catch(Exception e) {
				System.err.println("Error desconocido, llame a soporte");
				System.exit(1);
			} finally {
				s.nextLine();
			}
		} while (err);
		
		return n;
	}
}

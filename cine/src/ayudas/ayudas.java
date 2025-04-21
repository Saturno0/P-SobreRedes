package ayudas;

import java.util.Scanner;

public class ayudas {
	public Scanner s = new Scanner(System.in);
	private boolean error = true;
	public int ingresarEntero(final int min, final int max) {
		int n = 0;;
		do {
			try {
				n = s.nextInt();
				if(n < min || n > max) {
					System.out.println("Por favor ingrese un numero entre " + min + " y " + max);
				} else {
					error = false;
				}
			} catch(Exception e) {
				System.err.println("Error al ingresar el entero");
				System.err.println(e);
			}
		} while (error);
		
		error = true;
		return n;
	}
}

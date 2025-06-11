package utiles;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import jugador.Jugador;

public abstract class Utiles {
	public static Scanner s = new Scanner(System.in);
	public static Random r = new Random();
	public static Jugador jugador;
	
	public static int generarEntero(final int NUM) {
		int random = r.nextInt(NUM) + 1;
		return random;
	}
	
	public static int ingresarEntero(final int MIN, final int MAX) {
		int num = -1;
		boolean error = false;
		do {
			try {
				num = s.nextInt();
				if(num > MAX && num < MIN) {
					error = true;
					System.out.println("Por favor ingrese un numero valido entre " + MIN + " y " + MAX);
				}
			} catch (InputMismatchException e) {
				System.err.println("Error! tipo de dato no correspondiente.");
			} catch (Error e){
				System.err.println("Error fatal!! error desconocido");
				System.exit(1);
			} finally {
				String resto = s.nextLine();
				if(resto.equalsIgnoreCase("money")) {
					jugador.aplicarCodigoEspecial();
				}
			}
		} while (error);
		return num;
	}
}

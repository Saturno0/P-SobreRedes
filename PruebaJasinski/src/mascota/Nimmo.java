package mascota;

import tipo.Tipo;

public class Nimmo extends Mascota{
	private static String nombre = "Nimmo";
	private static Tipo tipo = Tipo.FUEGO;
	
	public Nimmo() {
		super(nombre, tipo);
	}

}

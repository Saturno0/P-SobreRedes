package mascota;

import tipo.Tipo;

public class Koi extends Mascota{
	private static String nombre = "Koi";
	private static Tipo tipo = Tipo.AGUA;

	public Koi() {
		super(nombre, tipo);
	}

}

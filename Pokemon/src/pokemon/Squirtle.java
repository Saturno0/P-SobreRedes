package pokemon;

import ataque.Ataque;
import ataque.Burbuja;
import ataque.Latigo;
import ataque.PistolaAgua;
import ataque.Placaje;
import tipo.Tipo;

public class Squirtle extends Pokemon{
	private static Ataque[] ataques= {new Placaje(), new Latigo() , new Burbuja(), new PistolaAgua()};
	private static Tipo tipo = Tipo.AGUA;
	private static String nombre = "Squirtle"; 
	
	public Squirtle() {
		super(80, nombre, tipo, ataques);
	}
}

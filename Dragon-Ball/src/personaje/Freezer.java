package personaje;

import ataque.Supernova;


public class Freezer extends Personaje{
	private static int vida = 7000;
	private static int energia = 40000;
	
	public Freezer() {
		super(vida, energia);
		super.ataques.add(new Supernova());
	}
}

package personaje;

import ataque.Kamehameha;

public class Goku extends Personaje{
	
	private static int vida = 5000;
	private static int energia = 50000;
	
	public Goku() {
		super(vida, energia);
		super.ataques.add(new Kamehameha());
	}
}

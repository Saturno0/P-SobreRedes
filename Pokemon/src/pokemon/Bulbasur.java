package pokemon;

import ataque.*;
import tipo.Tipo;

public class Bulbasur extends Pokemon{
	private static Ataque[] ataques= {new Placaje(), new Grunido() , new LatigoCepa(), new PolvoVenenoso()};
	private static Tipo tipo = Tipo.PLANTA;
	public Bulbasur() {
		super(78, "Bulbasur", tipo, ataques);
	}
}

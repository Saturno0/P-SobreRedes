package pokemon;

import ataque.Ataque;
import ataque.Grunido;
import ataque.Impactrueno;
import ataque.Latigo;
import ataque.OndaTrueno;
import tipo.Tipo;

public class Pikachu extends Pokemon{
	
	private static Ataque[] ataques = {new Latigo(), new Impactrueno(), new Grunido(), new OndaTrueno()};
	private static Tipo tipo = Tipo.ELECTRICO;
	
	public Pikachu() {
		super(40,"Pikachu", tipo, ataques);
	}

	
}

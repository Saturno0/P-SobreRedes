package personaje;

import java.util.ArrayList;

import ataque.Ataque;
import ataque.Taioken;

public class Goku extends Personaje{
	protected ArrayList <Ataque> ataques = new ArrayList <Ataque>();
	
	public Goku() {
		super();
		this.ataques.add(new Taioken());
		this.ataques.addAll(super.ataques);
	}
}

package personaje;

import java.util.ArrayList;

import ataque.Ataque;
import ataque.Golpe;

public abstract class Personaje {
	protected int vida;
	protected ArrayList <Ataque> ataques = new ArrayList <Ataque>();
	
	public Personaje() {
		ataques.add(new Golpe());
	}
	
	
	public void atacar() {
		seleccionarAtaque();
	}


	private void seleccionarAtaque() {
		System.out.println("Elija que ataque quiere utilizar");
		for (int i = 0; i < this.ataques.size(); i++) {
			System.out.println((i+1) + ") " + ataques.get(i).getNombre());
		}
		int opc = utiles.Utiles.ingresarEntero(1, this.ataques.size()) - 1;
		
		int danio = this.ataques.get(opc).calcularDanio();
	}
	
}

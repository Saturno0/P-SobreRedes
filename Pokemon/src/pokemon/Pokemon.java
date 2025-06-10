package pokemon;

import java.util.ArrayList;
import ataque.Ataque;
import tipo.Tipo;
import utiles.Utiles;


public abstract class Pokemon {
	protected String nombre;
	public int vida = 100;
	protected Ataque[] ataques = new Ataque[4];
	private Tipo tipo;
	
	public Pokemon(int vida, String nombre, Tipo tipo, Ataque[] ataques) {
		this.vida = vida;
		this.nombre = nombre;
		this.tipo = tipo;
		this.ataques = ataques;
	}
	
	private void mostrarAtaques() {
		for (int i = 0; i < this.ataques.length; i++) {
			System.out.println((i+1) + "- " + this.ataques[i].getNombre() + "\n\t -Daño: " + this.ataques[i].getDaño());
		}
	}
	
	public int atacar(int turno, Tipo tipoEnemigo) {
		if(turno==1) {
			System.out.println("Elija que ataque quiere realizar:");
			mostrarAtaques();
			final int INDEX = Utiles.ingresarEntero(1, this.ataques.length);
			boolean acierto = calcularAcierto(this.ataques[INDEX]);
			if(acierto) {
				System.out.println("Tu pokemon ah acertado y causado " + this.ataques[INDEX].getDaño() + "!!");
				float danio = this.ataques[INDEX].getDaño();
				danio *= calcularEfectividad(this.ataques[INDEX].getTipo(), tipoEnemigo);
				return (int) danio;
			}
				System.out.println("Uhhh tu pokemon ah fallado :(");
		} else {
			int eleccion = utiles.Utiles.randomEntero(this.ataques.length)-1;
			boolean acierto = calcularAcierto(this.ataques[eleccion]);
			if(acierto) {
				float danio = this.ataques[eleccion].getDaño();
				Tipo tipoAtaque = this.ataques[eleccion].getTipo();
				danio *= calcularEfectividad(tipoAtaque, tipoEnemigo);
				return (int) danio;
			}
		}
		return 0;
	}
	

	private float calcularEfectividad(Tipo tipoAtaque,Tipo tipoEnemigo) {
		if (tipoAtaque.getEfectividad().equals(tipoEnemigo)) {
			return 2f;
		} else {
			boolean encontrado = false;
			int i = 0;
			while(!encontrado && i < tipoAtaque.getPocaEfectividad().size()) {
				if(tipoAtaque.getPocaEfectividad().get(i).equals(tipoEnemigo)) {
					encontrado = true;
				}
			}
			if(encontrado) {
				return 0.5f;
			}
		}
		return 1f;
	}

	public void mostrarDatos() {
		System.out.println("Pokemon: " + this.nombre);
		System.out.println("Vida: " + this.vida);
	}
	
	public boolean calcularAcierto(Ataque ataque) {
		int r = utiles.Utiles.randomEntero(100) + 1;
		if(r <= ataque.getProbabilidadAcierto()) {
			return true;
		}
		return false;
	}
	
	
	public String getTipoEfectivo(final int INDEX) {
		return this.ataques[INDEX].getTipo().getEfectividad();
	}
	
	public Tipo getTipo() {
		return this.tipo;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Ataque[] getAtaques() {
		return ataques;
	}

}

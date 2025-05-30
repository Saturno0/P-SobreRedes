package pokemon;

import java.util.ArrayList;
import java.util.List;

public abstract class Pokemon {
	protected String nombre;
	public int vida = 100;
	protected Ataque[] ataques = new Ataque[4];
	private Tipo tipo;
	
	public Pokemon(int vida, String nombre, Tipo tipo) {
		this.vida = vida;
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	protected void obtenerAtaques(String[] nombreAtaques) {
		List<Ataque> ataquesEncontrados = new ArrayList<>();

		for (String nombre : nombreAtaques) {
			nombre = nombre.toLowerCase().trim();
			for (Ataque a : Ataque.values()) {
				if (a.getNombre().toLowerCase().equals(nombre)) {
					ataquesEncontrados.add(a);
					break; // Stop after first match
				}
			}
		}

		// Limit to max 4 attacks
		int size = Math.min(ataquesEncontrados.size(), 4);
		this.ataques = new Ataque[size];
		for (int i = 0; i < size; i++) {
			this.ataques[i] = ataquesEncontrados.get(i);
		}
	}

	
	
	
	private void mostrarAtaques() {
		for (int i = 0; i < this.ataques.length; i++) {
			System.out.println((i+1) + "- " + this.ataques[i].getNombre() + "\n\t -Daño: " + this.ataques[i].getDaño());
		}
	}
	
	public int atacar(int turno) {
		if(turno==1) {
			System.out.println("Elija que ataque quiere realizar:");
			mostrarAtaques();
			final int INDEX = utiles.Utiles.ingresarEntero(1, this.ataques.length)-1;
			boolean acierto = calcularAcierto(this.ataques[INDEX]);
			if(acierto) {
				System.out.println("Tu pokemon ah acertado y causado " + this.ataques[INDEX].getDaño() + "!!");
				return this.ataques[INDEX].getDaño();
			}
				System.out.println("Uhhh tu pokemon ah fallado :(");
		} else {
			int eleccion = utiles.Utiles.randomEntero(this.ataques.length)-1;
			boolean acierto = calcularAcierto(this.ataques[eleccion]);
			if(acierto) return this.ataques[eleccion].getDaño();
		}
		return 0;
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

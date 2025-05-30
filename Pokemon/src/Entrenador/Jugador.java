package Entrenador;

import pokemon.Pokemon;
import pokemon.Pikachu;

public class Jugador {
	private String nombre;
	private Pokemon[] pokemones = {new Pikachu()};
	public Jugador(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Pokemon[] getPokemones() {
		return pokemones;
	}
}

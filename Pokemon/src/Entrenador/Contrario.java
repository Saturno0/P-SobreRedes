package Entrenador;

import pokemon.Pokemon;
import pokemon.Bulbasur;

public class Contrario {
	private String nombre = "Gary Oak";
	private Pokemon[] pokemones = {new Bulbasur()};
	
	public String getNombre() {
		return nombre;
	}
	
	public Pokemon[] getPokemones() {
		return pokemones;
	}
}

package mascota;

import estado.*;
import tipo.Tipo;
import juego.*;

public abstract class Mascota {
	private String nombre;
	private Tipo tipo;
	private Estado[] estados= {new Felicidad(), new Hambre(), new Suenio(), new Suciedad()};
	private final int FELICIDAD = 0, HAMBRE = 1, SUENIO = 2, SUCIEDAD = 3;
	
	protected Mascota(String nombre, Tipo tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public void baniar() {
		switch (this.tipo) {
		case FUEGO:
			estados[SUCIEDAD].setValor(estados[SUCIEDAD].getValor() - 50);
			break;
		case AIRE:
			estados[SUCIEDAD].setValor(estados[SUCIEDAD].getValor() - 70);
			break;
		case AGUA:
			estados[SUCIEDAD].setValor(estados[SUCIEDAD].getValor() - 90);
			break;
		}
		estados[HAMBRE].setValor(estados[HAMBRE].getValor() + 5);
		estados[FELICIDAD].setValor(estados[FELICIDAD].getValor() - 7);
	}
	
	public int jugar(int monedas) {
		if(monedas >= 3) {
			Juego juego = new CaraCeca();
			boolean gano = juego.jugar();
			
			if(gano) {
				monedas+=3;
			} else {
				monedas-=3;
			}
		} else {
			System.out.println("No tienes las monedas suficientes para jugar");
		}
		
		return monedas;
	}
	
	public void comer(int reduccionHambre) {
		int hambre = estados[HAMBRE].getValor();
		hambre -= reduccionHambre;
		estados[HAMBRE].setValor(hambre);
		estados[SUENIO].setValor(estados[SUENIO].getValor() + 7);
		estados[SUCIEDAD].setValor(estados[SUCIEDAD].getValor() + 5);
	}
	
	public void dormir() {
		estados[SUENIO].setValor(0);
	}
	
	public Estado[] getEstados() {
		return this.estados;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Tipo getTipo() {
		return this.tipo;
	}

	public void mostrarDatos() {
		for (Estado estado : estados) {
			System.out.println(estado.getNombre() + ": " + estado.getValor());
		}
		
	}
}

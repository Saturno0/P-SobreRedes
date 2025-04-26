package Jugador;

import Artilugios.Arma;
import Artilugios.ElementoArmadura;

public class Jugador {
	private int vida = 100;
	private int dinero = 7000;
	private String nombre;
	private int ataque = 2;
	private int velAtaque = 1;
	
	private ElementoArmadura[] armadura = new ElementoArmadura[4];
	private Arma arma;
	
	private int cantPartesArmadura = 0;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	public boolean comprovarExistenciaTipo(String tipo) {
		int i = 0;
		boolean encontrada = false;
		
		while(i < cantPartesArmadura && !encontrada) {
			if(armadura[i].getTipo().equals(tipo)) {
				encontrada = true;
			}
			i++;
		}
		
		return encontrada;
	}
	
	
	public void comprarParte(ElementoArmadura parteComprada) {
		this.armadura[cantPartesArmadura] = parteComprada;
		this.dinero -= parteComprada.getPrecio();
		this.vida += parteComprada.getVidaExtra();
		this.velAtaque += parteComprada.getVelAtaque();
		this.cantPartesArmadura++;
	}

	public void comprarArma(Arma armaComprada) {
		this.arma = armaComprada;
		this.dinero -= armaComprada.getPrecio();
		this.velAtaque += armaComprada.getVelAtaque();
		this.ataque += armaComprada.getDanio();
	}
	
	public void mostrarDatos() {
		System.out.println("Nombre: " + nombre);
		if(armadura[0] != null) {
			System.out.println("Armadura: ");
			for (ElementoArmadura elementoArmadura : armadura) {
				System.out.println("Tipo: " + elementoArmadura.getTipo());
				System.out.println("Nombre: " + elementoArmadura.getNombre());
			}
		} else {
			System.out.println("Este jugador no tiene ninguna armadura");
		}
		if(arma != null) {
			System.out.println("Arma: " + arma.getNombre());
		} else {
			System.out.println("El jugador no posee ninguna arma");
		}
		
		System.out.println("vida: " + vida);
		System.out.println("Danio: " + ataque);
		System.out.println("Velocidad de ataque: " + velAtaque);
		
	}
	
	public int getDinero() {
		return dinero;
	}

	public String getNombre() {
		return nombre;
	}

	public Arma getArma() {
		return arma;
	}

	



}

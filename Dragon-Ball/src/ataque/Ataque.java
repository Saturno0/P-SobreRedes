package ataque;

import java.util.ArrayList;

import efectos.Efecto;
import utiles.Utiles;

public abstract class Ataque {
	protected ArrayList <int[]> danio = new ArrayList<int[]>();
	private String nombre;
	private int probFallo;
	private int energia;
	private Efecto efecto;
	private final int INDEX_PROBABILIDAD = 2;
	private final int INDEX_DANIO_MIN = 0;
	private final int INDEX_DANIO_MAX = 1;
	
	public Ataque(String nombre, int energia, Efecto efecto, int probFallo) {
		this.nombre = nombre;
		this.energia = energia;
		this.efecto = efecto;
		this.probFallo = probFallo;
	}
	
	
	public int calcularDanio() {
		int index = calcularProbabilidadDanio();
		int danioMin = this.danio.get(index)[INDEX_DANIO_MIN];
		int danioMax = this.danio.get(index)[INDEX_DANIO_MAX];
		int danio = Utiles.randomEntero(danioMin) + danioMax;
		return danio;
	}
	
	private int calcularProbabilidadDanio() {
		int[] probabilidades = new int[danio.size()];
		for (int i = 0; i < probabilidades.length; i++) {
			int n = danio.get(i)[INDEX_PROBABILIDAD];
			probabilidades[i] = n;
		}
		
		int index = 0;
		boolean encontrado = false;
		int r = utiles.Utiles.randomEntero(100) + 1;
		int i = 0; 
		
		while (!encontrado && i < probabilidades.length) {
			if(r <= probabilidades[i] ) {
				index = i;
				encontrado = true;
			} else {
				i++;
			}
		}
		
		return index;
	}
	
	public void mostrarDatos() {
		System.out.println("----------------------------------------");
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Energia: " + this.energia);
		System.out.println("Probabilidad de fallo: " + this.probFallo);
		System.out.println("El daño puede estar entre " + this.danio.get(0)[INDEX_DANIO_MIN] + " y " + this.danio.get(0)[INDEX_DANIO_MAX]);
		System.out.println("----------------------------------------");
	}
	
	public int getEnergia() {
		return this.energia;
	}
	
	public boolean getFallo() {
		int r = utiles.Utiles.randomEntero(100) + 1;
		if(r > this.probFallo) {
			return false;
		}
		return true;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public Efecto getEfecto() {
		return efecto;
	}
}

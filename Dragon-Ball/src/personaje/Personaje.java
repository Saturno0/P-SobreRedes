package personaje;

import java.util.ArrayList;

import ataque.Ataque;
import ataque.Golpe;
import efectos.Efecto;
import utiles.Utiles;

public abstract class Personaje {
	protected int vida;
	protected int energia;
	protected boolean afectado = false;
	protected Efecto efecto;
	protected ArrayList <Ataque> ataques = new ArrayList <Ataque>();
	
	public Personaje(int vida, int energia) {
		this.vida = vida;
		this.energia = energia;
		ataques.add(new Golpe());
	}
	
	
	public int atacar(int turno) {
		int opc;
		boolean tieneEnergia = true;
		do {
			tieneEnergia = true;
			
			if (turno == 1) {
				opc = Utiles.randomEntero(this.ataques.size());
				if((this.energia- this.ataques.get(opc).getEnergia()) <= 0) {
					tieneEnergia = false;
				}
			} else {
				opc = seleccionarAtaque();
				if((this.energia- this.ataques.get(opc).getEnergia()) <= 0) {
					System.out.println("No tiene energia suficiente para realizar un ataque que requiera de energia");
					tieneEnergia = false;
				}
			}
		} while (!tieneEnergia);
		
		Ataque ataque = this.ataques.get(opc);
		int danio = ataque.calcularDanio();
		boolean falla = ataque.getFallo();
		
		if(falla) {
			danio = 0;
		}
		
		this.energia -= ataque.getEnergia();
		
		return danio;
	}
	

	private int seleccionarAtaque() {
		System.out.println("Elija que ataque quiere utilizar");
		for (int i = 0; i < this.ataques.size(); i++) {
			this.ataques.get(i).mostrarDatos();
		}
		int opc = Utiles.ingresarEntero(1, this.ataques.size()) - 1;
		return opc;	
	}
	
	public void mostrarDatos() {
		System.out.println("Vida: " + this.vida);
		System.out.println("Energia: " + this.energia);
	}
	
	private void afectar() {
		// TODO Auto-generated method stub

	}
	
	public void recibirDaño(int danio) {
		this.vida -= danio;
		if(this.vida <= 0) {
			this.vida = 0;
		}
	}
	
	public int getVida() {
		return this.vida;
	}
	
	public boolean getAfectado() {
		return this.afectado;
	}
	
	public void recibirEfecto(Efecto efecto) {
		if(!afectado) {
			this.efecto = efecto;
		}
	}
	
}

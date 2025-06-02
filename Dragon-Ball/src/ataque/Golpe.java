package ataque;

import java.util.ArrayList;

import efectos.Efecto;

public class Golpe extends Ataque{
	private static final String NOMBRE = "Golpe";
	private static final int ENERGIA_REQUERIDA = 0;
	private ArrayList<int[]> danio = new ArrayList<int[]>(); 
	private static Efecto efecto = Efecto.NINGUNO;
	
	public Golpe() {
		super(NOMBRE,ENERGIA_REQUERIDA, efecto);
		int[] danioPrincipal = {250,500,80};
		int[] danioProbable = {501,800,20};
		this.danio.add(danioPrincipal);
		this.danio.add(danioProbable);
		
		super.danio = this.danio;
	}
}

package ataque;

import efectos.Efecto;

public class Kamehameha extends Ataque{
	private static final String NOMBRE = "Kamehameha";
	private static final int ENERGIA_NECESARIA = 7000;
	private static final int PROB_FALLO = 15;
	private static Efecto efecto = Efecto.NINGUNO;
	
	public Kamehameha() {
		super(NOMBRE,ENERGIA_NECESARIA, efecto, PROB_FALLO);
		int[] danioPrincipal = {500,1000,85};
		int[] danioProbable = {1001,1800,100};
		super.danio.add(danioPrincipal);
		super.danio.add(danioProbable);
		
	}
}

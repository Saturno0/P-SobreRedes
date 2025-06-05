package ataque;

import efectos.Efecto;

public class Taioken extends Ataque {
	private static final String NOMBRE = "Taioken";
	private static final int ENERGIA_NECESARIA = 5000;
	private static final int PROB_FALLO = 50;
	private int[] danio = {0,0,50};
	private static Efecto efecto = Efecto.TAIYOKEN; // ciega al oponente entre 1 a 4 turnos
	
	public Taioken() {
		super(NOMBRE, ENERGIA_NECESARIA, efecto, PROB_FALLO);
		super.danio.add(this.danio);
	}
}

package ataque;

import efectos.Efecto;
import efectos.TaiokenEfecto;

public class Taioken extends Ataque {
	private static final String NOMBRE = "Taioken";
	private static final int ENERGIA_NECESARIA = 5000;
	private static final int PROB_FALLO = 50;
	private int[] danio = {0,0,50};
	private static final Efecto EFECTO = new TaiokenEfecto();
	
	public Taioken() {
		super(NOMBRE, ENERGIA_NECESARIA, EFECTO, PROB_FALLO);
		super.danio.add(this.danio);
	}
}

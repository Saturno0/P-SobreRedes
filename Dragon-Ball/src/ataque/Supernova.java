package ataque;

import efectos.Efecto;
import java.util.Arrays;

public class Supernova extends Ataque{
	
	private static final String NOMBRE = "Supernova";
	private static final int ENERGIA_NECESARIA = 10000;
	private static final int PROB_FALLO = 20;
	private static Efecto efecto = Efecto.NINGUNO;
	
	public Supernova() {
		super(NOMBRE,ENERGIA_NECESARIA, efecto, PROB_FALLO);
		int[] danioPrincipal = {400,1200,70};
		int[] danioProbable = {1201,1800,100};
		
		super.danio.addAll(Arrays.asList(
				danioPrincipal,
				danioProbable
		));
	}

}

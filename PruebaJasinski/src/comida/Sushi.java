package comida;

public class Sushi extends Comida{
	private static final int PRECIO = Comidas.SUSHI.getPrecio();
	private static final String NOMBRE = Comidas.SUSHI.getNombre();
	private static final int REDUCCION_HAMBRE = Comidas.SUSHI.getReduccionHambre();
	
	public Sushi() {
		super(NOMBRE, PRECIO, REDUCCION_HAMBRE);
	}

}

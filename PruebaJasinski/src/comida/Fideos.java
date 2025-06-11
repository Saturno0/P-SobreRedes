package comida;

public class Fideos extends Comida{
	private static final int PRECIO = Comidas.FIDEOS.getPrecio();
	private static final String NOMBRE = Comidas.FIDEOS.getNombre();
	private static final int REDUCCION_HAMBRE = Comidas.FIDEOS.getReduccionHambre();
	
	public Fideos() {
		super(NOMBRE, PRECIO, REDUCCION_HAMBRE);
	}

}

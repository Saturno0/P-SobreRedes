package comida;

public class Manzana extends Comida{
	private static final int PRECIO = Comidas.MANZANA.getPrecio();
	private static final String NOMBRE = Comidas.MANZANA.getNombre();
	private static final int REDUCCION_HAMBRE = Comidas.MANZANA.getReduccionHambre();
	
	public Manzana() {
		super(NOMBRE, PRECIO, REDUCCION_HAMBRE);
	}

}

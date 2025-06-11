package estado;

public class Hambre extends Estado{
	private static int valorInicial = 0;
	private static String nombre = "Hambre";
	
	public Hambre() {
		super(nombre,valorInicial);
	}

}

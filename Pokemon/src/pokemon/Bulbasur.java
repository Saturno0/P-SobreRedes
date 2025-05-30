package pokemon;

public class Bulbasur extends Pokemon{
	private String[] nombreAtaques = {"Placaje", "Gruñido" , "Latigo cepa", "Polvo venenoso"};
	private static Tipo tipo = Tipo.PLANTA;
	public Bulbasur() {
		super(78, "Bulbasur", tipo);
		obtenerAtaques(nombreAtaques);
	}
}

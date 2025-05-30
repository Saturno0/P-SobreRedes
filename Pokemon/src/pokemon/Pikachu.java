package pokemon;


public class Pikachu extends Pokemon{
	private String[] nomnbreAtaques = {"latigo", "impactrueno", "gruñido", "onda trueno"};
	private static Tipo tipo = Tipo.ELECTRICO;
	public Pikachu() {
		super(40,"Pikachu", tipo);
		obtenerAtaques(nomnbreAtaques);
	}

	
}

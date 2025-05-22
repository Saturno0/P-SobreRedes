package pokemon;


public class Pikachu extends Pokemon{
	private String[] nomnbreAtaques = {"latigo", "impactrueno", "gruñido", "onda trueno"};
	private Tipo tipo = Tipo.ELECTRICO;
	public Pikachu() {
		super();
		super.vida = 40;
		obtenerAtaques();
	}
	

	private void obtenerAtaques() {
		String[] subAtaques = new String[Ataque.values().length];
		int cantAtaques = 0;
		int[] indexes = new int[this.nomnbreAtaques.length];
		for (int i = 0; i < subAtaques.length; i++) {
			for (int j = 0; j < this.nomnbreAtaques.length; j++) {
				String nombre = Ataque.values()[i].getNombre().toLowerCase();
				if(nombre.equals(this.nomnbreAtaques[j])) {
					indexes[cantAtaques] = i;
					cantAtaques++;
				}
			}
		}
		
		super.ataques = new Ataque[cantAtaques];
		for (int i = 0; i < indexes.length; i++) {
			super.ataques[i] = Ataque.values()[indexes[i]];
		}
	}
	
	public int atacar() {
		System.out.println("Elija que ataque quiere realizar:");
		mostrarAtaques();
		final int INDEX = utiles.Utiles.ingresarEntero(1, super.ataques.length);
		return super.ataques[INDEX].getDaño();
	}
	
	private void mostrarAtaques() {
		for (int i = 0; i < super.ataques.length; i++) {
			System.out.println((i+1) + "- " + super.ataques[i].getNombre() + "\n\t -Daño: " + super.ataques[i].getDaño());
		}
	}


	public String getNombreTipo() {
		return tipo.getNombre();
	}
	
	public String getTipoEfectivo() {
		return tipo.getEfectividad();
	}
}

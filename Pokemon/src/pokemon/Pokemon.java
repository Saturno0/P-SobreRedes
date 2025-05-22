package pokemon;

public abstract class Pokemon {
	protected String nombre;
	public int vida = 100;
	protected Ataque[] ataques = new Ataque[4];
	
	public Ataque[] getAtaques() {
		return ataques;
	}
	
	public int getVida() {
		return vida;
	}
}

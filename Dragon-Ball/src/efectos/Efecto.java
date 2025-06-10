package efectos;

public abstract class Efecto {
	private int turnos;
	
	protected Efecto(int turnos) {
		this.turnos = turnos;
	}
	
	public int getTurnos() {
		return turnos;
	}
	
}

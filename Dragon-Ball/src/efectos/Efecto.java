package efectos;

public enum Efecto {
	TAIYOKEN(4),
	CURACION(1),
	BARRIER(4),
	NINGUNO(0);
	
	
	private int turnos;
	private Efecto(int turnos) {
		this.turnos = turnos;
	}
	
	public int getTurnos() {
		return turnos;
	}
	
}

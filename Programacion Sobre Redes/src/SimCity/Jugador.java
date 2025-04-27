package SimCity;

public class Jugador {
	private String nombre;
	private final int DINERO = 10000000;
	public int dinero = 10000000;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getDINERO() {
		return DINERO;
	}

}

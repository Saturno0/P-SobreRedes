package tipo;

import java.util.ArrayList;

public enum Tipo {
	ELECTRICO("Electrico"),
	FUEGO("Fuego"),
	AGUA("Agua"),
	VENENO("Veneno"),
	PLANTA("Planta"),
	NORMAL("Normal"),
	NINGUNO("");
	
	private Tipo efectividad;
	private ArrayList<Tipo> pocaEfectividad = new ArrayList<Tipo>();
	String nombre;

	static {
		ELECTRICO.efectividad = AGUA;
		FUEGO.efectividad = PLANTA;
		PLANTA.efectividad = AGUA;
		VENENO.efectividad = PLANTA;
		AGUA.efectividad = FUEGO;
		NORMAL.efectividad = NINGUNO;
		
		
		ELECTRICO.pocaEfectividad.add(ELECTRICO);
		ELECTRICO.pocaEfectividad.add(PLANTA);

		FUEGO.pocaEfectividad.add(FUEGO);
		FUEGO.pocaEfectividad.add(AGUA);

		PLANTA.pocaEfectividad.add(FUEGO);
		PLANTA.pocaEfectividad.add(PLANTA);
		PLANTA.pocaEfectividad.add(VENENO);

		VENENO.pocaEfectividad.add(VENENO);

		AGUA.pocaEfectividad.add(AGUA);
		AGUA.pocaEfectividad.add(PLANTA);
		
		NORMAL.pocaEfectividad.add(NINGUNO);
	};
	
	private Tipo(String nombre) {
		this.nombre = nombre;
	}
	
	public ArrayList<Tipo> getPocaEfectividad() {
		return this.pocaEfectividad;
	}
	
	public Tipo getEfectividad() {
		return this.efectividad;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}

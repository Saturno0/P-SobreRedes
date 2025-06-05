package personaje;

public enum Personajes {
	GOKU("Goku base"),
	FREEZER("Freezer base");
	
	
	
	private String nombre;
	Personaje personaje;
	
	private Personajes(String nombre) {
		this.nombre = nombre;
		
	}
	
	public Personaje getPersonaje() {
	    if (this == GOKU) {
	        personaje = new Goku();
	    } else if (this == FREEZER) {
	        personaje = new Freezer();
	    }
	    return personaje;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	
}

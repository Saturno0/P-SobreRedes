package mascota;

public enum Mascotas {
	NIMMO("Nimmo"),
	MECCA("Mecca"),
	KOI("Koi");
	
	private String nombre;
	private Mascotas(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}

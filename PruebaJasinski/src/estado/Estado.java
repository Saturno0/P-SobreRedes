package estado;

public abstract class Estado {
	private final int VALOR_MIN = 0;
	private final int VALOR_MAX = 100;
	private int valor; 
	private String nombre;
	
	public Estado(String nombre, int valor) {
		this.nombre = nombre;
		this.valor = valor;
	}
	
	public void setValor(int valor) {
		if(valor < VALOR_MIN) {
			valor = VALOR_MIN;
		} else if(valor > VALOR_MAX) {
			valor = VALOR_MAX;
		}
		
		this.valor = valor;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getValor() {
		return valor;
	}

}

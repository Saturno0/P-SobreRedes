package SimCity;


import Utilidades.utilidades;

public class Ciudad {
	private String nombre;
	private Jugador alcalde;
	private Edificio[] edificios;
	
	public Ciudad(String nombre, Jugador jugador) {
	 this.nombre = nombre;
	 this.alcalde = jugador;
	}
	
	public Jugador getAlcalde() {
		return alcalde;
	}
	
	public void setEdificios(Edificio[] edificios) {
		this.edificios = edificios;
	}

	public void menu() {
		int opcion = 0;
		int cantEdificios = edificios.length;
		do {
			System.out.println("Elija que quiere hacer:");
			mostrarMenu();
			opcion = utilidades.ingresarEntero(1, 7);
			
			switch (opcion) {
			case 1:
				mostrarDatos();
				break;
			case 2:
				promedioSeguridad(cantEdificios);
				break;
			case 3: 
				promedioPrevencionIncendio(cantEdificios);
				break;
			case 4:
				promedioFelicidad(cantEdificios);
				break;
			case 5:
				mostrarEdificiosCaroBarato(cantEdificios);
				break;
			case 6:
				mostrarDineroGastado();
				break;
			}
		} while (opcion != 7);
		
	}

	private void mostrarDineroGastado() {
		int plataGastada = alcalde.getDINERO() - alcalde.dinero;
		
		System.out.println("Se a invertido un total de $" + plataGastada);
	}

	private void mostrarEdificiosCaroBarato(int cantEdificios) {
		int max = edificios[0].getPrecio();
		int min = edificios[0].getPrecio();
		int index1 = 0, index2 = 0;
		
		for (int i = 0; i < cantEdificios; i++) {
			if(edificios[i].getPrecio() > max) {
				max = edificios[i].getPrecio();
				index1 = i;
			}
			
			if(edificios[i].getPrecio() < min) {
				min = edificios[i].getPrecio();
				index2 = i;
			}
		}
		
		System.out.println("El edificio mas caro de la ciudad es: " + edificios[index1].getNombre() + ", con un precio de " + max);
		System.out.println("El edificio mas barato de la ciudad es: " + edificios[index2].getNombre() + ", con un precio de " + min);
		
	}

	private void promedioFelicidad(int cantEdificios) {
		int total = 0;
		
		for (int i = 0; i < cantEdificios; i++) {
			total += edificios[i].getFelicidad();
		}
		
		int promedio = total / cantEdificios;
		
		System.out.println("El promedio de felicidad es de " + promedio);
	}

	private void promedioPrevencionIncendio(int cantEdificios) {
		int totalPrevIncendio = 0;
		
		for (int i = 0; i < cantEdificios; i++) {
			totalPrevIncendio += edificios[i].getPrevIncendio();
		}
		
		int promedio = totalPrevIncendio / cantEdificios;
		
		System.out.println("El promedio de prevencion de incendios es de " + promedio);
		
	}

	private void promedioSeguridad(int cantEdificios) {
		int totalSeguridad = 0;
		
		for (int i = 0; i < cantEdificios; i++) {
			totalSeguridad += edificios[i].getSeguridad();
		}
		
		int promedioPorcentual = (totalSeguridad / cantEdificios);
		
		System.out.println("El promedio de seguridad es " + promedioPorcentual);
	}

	private void mostrarDatos() {
		// Datos alcalde
		String nombre = alcalde.getNombre();
		int dinero = alcalde.dinero;
		
		System.out.println("Nombre ciudad: " + this.nombre);
		System.out.println("Nombre alcalde: " + nombre + " - Dinero de la ciudad: " + dinero);
		
		System.out.println("Edificios:");
		for (int i = 0; i < edificios.length; i++) {
			//Nombre - Tipo - Seguridad - Prev Incendios - Felicidad - Precio
			String nombreEdificio = edificios[i].getNombre();
			String tipoEdificio = edificios[i].getTipo();
			int seguridadEdificio = edificios[i].getSeguridad();
			int prevIncendioEdificio = edificios[i].getPrevIncendio();
			int felicidadEdificio = edificios[i].getFelicidad();
			int precioEdificio = edificios[i].getPrecio();
			
			System.out.println((i+1) + ") Nombre: " + nombreEdificio + " - Tipo: " + tipoEdificio + " - Prevencion de incendio: " + prevIncendioEdificio +" - Seguridad: " + seguridadEdificio + " - Felicidad: " + felicidadEdificio + " - Precio: " + precioEdificio);
			System.out.println("----------------------------------------------------");
		}
		
	}

	private void mostrarMenu() {
		System.out.println("1) Datos del alcalde, de la ciudad, y lista de edificios publicos comprados.");
		System.out.println("2) Promedio de seguridad de la  ciudad (del 0 al 10)");
		System.out.println("3) Promedio de prevencion de incendios de la ciudad (del 0 al 10)");
		System.out.println("4) Promedio de la felicidad de la gente que vive en la ciudad");
		System.out.println("5) Edificio publico de mayor y menor valor de la ciudad");
		System.out.println("6) Dinero total desenfundado para invertir en la ciudad");
		System.out.println("7) Salir");
	}
}

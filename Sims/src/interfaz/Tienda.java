package interfaz;

import pertenencias.Mueble;
import sim.Jugador;

public class Tienda {
	private String[][] muebles = {{"Silla plegable", "2", "125"}, {"Silla de lana", "3","235"},{"Silla cromada","4","500"},{"Silla de cuero","9","1700"},
			{"Cafetera Molinet","1","85"},{"Cafetera Expresso Otratacetti","3","450"},{"Cafetera Vitalextra","7","1000"},
			{"Heladera LLamark","5","600"},{"Heladera porcina CR-2","8","1200"},{"Heladera hielo secreto","10","2500"},
			{"Ordenador Espectrus","7","999"},{"Microscotch Q628","8","1800"},{"Brahma 2000","9","2800"},{"Soy Marco","10","6500"},
			{"Estereo portatil muchamarcha","4","100"},{"Estereo Hi-Fi Simasonic","6","650"},{"Estereo Teoría la cuerda","10","2250"},
			{"Piano Tintinway","9","3500"},{"Piano Liebefunkenman","10","5400"},{"Guitarra Bejafona","7","580"},{"Guitarra Uber UV","10","2500"},
			{"Cuadro bodegon","5","500"},{"Cuadro clásico","6","800"},{"Cuadro El rincon del gnomo","8","1500"},{"Cuadro impresionista","9","5000"},
			{"Obra de arte","10","10000"}};
	private final int MAX_OBJETOS = 20;
	private final int PRECIO = 2, NOMBRE = 0, FELICIDAD = 1; 
	
	private Mueble[] mueblesComprados = new Mueble[MAX_OBJETOS];
	Jugador sim;
	private int minPrecio = getMinPrecio();
	private int cantMueblesComprados = 0;
	
	public Mueble[] comprar(Mueble[] muebles, Jugador sim, final int MAX_MUEBLES) {
		this.sim = sim;
		boolean seguir = true;
		do {
			System.out.println("Elija que quiere hacer: ");
			System.out.println("1) Comprar mueble");
			System.out.println("2) Salir");
			
			int opc = utilidades.Utiles.ingresarEntero(1, 2);
			switch (opc) {
			case 1:
				if((sim.dinero > minPrecio) || this.cantMueblesComprados == MAX_MUEBLES ) {
					System.out.println("Elija que mueble quiere comprar");
					int index = elegirMueble();
					
					if(sim.dinero >= Integer.valueOf(this.muebles[index][this.PRECIO])) {	
						Mueble mueble = crearMueble(index);
						sim.dinero -= mueble.getPrecio();
						
						this.mueblesComprados[this.cantMueblesComprados] = mueble;
						this.cantMueblesComprados++;
						
					} else {
						System.out.println("No posee el dinero suficiente para comprar este mueble");
					}
				} else {
					System.out.println("No posee el dinero suficiente para comprar ningun mueble mas");
					seguir = false;
				}
				break;

			case 2:
				System.out.println("Nos vemos :)");
				seguir = false;
				break;
			}
		} while (seguir);
		
		muebles = crearMuebles();
		
		return muebles;
	}

	private Mueble[] crearMuebles() {
		Mueble[] muebles;
		muebles = new Mueble[this.cantMueblesComprados];
		
		for (int i = 0; i < this.cantMueblesComprados; i++) {
			muebles[i] = this.mueblesComprados[i];
		}
		return muebles;
	}

	private Mueble crearMueble(final int INDEX) {
		final String NOMBRE = this.muebles[INDEX][this.NOMBRE];
		final int FELICIDAD = Integer.valueOf(this.muebles[INDEX][this.FELICIDAD]);
		final int PRECIO = Integer.valueOf(this.muebles[INDEX][this.PRECIO]);
		
		Mueble mueble = new Mueble(NOMBRE, FELICIDAD, PRECIO);
		return mueble;
	}

	private int elegirMueble() {
		int index = 0;
		System.out.println("Ingrese que mueble quiere comprar");
		mostrarMuebles();
		index = utilidades.Utiles.ingresarEntero(1, this.muebles.length) - 1;
		return index;
	}

	private void mostrarMuebles() {
		for (int i = 0; i < muebles.length; i++) {
			mostrarMueble(i);
		}	
	}

	private void mostrarMueble(int i) {
		final String NOMBRE = this.muebles[i][this.NOMBRE];
		final int FELICIDAD = Integer.valueOf(this.muebles[i][this.FELICIDAD]);
		final int PRECIO = Integer.valueOf(this.muebles[i][this.PRECIO]);
		System.out.println((i+1) + ") " + NOMBRE + " - " + FELICIDAD + " - $" + PRECIO);
	}

	private int getMinPrecio() {
		int precio = Integer.valueOf(this.muebles[0][PRECIO]);
		for (int i = 0; i < muebles.length; i++) {
			int precio2 = Integer.valueOf(this.muebles[i][PRECIO]);
			if(precio > precio2) {
				precio = precio2;
			}
		}
		
		return precio;
	}
}

package SimCity;

import Utilidades.utilidades;

public class Tienda {
	
	private String[][] edificiosEnVenta = 
		{//Nombre - Tipo - Seguridad - Prev Incendios - Felicidad - Precio 
				{"Rascascielos","Maravilla","0","0","10","900000"},
				{"Torre Eiffel","Maravilla","0","0","10","850000"},
				{"Arco del triunfo","Maravilla","0","0","9","700000"},
				{"Pirámide","Maravilla","0","0","9","600000"},
				{"Obelisco","Maravilla","0","0","8","450000"},
				{"Planta de energía eólica","Planta energética","0","0","10","500000"},
				{"Planta de energía solar","Planta energética","0","0","9","400000"},
				{"Planta de energía hidroeléctrica","Planta energética","0","0","8","300000"},
				{"Planta de energía de carbón","Planta energética","0","0","4","150000"},
				{"Empresa de agua corriente","Planta de agua","0","0","10","750000"},
				{"Obras de cañerias para agua potable","Planta de agua","0","0","9","500000"},
				{"Tanques de agua por manzana","Planta de agua","0","10","9","350000"},
				{"Pozos de agua","Planta de agua","0","0","7","200000"},
				{"Mega estación de policía","Seguridad","10","0","10","400000"},
				{"Estación de polocía grande","Seguridad","9","0","9","300000"},
				{"Estación de policía mediana","Seguridad","7","0","5","200000"},
				{"Estación de polocía chica","Seguridad","5","0","2","100000"},
				{"Mega estación de bomberos","Incendios","0","10","10","450000"},
				{"Estación de bomberos grande","Incendios","0","8","8","350000"},
				{"Estación de bomberos mediana","Incendios","0","7","6","250000"},
				{"Estación de bomberos chica","Incendios","0","6","5","150000"},
				{"Rutas","Caminos","0","0","10","400000"},
				{"Autopistas","Caminos","0","0","9","300000"},
				{"Avenidas","Caminos","0","0","8","200000"},
				{"Calles de asfalto","Caminos","0","0","6","150000"},
				{"Calles de tierra","Caminos","0","0","1","50000"},
				{"Reserva natural","Ecología","0","0","10","500000"},
				{"Parque polideportivo","Ecología","0","0","9","300000"},
				{"Parque grande","Ecología","0","0","8","200000"},
				{"Plaza","Ecología","0","0","7","100000"}};
	
	private int cantEdificiosComprados = 0;
	private String[][] edificiosCompradosTemporal = new String[edificiosEnVenta.length][edificiosEnVenta[0].length];
	private Edificio[] edificiosComprados;
	

	public Edificio[] comprarEdificios(Jugador jugador) {
		int opcion = 0;
		boolean salir = false;
		int edificioMasBarato = edificioMasBarato();
		
		do {
			System.out.println("Elija que edificio comprar");
			mostrarEdificios();
			opcion = utilidades.ingresarEntero(1, (edificiosEnVenta.length)) - 1;
			final int PRECIO = Integer.valueOf(edificiosEnVenta[opcion][5]);
			if(!comprobarTipo(opcion)) {
				if(jugador.dinero >= PRECIO) {
					edificiosCompradosTemporal[cantEdificiosComprados++] = edificiosEnVenta[opcion];
					jugador.dinero -= PRECIO; 
					int opc = 0;
					System.out.println("Desea seguir comprando? si(1) no(2)");
					
					opc = utilidades.ingresarEntero(1, 2);
					
					if(opc == 1) {
						if(jugador.dinero < edificioMasBarato) {
							System.out.println("No tiene la plata suficiente para comprar ningun otro edificio");
							salir = true;
						}
					} else {
						salir = true;
					}
				} else {
					System.out.println("Usted no posee la plata suficiente para comprar este edificio");
				}
			} else {
				System.out.println("Ya posee un edificio de este tipo");
			}
		} while (!salir);
		
		edificiosComprados = new Edificio[cantEdificiosComprados];
		
		for (int i = 0; i < cantEdificiosComprados; i++) {
			edificiosComprados[i] = crearEdificio(i);
		}
		
		return edificiosComprados;
	}
	
	private int edificioMasBarato() {
		int min = Integer.valueOf(edificiosEnVenta[0][5]);
		for (int i = 1; i < edificiosEnVenta.length; i++) {
			if(Integer.valueOf(edificiosEnVenta[i][5]) < min) {
				min = Integer.valueOf(edificiosEnVenta[i][5]);
			}
		}
		return min;
	}

	private Edificio crearEdificio(int i) {
		String nombre = edificiosCompradosTemporal[i][0];
		String tipo = edificiosCompradosTemporal[i][1];
		int seguridad = Integer.valueOf(edificiosCompradosTemporal[i][2]);
		int prevIncendios = Integer.valueOf(edificiosCompradosTemporal[i][3]);
		int felicidad = Integer.valueOf(edificiosCompradosTemporal[i][4]);
		int precio = Integer.valueOf(edificiosCompradosTemporal[i][5]);
		
		Edificio edificioComprado = new Edificio(nombre,tipo,seguridad,prevIncendios,felicidad,precio);
		
		return edificioComprado;
	}
	
	
	private boolean comprobarTipo(int opcion) {
		boolean existe = false;
		int i = 0;
		
		while(i < cantEdificiosComprados && !existe) {
			if(!edificiosEnVenta[opcion][1].equals("Maravilla")) {
				if(edificiosEnVenta[opcion][1].equals(edificiosCompradosTemporal[i][1])) {
					existe = true;
				}
			}
			i++;
		}
		return existe;
	}

	private void mostrarEdificios() {
		
		System.out.println("-------------------------------------------");
		for (int i = 0; i < edificiosEnVenta.length; i++) {
			String nombre = edificiosEnVenta[i][0];
			String tipo = edificiosEnVenta[i][1];
			int seguridad = Integer.valueOf(edificiosEnVenta[i][2]);
			int prevIncendios = Integer.valueOf(edificiosEnVenta[i][3]);
			int felicidad = Integer.valueOf(edificiosEnVenta[i][4]);
			int precio = Integer.valueOf(edificiosEnVenta[i][5]);
			System.out.println((i+1) + ") Nombre: " + nombre + " - Tipo: " + tipo + " - Seguridad: " + seguridad +  " - Prevencion de incendio: " + prevIncendios + " - Felicidad: " + felicidad + " - Precio: " + precio);
			System.out.println("----------------------------------------------------------------");
		}
		
	}
	
	public int getCantEdificiosComprados() {
		return cantEdificiosComprados;
	}
	

}

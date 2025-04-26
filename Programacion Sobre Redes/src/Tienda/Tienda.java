package Tienda;

import Artilugios.Arma;
import Artilugios.ElementoArmadura;
import Jugador.Jugador;
import Utilidades.utilidades;

public class Tienda {
	//Tipo - Nombre - Precio - Cuantos ptos de vida agrega - Disminuye velocidad
	private String[][] armadurasEnVenta = {
			{"Casco","Casco de cuero","500","5","0"},
			{"Casco","Casco de bronce","800","10","2"},
			{"Casco","Casco de plata","1000","15","2"},
			{"Casco","Casco de oro","1200","20","1"},
			{"Casco","Casco de platino","1500","25","0"},
			{"Casco","Casco de diamante","1800","30","0"},
			{"Peto","Peto de cuero","700","10","0"},
			{"Peto","Peto de bronce","1200","15","3"},
			{"Peto","Peto de plata","1500","25","3"},
			{"Peto","Peto de oro","1800","30","2"},
			{"Peto","Peto de platino","2000","35","1"},
			{"Peto","Peto de diamante","2500","50","0"},
			{"Grebas","Grebas de cuero","600","5","1"},
			{"Grebas","Grebas de bronce","1300","10","2"},
			{"Grebas","Grebas de plata","1500","20","3"},
			{"Grebas","Grebas de oro","1800","30","2"},
			{"Grebas","Grebas de platino","2000","35","1"},
			{"Grebas","Grebas de diamante","2500","40","0"},
			{"Botas","Botas de cuero","400","5","0"},
			{"Botas","Botas de bronce","600","5","2"},
			{"Botas","Botas de plata","800","5","1"},
			{"Botas","Botas de oro","1500","5","0"},
			{"Botas","Botas de platino","2000","5","0"},
			{"Botas","Botas de diamante","2200","5","0"}
	};

	//Nombre - daño - velocidad de ataque - precio
	private String[][] armasEnVenta = {
			{"Daga filosa","3","10","500"},
			{"Daga Dorada","5","12","1500"},
			{"Daga prohibida","10","20","2500"},
			{"Espada de madera","5","18","800"},
			{"Espada de piedra","15","10","1500"},
			{"Espada de tantalio","20","25","2800"},
			{"Espada de grafito","20","30","3200"},
			{"Maza de piedra","20","8","800"},
			{"Maza de hierro","25","10","1300"},
			{"Maza de platino","35","15","2200"},
			{"Maza de materia oscura","50","18","4500"},
			{"Arco liviano","5","20","700"},
			{"Arco preciso","8","15","1000"},
			{"Arco de diamante","10","20","2000"},
			{"Arco encantado","15","18","2200"},
			{"Hacha vieja","15","10","1200"},
			{"Hacha pesada","25","12","1800"},
			{"Hacha Vikinga","35","15","2400"}
	};
	
	public void comprar(Jugador jugador) {
		System.out.println("Vienvenido a la tienda " + jugador.getNombre());
		int opcion = 0;
		do {
			System.out.println("Tienes $" + jugador.getDinero());
			System.out.println("1) Comprar armadura");
			System.out.println("2) Comprar arma");
			System.out.println("3) Salir");
			
			opcion = utilidades.ingresarEntero(1, 3);

			switch (opcion) {
				case 1:
					comprarArmadura(jugador);
					break;
				case 2:
					comprarArma(jugador);
					break;
				case 3:
					System.out.println("Gracias por visitar la tienda.");
					break;
			}
		} while (opcion != 3);
	}

	private void comprarArma(Jugador jugador) {
		System.out.println("Bienvenido a la tienda de armas, a continuacion vera las variadas armas que puede comprar");
		for(int i = 0; i < armasEnVenta.length; i++) {
			mostrarArma(i);
		}
		System.out.println("0) Salir");
		
		int opcion = utilidades.ingresarEntero(0, armasEnVenta.length);
		
		if(opcion == 0) {
			return;
		}
		
		opcion -= 1;
		String[] arma = armasEnVenta[opcion];
		if(jugador.getDinero() >= Integer.valueOf(arma[3])) {
			if(jugador.getArma() == null) {
				String nombre = arma[0];
				int danio = Integer.valueOf(arma[1]);
				int velAtaque = Integer.valueOf(arma[2]);
				int precio = Integer.valueOf(arma[3]);
				Arma armaComprada = new Arma(nombre,danio,velAtaque,precio);
				
				jugador.comprarArma(armaComprada);
				System.out.println("Has comprado " + nombre);
				System.out.println("Te quedan $" + jugador.getDinero());
			}
			
		}
		
	}

	private void mostrarArma(int i) {
		System.out.println((i+1) + ". Arma: " + armasEnVenta[i][0] + " - Danio: " + armasEnVenta[i][1] + " - Velocidad de ataque: " + armasEnVenta[i][2] + " - Precio: " + armasEnVenta[i][3]);

	}

	private void comprarArmadura(Jugador jugador) {
		System.out.println("Bienvenido a la tineda de armaduras, a continuacion vera las armaduras que puede comprar");
		for (int i = 0; i < armadurasEnVenta.length; i++) {
			mostrarArmadura(i);
		}
		System.out.println("0) Salir");
		int opcion = utilidades.ingresarEntero(0, armadurasEnVenta.length);
		
		if (opcion == 0) {
			return;
		}
		
		opcion -= 1;
		
		if(jugador.getDinero() >= Integer.valueOf(armadurasEnVenta[opcion][2])) {
			boolean existeParte = jugador.comprovarExistenciaTipo(armadurasEnVenta[opcion][0]);
			
			if(existeParte) {
				System.out.println("Ya posees una parte de la armadura de este tipo (" + armadurasEnVenta[opcion][0] + ")");
				
			} else {
				String[] armadura = armadurasEnVenta[opcion];
				String tipo = armadura[0];
				String nombre = armadura[1];
				int precio = Integer.valueOf(armadura[2]);
				int vidaExtra = Integer.valueOf(armadura[3]);
				int velAtaque = Integer.valueOf(armadura[4]);
				
				ElementoArmadura parteComprada = new ElementoArmadura(tipo,nombre,precio,vidaExtra,velAtaque);
				jugador.comprarParte(parteComprada);
				System.out.println("Has comprado " + nombre);
				System.out.println("Te queda $" + jugador.getDinero());
				
			}
		} else {
			System.out.println("Usted no posee suficiente dinero para comprar esta parte");
		}
	}

	private void mostrarArmadura(int i) {
        System.out.println((i + 1) + ". " + armadurasEnVenta[i][1] + " - Precio: " + armadurasEnVenta[i][2] + " - Vida agregada: " + armadurasEnVenta[i][3] + " - Disminuye velocidad de ataque: " + armadurasEnVenta[i][4]);
    }
	
	
}

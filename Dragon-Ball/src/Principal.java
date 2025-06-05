import personaje.*;
import utiles.Utiles;

public class Principal {

	public static void main(String[] args) {
		System.out.println("Elija su personaje");
		
		for (int i = 0; i < Personajes.values().length; i++) {
			System.out.println((i+1) + ") " + Personajes.values()[i].getNombre());
		}
		
		int opc = Utiles.ingresarEntero(1, Personajes.values().length) - 1;
		Personaje jugador = Personajes.values()[opc].getPersonaje();
		Personaje contrario;
		if(opc == 1) {
			contrario = Personajes.values()[0].getPersonaje();
		} else {
			contrario = Personajes.values()[1].getPersonaje();
		}
		
		Jugar(jugador, contrario);
		
	}

	private static void Jugar(Personaje jugador, Personaje contrario) {
		boolean terminado = false;
		int turno = 0;
		do {
			int danio;
			if(turno == 0) {
				danio = jugador.atacar(turno);
				contrario.recibirDaño(danio);
				System.out.println("----------------------------------------------");
				jugador.mostrarDatos();
				System.out.println("Vida del enemigo: " + contrario.getVida());
				turno = 1;
			} else if (turno == 1) {
				danio = contrario.atacar(turno);
				jugador.recibirDaño(danio);
				System.out.println("----------------------------------------------");
				contrario.mostrarDatos();
				System.out.println("Tu vida: " + jugador.getVida());
				turno = 0;
			}
			
			if((jugador.getVida() <= 0) || (contrario.getVida() <= 0)) {
				terminado = true;
			}
		} while(!terminado);
		
		if(turno == 1) {
			System.out.println("Has ganado!!");
		} else if(turno == 0) {
			System.out.println("Has perdido :(");
		}
		
	}

}

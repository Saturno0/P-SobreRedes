import Entrenador.Contrario;
import Entrenador.Jugador;
import pokemon.Pokemon;

public class Principal {

    public static void main(String[] args) {
        System.out.println("Bienvenido al juego de Pokémon");
        System.out.println("Ingrese su nombre");
        Jugador jugador = crearJugador();
        Contrario contrario = new Contrario();

        System.out.println("Estarás jugando contra " + contrario.getNombre());
        System.out.println("Tus pokémones son:");
        
        Pokemon[] pokemonesJugador = jugador.getPokemones();
        Pokemon[] pokemonesContrario = contrario.getPokemones();

        for (Pokemon p : pokemonesJugador) {
            System.out.println("Nombre: " + p.getNombre());
        }

        System.out.println("Los pokémones del oponente son:");
        for (Pokemon p : pokemonesContrario) {
            System.out.println("Nombre: " + p.getNombre());
        }

        boolean termino = false;
        int vidasJ = pokemonesJugador.length;
        int vidasC = pokemonesContrario.length;
        int turno = 1;

        do {
            int indexJ = pokemonesJugador.length - vidasJ;
            int indexC = pokemonesContrario.length - vidasC;

            Pokemon pokemonJ = pokemonesJugador[indexJ];
            Pokemon pokemonC = pokemonesContrario[indexC];

            if (turno == 1) {
                System.out.println("\nTurno de " + jugador.getNombre());
                pokemonJ.mostrarDatos();
                int danio = pokemonJ.atacar(turno);
                pokemonC.vida -= danio;
                if (pokemonC.vida < 0) pokemonC.vida = 0;
                System.out.println("Vida restante del oponente: " + pokemonC.vida);
                turno = 1;
            } else {
                System.out.println("\nTurno de " + contrario.getNombre());
                int danio = pokemonC.atacar(turno);
                pokemonJ.vida -= danio;
                if (pokemonJ.vida < 0) pokemonJ.vida = 0;
                System.out.println("Tu pokémon tiene ahora: " + pokemonJ.vida + " de vida.");
                turno = 0;
            }

            // Verificar si algún Pokémon fue derrotado
            if (pokemonJ.vida <= 0) {
                vidasJ--;
                if (vidasJ == 0) {
                    termino = true;
                    System.out.println("¡Todos tus pokémon han sido derrotados!");
                } else {
                    System.out.println("¡Tu pokémon ha sido derrotado! Cambiando al siguiente...");
                }
            }

            if (pokemonC.vida <= 0) {
                vidasC--;
                if (vidasC == 0) {
                    termino = true;
                    System.out.println("¡Has derrotado a todos los pokémon del rival!");
                } else {
                    System.out.println("¡Has derrotado al pokémon del rival! Entra el siguiente...");
                }
            }

            System.out.println("--------------------------------------");

        } while (!termino);

        // Mensaje de victoria o derrota
        System.out.println(turno == 1 ? "\n¡Has ganado!" : "\nHas perdido :(");
    }

    private static Jugador crearJugador() {
        String nombre = utiles.Utiles.s.nextLine();
        return new Jugador(nombre);
    }
}

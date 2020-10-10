package proyectoLoveLetter;

public class ControladorDeJugada {
	
	public static Carta repartirCarta(Mazo mazo, Jugador jugador) {
		
	}
	
	public static void descartarCarta() {
		
	}
	
	public static void eliminarJugador(Jugador jugador) {
		//clavarle un null a la posicion del array de jugadoresActuales
		//ellos hicieron sacarJugador, pero deberia hacerlo el controlador
		//basicamente es su codigo, sin el jugadoresRendidos
	}
	
	public static void activarEfecto(Jugador jugador, Carta carta)	{
		carta.efecto(jugador);
	}

	public static void desactivarEfecto() {
		
	}

}

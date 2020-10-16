package cartas;

import juego.ControladorDeJugada;
import juego.Jugador;

public class Rey extends Carta {

	public Rey() {
		super(CrearCarta.REY);
	}

	public void efecto(Jugador esteJugador) {
		Jugador otroJugador = ControladorDeJugada.seleccionarJugador(false);
		efectoInterno(esteJugador, otroJugador);
	}

	private void efectoInterno(Jugador esteJugador, Jugador otroJugador) {
		Carta manoIntercambio = esteJugador.getMano().get(0);
		esteJugador.getMano().remove(0);
		esteJugador.agregarCartaAMano(otroJugador.getMano().get(0));
		otroJugador.getMano().remove(0);
		otroJugador.agregarCartaAMano(manoIntercambio);
		System.out.println("Manos intercambiadas");
	}
	
	public void getEfectoInternoPrueba(Jugador esteJugador, Jugador otroJugador) {
		efectoInterno(esteJugador, otroJugador);
	}
}
package juego;

import java.util.LinkedList;
import java.util.Scanner;

public class Partida {
	private int puntosParaGanar;
	private LinkedList<Jugador> jugadores;
	private int idPartida;
	public static Scanner sc;

	public Partida(LinkedList<Jugador> jugadores, int puntosParaGanar) {
		sc = new Scanner(System.in);
		if (jugadores.size() >= 2 && jugadores.size() <= 4) {
			this.jugadores = jugadores;
			this.puntosParaGanar = puntosParaGanar;
		} else {
			this.jugadores = null;
			this.puntosParaGanar = 0;
			System.out.println("No se pudo crear la partida con " + jugadores.size() + " jugador/es.");
		}
	}

	public Jugador jugarPartida() {
		Jugador ganadorDePartida = null, ganadorDeRonda;
		while (jugadores.size() != 1 && ganadorDePartida == null) {
			ganadorDeRonda = jugarRonda();
			limpiarJugadores();
			ganadorDeRonda.sumarPunto();
			ganadorDePartida = hayGanador();
		}

		sc.close();
		return finalizarPartida(ganadorDePartida);
	}

	private void limpiarJugadores() {
		for (Jugador jugadorActual : jugadores)
			jugadorActual.limpiarDatos();
	}

	public void limpiarJugadoresPrueba() {
		limpiarJugadores();
	}

	private Jugador finalizarPartida(Jugador ganadorDePartida) {
		if (ganadorDePartida != null)
			return ganadorDePartida;

		return jugadores.getFirst();
	}

	public Jugador finalizarPartidaPrueba(Jugador ganadorDePartida) {
		return finalizarPartida(ganadorDePartida);
	}

	private Jugador hayGanador() {
		for (Jugador jugActual : jugadores)
			if (jugActual.getPuntos() == puntosParaGanar)
				return jugActual;

		return null;
	}

	public Jugador jugarRonda() {
		Jugador ganadorDeRonda;
		Ronda rondaActual = new Ronda(this);
		ganadorDeRonda = rondaActual.jugar();
		return ganadorDeRonda;
	}

	public LinkedList<Jugador> getJugadores() {
		return this.jugadores;
	}

	public void sacarJugador(Jugador jugador) {
		jugadores.remove(jugador);
	}

	public int getIdPartida() {
		return idPartida;
	}

//	// METODO AGREGADO
//	public void jugarRondaPruebaV1() {
//		Jugador ganadorDeRonda;
//		Ronda rondaActual = new Ronda(this);
//		ganadorDeRonda = rondaActual.jugarPruebaV1();
//		ganadorDeRonda.sumarPunto();
//	}
//
//	// METODO AGREGADO
//	public void jugarRondaPruebaV2() {
//		Jugador ganadorDeRonda;
//		Ronda rondaActual = new Ronda(this);
//		ganadorDeRonda = rondaActual.jugarPruebaV2();
//		ganadorDeRonda.sumarPunto();
//	}
//
//	// METODO AGREGADO
//	public void jugarRondaPruebaV3() {
//		Jugador ganadorDeRonda;
//		Ronda rondaActual = new Ronda(this);
//		ganadorDeRonda = rondaActual.jugarPruebaV3();
//		ganadorDeRonda.sumarPunto();
//	}
//
//	// METODO AGREGADO
//	public void jugarRondaPruebaV4() {
//		Jugador ganadorDeRonda;
//		Ronda rondaActual = new Ronda(this);
//		ganadorDeRonda = rondaActual.jugarPruebaV4();
//		ganadorDeRonda.sumarPunto();
//	}

	public Jugador hayGanadorDePrueba() {
		return hayGanador();
	}
}

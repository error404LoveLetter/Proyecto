package proyectoLoveLetter;

import java.util.LinkedList;
import java.util.Scanner;

public class Partida {
	private int puntosParaGanar;
	private LinkedList<Jugador> jugadores;
//	LinkedList<Jugador> jugadoresRendidos = new LinkedList<>();
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
			System.out.println("No se pudo crear la partida con " + jugadores.size() + "jugador/es.");
		}
	}

	public Jugador jugarPartida() {
		Jugador ganadorDePartida = null;
		while (jugadores.size() != 1 && ganadorDePartida == null) {
			jugarRonda();
			ganadorDePartida = hayGanador();
		}

		sc.close();
		if (ganadorDePartida != null)
			return ganadorDePartida;

		return jugadores.getFirst();
	}

	public Jugador hayGanador() {
		for (Jugador jugActual : jugadores)
			if (jugActual.getPuntos() == puntosParaGanar)
				return jugActual;

		return null;
	}

	public Jugador hayGanadorDePrueba() {
		return hayGanador();
	}

	public void jugarRonda() {
		Jugador ganadorDeRonda;
		Ronda rondaActual = new Ronda(this);
		ganadorDeRonda = rondaActual.jugar();
		ganadorDeRonda.sumarPunto();
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
}

package proyecto;

import java.util.LinkedList;

public class Ronda {

	Partida datosPartida;
	Mazo mazo;
	LinkedList<Jugador> jugadoresDeRonda;

	public Ronda(Partida partida) {
		this.datosPartida = partida;
		this.mazo = new Mazo();
		iniciarRonda();
	}

	private void iniciarRonda() {
		mazo.mezclar();
		ponerCartaBocaAbajo();
		jugadoresDeRonda = datosPartida.jugadores;
		for (Jugador jugador : datosPartida.jugadores) {
			ControladorDeJugada.repartirCarta(mazo, jugador);
		}
		turno(determinarSiguienteJugador());
	}

	private void turno(Jugador jugador) {
		jugador.setTurno(1);
		ControladorDeJugada.repartirCarta(mazo, jugador);
	}

	private void finTurno(Jugador jugador) {
		jugador.setTurno(0);
		turno(determinarSiguienteJugador());
	}

	public Jugador determinarSiguienteJugador() {
		if(jugadoresDeRonda.size()==1)//Tambien deberia preguntar si el mazo esta vacio
			finalizarRonda();
		Jugador jugadorActual;
		jugadorActual = datosPartida.jugadores.getFirst();
		datosPartida.jugadores.remove();
		datosPartida.jugadores.add(jugadorActual);
		return jugadorActual;

	}

	public void finalizarRonda() {
		Jugador ganador = jugadoresDeRonda.getFirst();
		for (Jugador jugador : jugadoresDeRonda) {
			if (ganador.mano[0].valor < jugador.mano[0].valor)
				ganador = jugador;
			else if (ganador.mano[0].valor == jugador.mano[0].valor)
				if (ganador.getCantidadDescartadas() < jugador.getCantidadDescartadas())
					ganador = jugador;
		}
		System.out.println(ganador);
		ganador.sumarPunto();
	}
	
	public void jugadorSeRinde(Jugador jugador)
	{
		sacarJugadorDeRonda(jugador);
		datosPartida.sacarJugador(jugador);
	}

	public void sacarJugadorDeRonda(Jugador jugadorASacar) {
		jugadoresDeRonda.remove(jugadorASacar);
	}
	
	private void ponerCartaBocaAbajo() {
		System.out.println(mazo.sacarDePila());
	}

}

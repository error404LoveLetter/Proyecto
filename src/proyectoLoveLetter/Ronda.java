package proyectoLoveLetter;

import java.util.LinkedList;

public class Ronda {

	Partida datosPartida;
	Mazo mazo;
	LinkedList<Jugador> jugadoresDeRonda;
	Carta cartaBocaAbajo;
	
	public Ronda(Partida partida) {
		this.datosPartida = partida;
		this.mazo = new Mazo(); // CREA Y MEZCLA EL MAZO
		Jugador.setRondaActual(this);
		
		for(Jugador jugador : datosPartida.getJugadores())
			jugadoresDeRonda.add(jugador);
	}

	public Ronda(LinkedList<Jugador> jugadoresDePrueba, Mazo mazoDePrueba) {
		datosPartida = null;
		mazo = mazoDePrueba;
		jugadoresDeRonda = jugadoresDePrueba;
		Jugador.setRondaActual(this);
	}

	public Jugador jugar() {
		Jugador jugadorActual;

		ponerCartaBocaAbajo();
		
		for (Jugador jugador : jugadoresDeRonda)  
			jugador.agregarCartaAMano(mazo.sacarDePila());
			

		while (jugadoresDeRonda.size() != 1 && mazo.isMazoVacio() == false) {
			jugadorActual = determinarSiguienteJugador();
			turno(jugadorActual);
			finTurno(jugadorActual);
		}
		return finalizarRonda();
	}

	private void turno(Jugador jugadorActual) {
		jugadorActual.setTurno(true);
		System.out.println("Es el turno del jugador " + jugadorActual.getNombre());
		jugadorActual.agregarCartaAMano(mazo.sacarDePila());
		jugadorActual.jugarCarta(); // DEVUELVE UNA CARTA
	}

	public void finTurno(Jugador jugador) {
		jugador.setTurno(false);
	}

	public Jugador determinarSiguienteJugador() {
		Jugador jugadorActual;
		jugadorActual = jugadoresDeRonda.getFirst();
		jugadoresDeRonda.removeFirst();
		jugadoresDeRonda.add(jugadorActual);
		return jugadorActual;
	}

	public Jugador finalizarRonda() {
		Jugador ganador = jugadoresDeRonda.getFirst();

		if (jugadoresDeRonda.size() != 1) {
			for (Jugador jugador : jugadoresDeRonda) {

				if (jugador.getMano().get(0).getFuerza() > ganador.getMano().get(0).getFuerza())
					ganador = jugador;
				else if (ganador.getMano().get(0).getFuerza() == jugador.getMano().get(0).getFuerza()
						&& jugador.getCantidadDeCartasDescartadas() > ganador.getCantidadDeCartasDescartadas())
					ganador = jugador;

			}
		}
		System.out.println(ganador);
		return ganador;
	}
	
	private void ponerCartaBocaAbajo() {
		cartaBocaAbajo = this.mazo.sacarDePila();
	}

	public void jugadorSeRinde(Jugador jugadorRendido) {
		sacarJugadorDeRonda(jugadorRendido);
		datosPartida.sacarJugador(jugadorRendido);
	}

	public void sacarJugadorDeRonda(Jugador jugadorASacar) {
		jugadoresDeRonda.remove(jugadorASacar);
	}

	public LinkedList<Jugador> getJugadoresDeRonda() {
		return this.jugadoresDeRonda;
	}

	public Mazo getMazo() {
		return mazo;
	}

	public Carta getCartaBocaAbajo() {
		return cartaBocaAbajo;
	}
	
	public void jugarDePrueba() {
		ponerCartaBocaAbajo();
	}

	public void setCartaBocaAbajo(Carta carta)//SOLO PARA TESTS
	{
		this.cartaBocaAbajo=carta;
	}

}

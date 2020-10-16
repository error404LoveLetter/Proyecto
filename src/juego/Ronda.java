package juego;

import java.util.LinkedList;

import cartas.Carta;

public class Ronda {

	private Partida datosPartida;
	private Mazo mazo;
	private LinkedList<Jugador> jugadoresDeRonda = new LinkedList<Jugador>();
	private Carta cartaBocaAbajo;

	public Ronda(Partida partida) {
		this.datosPartida = partida;
		this.mazo = new Mazo(); // CREA Y MEZCLA EL MAZO
		Jugador.setRondaActual(this);

		for (Jugador jugador : datosPartida.getJugadores())
			jugadoresDeRonda.add(jugador);
	}

	public Ronda(LinkedList<Jugador> jugadoresDePrueba, Mazo mazoDePrueba) {
		datosPartida = null;
		mazo = mazoDePrueba;
		jugadoresDeRonda = jugadoresDePrueba;
		Jugador.setRondaActual(this);
	}

	public Jugador jugar() {
		ponerCartaBocaAbajo();
		repartirCartasIniciales();
		cicloDeTurnos();
		
		return finalizarRonda();
	}

	private void repartirCartasIniciales() {
		for (Jugador jugador : jugadoresDeRonda)
			jugador.agregarCartaAMano(mazo.sacarDePila());
	}
	
	public void repartirCartasInicialesPrueba()
	{
		repartirCartasIniciales();
	}
	
	private void cicloDeTurnos() {
		Jugador jugadorActual;
		
		while (jugadoresDeRonda.size() != 1 && mazo.isMazoVacio() == false) {
			jugadorActual = determinarSigJugador();
			turno(jugadorActual);
			finTurno(jugadorActual);
		}
	}
	
	public void cicloDeTurnosPrueba()
	{
		cicloDeTurnos();
	}

	private void turno(Jugador jugadorActual) {
		jugadorActual.setTurno(true);
		jugadorActual.setEstaProtegido(false);
		System.out.println("Es el turno del jugador " + jugadorActual.getNombre());
		jugadorActual.agregarCartaAMano(mazo.sacarDePila());
		jugadorActual.jugarCarta(); // DEVUELVE UNA CARTA
	}

	public void finTurno(Jugador jugador) {
		jugador.setTurno(false);
	}

	public Jugador determinarSigJugador() {
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
		jugadoresDeRonda.clear();
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

	public void setCartaBocaAbajo(Carta carta)// SOLO PARA TESTS
	{
		this.cartaBocaAbajo = carta;
	}

	// METODO AGREGADO
	private void turnoSinJugarCarta(Jugador jugadorActual) {
		jugadorActual.setTurno(true);
		System.out.println("Es el turno del jugador " + jugadorActual.getNombre());
		jugadorActual.agregarCartaAMano(mazo.sacarDePila());
	}

	// METODO AGREGADO
//	public String asignarTurnoAJugadorPrueba(Jugador jugadorActual) {
//		jugadorActual.setTurno(true);
//		System.out.println("Es el turno del jugador " + jugadorActual.getNombre());
//		return null;
//	}

	// METODO AGREGADO
	public Jugador jugarPruebaV1() {
		ponerCartaBocaAbajo();
		this.jugadoresDeRonda = datosPartida.getJugadores();
		for (Jugador jugador : datosPartida.getJugadores()) {
			jugador.agregarCartaAMano(mazo.sacarDePila());
		}

		return finalizarRonda();
	}

	// METODO AGREGADO
	public Jugador jugarPruebaV2() {
		Jugador jugadorActual;

		ponerCartaBocaAbajo();
		this.jugadoresDeRonda = datosPartida.getJugadores();
		for (Jugador jugador : datosPartida.getJugadores()) {
			jugador.agregarCartaAMano(mazo.sacarDePila());
		}

		jugadorActual = determinarSigJugador();
		turnoSinJugarCarta(jugadorActual);
		finTurno(jugadorActual);

		return finalizarRonda();
	}

	// METODO AGREGADO
	public Jugador jugarPruebaV3() {
		Jugador jugadorActual;

		ponerCartaBocaAbajo();
		this.jugadoresDeRonda = datosPartida.getJugadores();
		for (Jugador jugador : datosPartida.getJugadores()) {
			jugador.agregarCartaAMano(mazo.sacarDePila());
		}

		for (int i = 0; i < this.jugadoresDeRonda.size(); i++) { // 1 PASADA
			jugadorActual = determinarSigJugador();
			turnoSinJugarCarta(jugadorActual);
			// System.out.println("Jugador: " + i + "Turno: " + jugadorActual.isTurno());
			finTurno(jugadorActual);
		}

		return finalizarRonda();
	}

	// METODO AGREGADO
	public Jugador jugarPruebaV4() {
		Jugador jugadorActual;

		ponerCartaBocaAbajo();
		this.jugadoresDeRonda = datosPartida.getJugadores();
		for (Jugador jugador : datosPartida.getJugadores()) {
			jugador.agregarCartaAMano(mazo.sacarDePila());
		}

		int pasadas = 0;

		while (pasadas < 30) {
			for (int i = 0; i < this.jugadoresDeRonda.size(); i++) { // 1 PASADA
				jugadorActual = determinarSigJugador();
				turnoV4(jugadorActual);
				finTurno(jugadorActual);
			}
			pasadas++;
		}

		return finalizarRonda();
	}
	
	private void turnoV4(Jugador jugadorActual) {
		jugadorActual.setTurno(true);
		System.out.println("Es el turno del jugador " + jugadorActual.getNombre());
		}

	public void jugarDePrueba() {
		ponerCartaBocaAbajo();
	}
	
}

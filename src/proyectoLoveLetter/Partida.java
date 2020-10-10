package proyecto;

import java.util.LinkedList;

public class Partida {
	int winCond;
	LinkedList<Jugador> jugadores = new LinkedList<>();
	LinkedList<Jugador> jugadoresRendidos = new LinkedList<>();
	int idPartida;
	
	public Jugador jugarRonda()
	{
		Ronda ronda=new Ronda(this);
		return jugadores.getFirst();
		//Nesesitamos saver el ganador de la ronda para seguir instanciando nuevas rondas.
	}
	
	public LinkedList<Jugador> getJugadores()
	{
		return this.jugadores;
	}
	
	public void sacarJugador(Jugador jugador)
	{
		jugadores.remove(jugador);
		jugadoresRendidos.add(jugador);
	}

	public Partida(LinkedList<Jugador> jugadores) {
		super();
		this.jugadores = jugadores;
	}
	

}


package cartas;

import juego.ControladorDeJugada;
import juego.Jugador;

public class Princesa extends Carta{
	
	public Princesa()
	{
		super(CrearCarta.PRINCESA);
	}
	
	public void efecto(Jugador esteJugador)
	{
		System.out.println("Has dejado a la princesa...");
		ControladorDeJugada.eliminarJugadorDeRonda(esteJugador);
	}
}

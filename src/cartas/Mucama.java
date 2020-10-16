package cartas;

import juego.Jugador;

public class Mucama extends Carta{
	
	public Mucama()
	{
		super(CrearCarta.MUCAMA);
	}
	
	public void efecto(Jugador esteJugador)
	{
		System.out.println("El jugador tiene inmunidad por un turno");
		esteJugador.setEstaProtegido(true);
	}
}
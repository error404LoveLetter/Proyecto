package cartas;

import juego.ControladorDeJugada;
import juego.Jugador;

public class Sacerdote extends Carta{
	
	public Sacerdote()
	{
		super(CrearCarta.SACERDOTE);
	}
	
	public void efecto(Jugador esteJugador)
	{
		Jugador otroJugador = ControladorDeJugada.seleccionarJugador(false);
		efectoInterno(otroJugador);
	}
	
	private String efectoInterno(Jugador otroJugador)
	{
		return "Carta del otro jugador: " + otroJugador.getMano().get(0).getNombre();
	}
	
	public String getEfectoInternoPrueba(Jugador otroJugador)
	{
		return efectoInterno(otroJugador);
	}
}
package proyectoLoveLetter;

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

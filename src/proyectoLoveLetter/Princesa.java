package proyectoLoveLetter;

public class Princesa extends Carta{
	
	public Princesa(String nombre, int fuerza, String descripcion)
	{
		super(nombre,fuerza,descripcion);
	}
	
	public void efecto(Jugador esteJugador)
	{
		System.out.println("Has dejado a la princesa...");
		ControladorDeJugada.eliminarJugador(esteJugador);
	}
}

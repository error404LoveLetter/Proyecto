package proyectoLoveLetter;

public class Mucama extends Carta{
	
	public Mucama(String nombre, int fuerza, String descripcion)
	{
		super(nombre,fuerza,descripcion);
	}
	
	public void efecto(Jugador esteJugador)
	{
		System.out.println("El jugador tiene inmunidad por un turno");
		esteJugador.setEstaProtegido(true);
	}
}
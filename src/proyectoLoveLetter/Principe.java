package proyectoLoveLetter;

public class Principe extends Carta{
	
	public Principe(String nombre, int fuerza, String descripcion)
	{
		super(nombre,fuerza,descripcion);
	}
	
	public void efecto(Jugador j)
	{
		Jugador otroJugador = ControladorDeJugada.SeleccionarJugador(true);
		otroJugador.descartarMano();
	}
}

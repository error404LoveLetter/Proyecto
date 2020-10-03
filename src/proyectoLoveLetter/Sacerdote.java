package proyectoLoveLetter;

public class Sacerdote extends Carta{
	
	public Sacerdote(String nombre, int fuerza, String descripcion)
	{
		super(nombre,fuerza,descripcion);
	}
	
	public void efecto(Jugador esteJugador)
	{
		Jugador otroJugador = ControladorDeJugada.SeleccionarJugador(false);
		System.out.println("Carta del otro jugador: " + otroJugador.getMano()[0].getNombre());
	}
}
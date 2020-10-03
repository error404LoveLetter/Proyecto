package proyectoLoveLetter;

public class Rey extends Carta{
	
	public Rey(String nombre, int fuerza, String descripcion)
	{
		super(nombre,fuerza,descripcion);
	}
	
	public void efecto(Jugador esteJugador)
	{
		Jugador otroJugador = ControladorDeJugada.SeleccionarJugador(false);
		Carta[] manoIntercambio = esteJugador.getMano();
		esteJugador.setMano(otroJugador.getMano());
		otroJugador.setMano(manoIntercambio);
		System.out.println("Manos intercambiadas");
	}
}
package proyectoLoveLetter;

public class Baron extends Carta{
	
	public Baron(String nombre, int fuerza, String descripcion)
	{
		super(nombre,fuerza,descripcion);
	}
	
	public void efecto(Jugador esteJugador)
	{
		Jugador otroJugador = ControladorDeJugada.SeleccionarJugador(false);
		System.out.println("Carta del otro jugador: " + otroJugador.getMano()[0].getNombre() + "Fuerza = " + otroJugador.getMano()[0].getFuerza() + '\n' +
							"Tu carta: " + esteJugador.getMano()[0].getNombre() + "Fuerza = " + esteJugador.getMano()[0].getFuerza());
		
		if(esteJugador.getMano()[0].getFuerza()>=otroJugador.getMano()[0].getFuerza()) //Elegimos que ante igualdad gane el jugador llamador
			ControladorDeJugada.eliminarJugador(otroJugador);
		else
			ControladorDeJugada.eliminarJugador(esteJugador);
	}
}

package proyectoLoveLetter;

public class Baron extends Carta {

	public Baron() {
		super(CrearCarta.BARON);
	}

	public void efecto(Jugador esteJugador) {
		Jugador otroJugador = ControladorDeJugada.seleccionarJugador(false);
		efectoInterno(esteJugador, otroJugador);
	}

	private void efectoInterno(Jugador esteJugador, Jugador otroJugador) {
		System.out.println("Carta del otro jugador: " + otroJugador.getMano().get(0).getNombre() + ", con Fuerza = "
				+ otroJugador.getMano().get(0).getFuerza() + '\n' + "Tu carta: " + esteJugador.getMano().get(0).getNombre()
				+ ", con Fuerza = " + esteJugador.getMano().get(0).getFuerza());
		if (esteJugador.getMano().get(0).getFuerza() >= otroJugador.getMano().get(0).getFuerza()) // Elegimos que ante igualdad gane
																					// el jugador llamador
			ControladorDeJugada.eliminarJugadorDeRonda(otroJugador);
		else
			ControladorDeJugada.eliminarJugadorDeRonda(esteJugador);
	}
	
	public void getEfectoInternoPrueba(Jugador esteJugador, Jugador otroJugador) {
		efectoInterno(esteJugador, otroJugador);
	}
}

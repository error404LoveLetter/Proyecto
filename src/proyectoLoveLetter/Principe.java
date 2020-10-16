package proyectoLoveLetter;

public class Principe extends Carta {

	public Principe() {
		super(CrearCarta.PRINCIPE);
	}

	public void efecto(Jugador esteJugador) {
		Jugador otroJugador = ControladorDeJugada.seleccionarJugador(true);
		efectoInterno(otroJugador);
	}

	public void efectoInterno(Jugador otroJugador) {
		otroJugador.descartarMano();
		if(Jugador.getRondaActual().getMazo().isMazoVacio() == false)
			otroJugador.agregarCartaAMano(Jugador.getRondaActual().getMazo().sacarDePila());
		else
			otroJugador.agregarCartaAMano(Jugador.getRondaActual().getCartaBocaAbajo());
	}
	
	public void getEfectoInternoPrueba(Jugador otroJugador) {
		efectoInterno(otroJugador);
	}
}

package proyectoLoveLetter;

public class Rey extends Carta {

	public Rey() {
		super(CrearCarta.REY);
	}

	public void efecto(Jugador esteJugador) {
		Jugador otroJugador = ControladorDeJugada.seleccionarJugador(false);
		efectoInterno(esteJugador, otroJugador);
	}

	public void efectoInterno(Jugador esteJugador, Jugador otroJugador) {
		Carta manoIntercambio = esteJugador.getMano().get(0);
		esteJugador.setMano(otroJugador.getMano().get(0));
		otroJugador.setMano(manoIntercambio);
		System.out.println("Manos intercambiadas");
	}
	
	public void getEfectoInternoPrueba(Jugador esteJugador, Jugador otroJugador) {
		efectoInterno(esteJugador, otroJugador);
	}
}
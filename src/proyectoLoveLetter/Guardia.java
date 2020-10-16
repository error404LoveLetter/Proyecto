package proyectoLoveLetter;

public class Guardia extends Carta {

	public Guardia() {
		super(CrearCarta.GUARDIA);
	}

	public void efecto(Jugador esteJugador) {
		int opcionElegida;
		Jugador otroJugador = ControladorDeJugada.seleccionarJugador(false);
		opcionElegida = ControladorDeJugada.seleccionarCarta();
		efectoInterno(esteJugador, otroJugador, opcionElegida);
	}

	private void efectoInterno(Jugador esteJugador, Jugador otroJugador, int cartaElegida) {
		if(otroJugador.getMano().get(0).getNombre() == Carta.nombres[cartaElegida-1]) {
			System.out.println("La carta seleccionada era la correcta " + otroJugador.getNombre() + " ha sido eliminado");
			ControladorDeJugada.eliminarJugadorDeRonda(otroJugador);
			}
		else
			System.out.println("La carta seleccionada no era la correcta");
	}
	
	public void getEfectoInternoPrueba(Jugador esteJugador, Jugador otroJugador, int cartaElegida) {
		efectoInterno(esteJugador,otroJugador,cartaElegida);
	}
}

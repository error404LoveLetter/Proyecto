package juego;

import java.util.LinkedList;

public final class ControladorDeJugada {

	public static int seleccionarCarta() {
		int opcionElegida;
		do {
			System.out.println("Elija una carta:" + "1-Guardia\n" + "2-Sacerdote\n" + "3-Baron\n" + "4-Mucama\n"
					+ "5-Principe\n" + "6-Rey\n" + "7-Condesa\n" + "8-Princesa");
			opcionElegida = Integer.parseInt(Partida.sc.nextLine());
		} while (opcionElegida < 1 || opcionElegida > 8);
		return opcionElegida - 1;
	}

	public static Jugador seleccionarJugador(boolean hayAutoseleccion) {
		Jugador jugadorElegido = null;
		LinkedList<Jugador> jugadoresValidos = depurarSeleccionDeJugadores(hayAutoseleccion);
		int numJugadorElegido,
			cantidadDeJugValidos = jugadoresValidos.size();
		
		if(cantidadDeJugValidos == 1)
			jugadorElegido = jugadoresValidos.getFirst();
		else if(cantidadDeJugValidos >= 2)
		{
			int i;
			for (i = 0; i < jugadoresValidos.size(); i++)
				System.out.println("Elegir Jugador (" + (i + 1) + "): " + jugadoresValidos.get(i));
			do {
				System.out.println("ELIJA A UN JUGADOR (" + 1 + " a " + i + "): ");
				numJugadorElegido = Integer.parseInt(Partida.sc.nextLine());
			} while (numJugadorElegido < 1 || numJugadorElegido > i);
			
			jugadorElegido = jugadoresValidos.get(numJugadorElegido - 1);
		}
		
		return jugadorElegido;
	}
	
	private static LinkedList<Jugador> depurarSeleccionDeJugadores(boolean hayAutoseleccion)
	{
		Ronda rondaActual = Jugador.getRondaActual();
		LinkedList<Jugador> jugadoresValidos = rondaActual.getJugadoresDeRonda();
		for (int i = 1; i < jugadoresValidos.size(); i++)
			if(jugadoresValidos.get(i).isEstaProtegido()==true)
				jugadoresValidos.remove(i);
		
		if (!hayAutoseleccion)
			jugadoresValidos.removeFirst();
		
		return jugadoresValidos;
	}

	public static void eliminarJugadorDeRonda(Jugador jugadorLlamador) {
		Jugador.getRondaActual().sacarJugadorDeRonda(jugadorLlamador);
	}

}

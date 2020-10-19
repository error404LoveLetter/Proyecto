package pruebas;

import juego.Mazo;

public class App {
	
	public static void main(String[] args) {
//		LinkedList <Jugador> jugadores = new LinkedList<Jugador>();
//		Carta guardia = new Guardia();
//		Carta baron = new Baron();
//		Jugador j1 = new Jugador(1, "Carlos"), 
//				j2 = new Jugador(2, "Diego");
//		jugadores.add(j1);
//		jugadores.add(j2);
		/*Ronda r = new Ronda(p);
		
		j1.agregarCartaAMano(guardia);
		j2.agregarCartaAMano(baron);
		j1.jugarCarta();*/
//		Partida p = new Partida(jugadores,2);
//		System.out.println("El ganador es: " + p.jugarPartida());
		Mazo mazo = new Mazo();
		while(mazo.isMazoVacio() == false)
			System.out.println(mazo.sacarDePila());
	}
}

package pruebas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import cartas.Carta;
import cartas.CrearCarta;
import cartas.Guardia;
import cartas.Princesa;
import cartas.Rey;
import juego.ControladorDeJugada;
import juego.Jugador;
import juego.Mazo;
import juego.Partida;
import juego.Ronda;

public class PruebaDeJuego {

	Jugador j1, j2, j3, j4;

	@Before
	public void setUp() {
		j1 = new Jugador(1, "Lucas");
		j2 = new Jugador(2, "Agustin");
		j3 = new Jugador(3, "Matias");
		j4 = new Jugador(4, "Axel");
	}
		
	@Test
	public void caso01SeleccionaBienCuandoQuedanUnJugadorElegible() {
		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);

		@SuppressWarnings("unused")
		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, null);
		assertEquals(j2, ControladorDeJugada.seleccionarJugador(false));
	}

	@Test
	public void caso02SeleccionaBienCuandoQuedanUnJugadorElegibleXProteccion() {
		j3.setEstaProtegido(true);

		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);
		jugadoresDePrueba.add(j3);

		@SuppressWarnings("unused")
		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, null);
		assertEquals(j2, ControladorDeJugada.seleccionarJugador(false));
	}

	@Test
	public void caso03AutoseleccionaBienCuandoQuedaUnJugadorXProteccion() {
		j2.setEstaProtegido(true);

		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);

		@SuppressWarnings("unused")
		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, null);
		assertEquals(j1, ControladorDeJugada.seleccionarJugador(true));
	}

	@Test
	public void caso04DevuelveNuloSiNoHayJugadoresParaSeleccionar() {
		j2.setEstaProtegido(true);

		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);

		@SuppressWarnings("unused")
		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, null);
		assertEquals(null, ControladorDeJugada.seleccionarJugador(false));
	}

	@Test
	public void caso05JugadorGanaLaRondaXCartasDescartadas() {
		Mazo mazoDePrueba = new Mazo();

		Jugador jugadorAuxiliar1 = new Jugador("Juan", false, true, 0, 4);
		Jugador jugadorAuxiliar2 = new Jugador("Juan2", false, false, 0, 5);

		jugadorAuxiliar1.agregarCartaAMano(new Guardia());
		jugadorAuxiliar2.agregarCartaAMano(new Guardia());

		mazoDePrueba.setMazoVacio(true);

		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(jugadorAuxiliar1);
		jugadoresDePrueba.add(jugadorAuxiliar2);

		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, mazoDePrueba);
		assertEquals(jugadorAuxiliar2, rondaDePrueba.finalizarRonda());
	}

	@Test
	public void caso06ElMazoCreaBienLasCartas() {
		Mazo mazo = new Mazo();

		LinkedList<Carta> listaDeCartas = new LinkedList<Carta>();
		int vectorDeOcurrencias[] = new int[8];

		while (mazo.isMazoVacio() == false)
			listaDeCartas.add(mazo.sacarDePila());

		for (Carta carta : listaDeCartas)
			vectorDeOcurrencias[carta.getFuerza() - 1]++;

		assertEquals(5, vectorDeOcurrencias[CrearCarta.GUARDIA.ordinal()]);
		assertEquals(2, vectorDeOcurrencias[CrearCarta.SACERDOTE.ordinal()]);
		assertEquals(2, vectorDeOcurrencias[CrearCarta.BARON.ordinal()]);
		assertEquals(2, vectorDeOcurrencias[CrearCarta.MUCAMA.ordinal()]);
		assertEquals(2, vectorDeOcurrencias[CrearCarta.PRINCIPE.ordinal()]);
		assertEquals(1, vectorDeOcurrencias[CrearCarta.REY.ordinal()]);
		assertEquals(1, vectorDeOcurrencias[CrearCarta.CONDESA.ordinal()]);
		assertEquals(1, vectorDeOcurrencias[CrearCarta.PRINCESA.ordinal()]);
	}

	@Test
	public void caso07NoSePuedeCrearMasDeCuatroJugadores() {
		Jugador j5 = new Jugador(5, "Lorena");

		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);
		jugadoresDePrueba.add(j3);
		jugadoresDePrueba.add(j4);
		jugadoresDePrueba.add(j5);

		Partida partidaDePrueba = new Partida(jugadoresDePrueba, 5);

		LinkedList<Jugador> jugadoresDePruebaAuxiliar = new LinkedList<Jugador>();
		jugadoresDePruebaAuxiliar = partidaDePrueba.getJugadores();

		assertNull(jugadoresDePruebaAuxiliar);
	}

	@Test
	public void caso08CreaBienLaPartida() {
		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);
		jugadoresDePrueba.add(j3);
		jugadoresDePrueba.add(j4);

		Partida partida1 = new Partida(jugadoresDePrueba, 3);

		LinkedList<Jugador> copia = new LinkedList<Jugador>();

		copia = partida1.getJugadores();

		String jugadoresEnListaCopia = "";

		for (Jugador jugador : copia) {
			jugadoresEnListaCopia += jugador.getNombre() + " ";
		}

		assertEquals("Lucas Agustin Matias Axel ", jugadoresEnListaCopia);
	}

	@Test
	public void caso09NoSePuedeCrearMenosDeDosJugadores() {
		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);

		Partida partidaDePrueba = new Partida(jugadoresDePrueba, 5);

		LinkedList<Jugador> jugadoresDePruebaAuxiliar = new LinkedList<Jugador>();
		jugadoresDePruebaAuxiliar = partidaDePrueba.getJugadores();

		assertNull(jugadoresDePruebaAuxiliar);
	}

	@Test
	public void caso10FinalizaBienLaRondaPorMazoVacio() {
		j1.agregarCartaAMano(new Princesa());
		j2.agregarCartaAMano(new Rey());

		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);

		Mazo mazo = new Mazo();
		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, mazo);

		mazo.setMazoVacio(true);
		Jugador jugadorGanador = rondaDePrueba.finalizarRonda();

		assertEquals("Lucas", jugadorGanador.getNombre());

	}

	@Test
	public void caso11FinalizaBienLaRondaPorUnicoJugador() {
		j1.agregarCartaAMano(new Guardia());

		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);

		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, null);

		Jugador jugadorGanador = rondaDePrueba.finalizarRonda();

		assertEquals("Lucas", jugadorGanador.getNombre());
	}

	@Test
	public void caso12FinalizaBienLaPartidaPorAfectosConseguidos() {
		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);

		j2.sumarPunto();

		Partida partidaDePrueba = new Partida(jugadoresDePrueba, 1);
		Jugador jugadorGanador = partidaDePrueba.hayGanadorDePrueba();

		assertEquals("Agustin", jugadorGanador.getNombre());
	}

	@Test
	public void caso13FinalizaBienLaPartidaPorAbandono() {
		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);

		Partida partidaDePrueba = new Partida(jugadoresDePrueba, 3);

		partidaDePrueba.sacarJugador(j1);
		Jugador jugadorGanador = partidaDePrueba.jugarPartida();

		assertEquals("Agustin", jugadorGanador.getNombre());
	}

	@Test
	public void caso14IniciaLaRondaSacandoUnaCartaAlAzar() {
		Mazo mazo = new Mazo();
		int contador = 0;
		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);

		LinkedList<Carta> listaDeCartas = new LinkedList<Carta>();
		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, mazo);

		rondaDePrueba.jugarDePrueba();

		while (mazo.isMazoVacio() == false) {
			listaDeCartas.add(mazo.sacarDePila());
			contador++;
		}

		assertEquals(15, contador);
	}

	
	@Test
	public void caso15ReparteBienLasCartasAlIniciarLaRonda() {
		LinkedList <Jugador> jugadoresDePrueba= new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);
		jugadoresDePrueba.add(j3);
		jugadoresDePrueba.add(j4);

		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba,new Mazo());
		rondaDePrueba.repartirCartasInicialesPrueba();
		
		assertEquals(1, j1.getMano().size()); 
		assertEquals(1, j2.getMano().size()); 
		assertEquals(1, j3.getMano().size()); 
		assertEquals(1, j4.getMano().size()); 
		
	}
	
	@Test
	public void caso16JugadorPuedeRobarCartasDelMazo() {
		
		LinkedList <Jugador> jugadoresDePrueba= new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);
		
		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba,new Mazo());
		rondaDePrueba.repartirCartasInicialesPrueba();
		rondaDePrueba.darTurnoPrueba(j1);
		
		assertEquals(2, j1.getMano().size());	
	}
	
	@Test
	public void caso17CadaJugadorPuedaRobarCartasDelMazoEn1Pasada() {
		
		LinkedList <Jugador> jugadoresDePrueba= new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);
		
		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba,new Mazo());
		rondaDePrueba.repartirCartasInicialesPrueba();
		
		for(int i = 0; i<jugadoresDePrueba.size(); i++)
			rondaDePrueba.darTurnoPrueba(jugadoresDePrueba.get(i));
		
		assertEquals(2, j1.getMano().size()); 
		assertEquals(2, j2.getMano().size()); 
	}

//	FALTA!!!
//	@Test
//	public void queCorrenBienLosTurnos() {
//		LinkedList <Jugador> jugadoresDePrueba= new LinkedList<Jugador>();
//		jugadoresDePrueba.add(j1);
//		jugadoresDePrueba.add(j2);
//		jugadoresDePrueba.add(j3);
//		jugadoresDePrueba.add(j4);
//		
//		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, new Mazo());
//		
//		for (Jugador jugador : rondaDePrueba.getJugadoresDeRonda()) {
//			jugador.agregarCartaAMano(rondaDePrueba.getMazo().sacarDePila());
//		}
//		
//		int cantidadDePasadas = 30;
//		
//		
//		for(int i = 0; i<cantidadDePasadas; i++)
//			for(Jugador jugadorActual: rondaDePrueba.getJugadoresDeRonda()) {
//				jugadorActual = rondaDePrueba.determinarSiguienteJugador();
//				
////				turnoV4(jugadorActual);
////				finTurno(jugadorActual);
//			}
//		
//		}
//		
////		rondaDePrueba.finalizarRonda();
//	}

//	
//	@Test
//	public void queElGanadorDeRondaSumaUnSimboloDeAfecto() {
//		j1.agregarCartaAMano(new Guardia());
//		j2.agregarCartaAMano(new Princesa());
//		
//		LinkedList <Jugador> jugadoresDePrueba= new LinkedList<Jugador>();
//		jugadoresDePrueba.add(j1);
//		jugadoresDePrueba.add(j2);
//
//		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, null);
//		
//		assertEquals(0, j1.getPuntos());
//		Jugador jugadorGanador = rondaDePrueba.finalizarRonda();
//		
//		assertEquals(1, jugadorGanador.getPuntos());
//		//no funciona porque finalizar ronda no aumenta puntos, pq lama al scanner de jugarRonda
//		
//	}
}

package proyectoLoveLetter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class Pruebas {

	// ESTO DEBERIA HACERSE EN UN @Before
	Jugador j1 = new Jugador(1, "Lucas");
	Jugador j2 = new Jugador(2, "Agustin");
	Jugador j3 = new Jugador(3, "Matias");
	Jugador j4 = new Jugador(4, "Axel");

	@Test
	public void caso01GuardiaSeleccionaLaCartaIncorrecta() {

		j1.setMano(new Guardia());
		j1.agregarCartaAMano(new Baron());
		j2.setMano(new Condesa());

		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);

		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, null);
		Guardia guardiaPrueba = new Guardia();
		
		guardiaPrueba.getEfectoInternoPrueba(j1, j2, 6);

		assertEquals(2, rondaDePrueba.getJugadoresDeRonda().size());
		assertEquals("Lucas", rondaDePrueba.getJugadoresDeRonda().getFirst().getNombre());
	}

	@Test
	public void caso02GuardiaSeleccionaLaCartaCorrecta() {

		j1.setMano(new Guardia());
		j1.agregarCartaAMano(new Baron());
		j2.setMano(new Condesa());

		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);

		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, null);
		
		Guardia guardiaPrueba = new Guardia();
		guardiaPrueba.getEfectoInternoPrueba(j1, j2, 7);

		assertEquals(1, rondaDePrueba.getJugadoresDeRonda().size());
	}

	@Test
	public void caso03ReyEfecto() {
		j1.setMano(new Baron());
		j2.setMano(new Condesa());

		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);

		new Rey().efectoInterno(j1, j2);

		assertEquals("Condesa", j1.getMano().get(0).getNombre());
		assertEquals("Baron", j2.getMano().get(0).getNombre());
	}

	@Test
	public void caso04PrincipeJugadorDescartaCarta() {
		j1.setMano(new Baron());
		j2.setMano(new Condesa());

		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);

		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, null);
		rondaDePrueba.mazo = new Mazo();
		Jugador.setRondaActual(rondaDePrueba);
		new Principe().efectoInterno(j2);

		assertEquals(1, j2.getCantidadDeCartasDescartadas());
	}

	@Test
	public void caso05PrincipeJugadorCartaBocaAbajo() {
		j1.setMano(new Baron());
		j2.setMano(new Condesa());

		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);

		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, null);
		rondaDePrueba.mazo = new Mazo();
		rondaDePrueba.mazo.setMazoVacio(true);
		rondaDePrueba.setCartaBocaAbajo(new Rey());
		Jugador.setRondaActual(rondaDePrueba);
		new Principe().efectoInterno(j1);

		assertEquals(1, j1.getCantidadDeCartasDescartadas());
		assertEquals("Rey", j1.getMano().get(0).getNombre());
	}

	@Test
	public void caso06MucamaProtege() {
		j1.setMano(new Baron());

		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		new Mucama().efecto(j1);

		assertEquals(true, j1.isEstaProtegido());
	}

	@Test
	public void caso07CondesaConPrincipePrimero() {
		j1.agregarCartaAMano(new Principe());
		j1.agregarCartaAMano(new Condesa());
		j2.setMano(new Guardia());
		
		assertEquals(j1.getMano().indexOf(new Condesa()) + 1, j1.elegirCartaPrueba());
	}
	
	@Test
	public void caso07CondesaConReyPrimero() {
		j1.agregarCartaAMano(new Rey());
		j1.agregarCartaAMano(new Condesa());
		j2.setMano(new Guardia());
		
		assertEquals(j1.getMano().indexOf(new Condesa()) + 1, j1.elegirCartaPrueba());
	}
	
	@Test
	public void caso07CondesaConPrincipeSegundo() {
		j1.agregarCartaAMano(new Condesa());
		j1.agregarCartaAMano(new Principe());
		j2.setMano(new Guardia());
		
		assertEquals(j1.getMano().indexOf(new Condesa()) + 1, j1.elegirCartaPrueba());
	}
	
	@Test
	public void caso07CondesaConReySegundo() {
		j1.agregarCartaAMano(new Condesa());
		j1.agregarCartaAMano(new Rey());
		j2.setMano(new Guardia());
		
		assertEquals(j1.getMano().indexOf(new Condesa()) + 1, j1.elegirCartaPrueba());
	}

	@Test
	public void caso08Princesa() { 
		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		j1.agregarCartaAMano(new Princesa());
		j2.agregarCartaAMano(new Guardia());
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);
		
		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, null);
		j1.getMano().get(0).efecto(j1);
		assertEquals(1,rondaDePrueba.getJugadoresDeRonda().size());
	}

	@Test
	public void caso09Sacerdote() {
		j1.agregarCartaAMano(new Baron());
		Sacerdote sacerdotePrueba = new Sacerdote();
		
		assertEquals("Carta del otro jugador: Baron",sacerdotePrueba.getEfectoInternoPrueba(j1));
	}

	@Test
	public void caso10BaronGana() {
		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		j1.agregarCartaAMano(new Sacerdote());
		j2.agregarCartaAMano(new Guardia());
		
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);
		
		Baron baronPrueba = new Baron();
		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, null);
		baronPrueba.getEfectoInternoPrueba(j1, j2);
		assertFalse(rondaDePrueba.getJugadoresDeRonda().contains(j2));
	}

	@Test
	public void caso10BaronPierde() {
		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		j1.agregarCartaAMano(new Sacerdote());
		j2.agregarCartaAMano(new Princesa());
	
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);
		
		Baron baronPrueba = new Baron();
		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, null);
		baronPrueba.getEfectoInternoPrueba(j1, j2);
		assertFalse(rondaDePrueba.getJugadoresDeRonda().contains(j1));
	}
	
	@Test
	public void caso10BaronEmpate() {
		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		j1.agregarCartaAMano(new Sacerdote());
		j2.agregarCartaAMano(new Sacerdote());
	
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);
		
		Baron baronPrueba = new Baron();
		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, null);
		baronPrueba.getEfectoInternoPrueba(j1, j2);
		assertFalse(rondaDePrueba.getJugadoresDeRonda().contains(j2));
	}	
	
	@Test
	public void SeleccionaBienCuandoQuedanUnJugadorElegible() {
		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);

		@SuppressWarnings("unused")
		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, null);
		assertEquals(j2, ControladorDeJugada.seleccionarJugador(false));
	}

	@Test
	public void SeleccionaBienCuandoQuedanUnJugadorElegibleXProteccion() {
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
	public void AutoseleccionaBienCuandoQuedaUnJugadorXProteccion() {
		j2.setEstaProtegido(true);

		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);

		@SuppressWarnings("unused")
		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, null);
		assertEquals(j1, ControladorDeJugada.seleccionarJugador(true));
	}

	@Test
	public void DevuelveNuloSiNoHayJugadoresParaSeleccionar() {
		j2.setEstaProtegido(true);

		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);

		@SuppressWarnings("unused")
		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, null);
		assertEquals(null, ControladorDeJugada.seleccionarJugador(false));
	}

	@Test
	public void JugadorGanaLaRondaXCartasDescartadas() {
		Mazo mazoDePrueba = new Mazo();

		Jugador jugadorAuxiliar1 = new Jugador("Juan", false, true, 0, 4);
		Jugador jugadorAuxiliar2 = new Jugador("Juan2", false, false, 0, 5);

		jugadorAuxiliar1.setMano(new Guardia());
		jugadorAuxiliar2.setMano(new Guardia());

		mazoDePrueba.setMazoVacio(true);

		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(jugadorAuxiliar1);
		jugadoresDePrueba.add(jugadorAuxiliar2);

		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, mazoDePrueba);
		assertEquals(jugadorAuxiliar2, rondaDePrueba.finalizarRonda());
	}

	@Test
	public void queElMazoCreaBienLasCartas() {
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
	public void queNoSePuedeCrearMasDeCuatroJugadores() {
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
	public void queCreaBienLaPartida() {
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
	public void queNoSePuedeCrearMenosDeDosJugadores() {
		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);

		Partida partidaDePrueba = new Partida(jugadoresDePrueba, 5);

		LinkedList<Jugador> jugadoresDePruebaAuxiliar = new LinkedList<Jugador>();
		jugadoresDePruebaAuxiliar = partidaDePrueba.getJugadores();

		assertNull(jugadoresDePruebaAuxiliar);
	}

	@Test
	public void queFinalizaBienLaRondaPorMazoVacio() {
		j1.setMano(new Princesa());
		j2.setMano(new Rey());

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
	public void queFinalizaBienLaRondaPorUnicoJugador() {
		j1.setMano(new Guardia());

		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);

		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, null);

		Jugador jugadorGanador = rondaDePrueba.finalizarRonda();

		assertEquals("Lucas", jugadorGanador.getNombre());
	}

	@Test
	public void queFinalizaBienLaPartidaPorAfectosConseguidos() {
		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);

		j2.sumarPunto();

		Partida partidaDePrueba = new Partida(jugadoresDePrueba, 1);
		Jugador jugadorGanador = partidaDePrueba.hayGanador();

		assertEquals("Agustin", jugadorGanador.getNombre());
	}

	@Test
	public void queFinalizaBienLaPartidaPorAbandono() {
		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);

		Partida partidaDePrueba = new Partida(jugadoresDePrueba, 3);

		partidaDePrueba.sacarJugador(j1);
		Jugador jugadorGanador = partidaDePrueba.jugarPartida();

		assertEquals("Agustin", jugadorGanador.getNombre());
	}

	@Test
	public void queIniciaLaRondaSacandoUnaCartaAlAzar() {
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

//	@Test
//	public void queReparteBienLasCartasAlIniciarLaRonda() {
//		
//		
//		
//	}
//	
//	@Test
//	public void queJugadorPuedeRobarCartasDelMazo() {
//		
//		
//		
//	}
//	
//	@Test
//	public void queJugadorPuedeElegirQueCartaTirar() {
//		
//		
//		
//	}
//	
//	@Test
//	public void queElEfectoActivadoPorLaCartaEsCorrecto() {
//		
//		
//		
//	}
//	
//	@Test
//	public void queCorrenBienLosTurnos() {
//		
//		
//		
//	}
//	
//	@Test
//	public void queFinalizaBienLaRondaSinEmpate() {
//		
//		
//		
//	}
//	
//	@Test
//	public void queFinalizaBienLaRondaConEmpate() {
//		
//		
//		
//	}
//	
//	@Test
//	public void queElGanadorDeRondaSumaUnSimboloDeAfecto() {
//
//		j1.setMano(new Guardia());
//		j2.setMano(new Princesa());
//		
//		LinkedList <Jugador> jugadoresDePrueba= new LinkedList<Jugador>();
//		jugadoresDePrueba.add(j1);
//		jugadoresDePrueba.add(j2);
//
//		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, null);
//		
//		assertEquals(0, j1.getPuntos());
//		
//		new Guardia().efectoInterno(j1, j2, 8);
//		Jugador jugadorGanador = rondaDePrueba.finalizarRonda();
//		
//		
//		
//		assertEquals(1, jugadorGanador.getPuntos());
//		//no funciona porque finalizar ronda no aumenta puntos, pq lama al scanner de jugarRonda
//		
//	}
}

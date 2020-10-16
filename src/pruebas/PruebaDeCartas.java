package pruebas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import cartas.Baron;
import cartas.Condesa;
import cartas.Guardia;
import cartas.Mucama;
import cartas.Princesa;
import cartas.Principe;
import cartas.Rey;
import cartas.Sacerdote;
import juego.Jugador;
import juego.Mazo;
import juego.Ronda;

public class PruebaDeCartas {

	Jugador j1, j2, j3, j4;

	@Before
	public void setUp() {
		j1 = new Jugador(1, "Lucas");
		j2 = new Jugador(2, "Agustin");
		j3 = new Jugador(3, "Matias");
		j4 = new Jugador(4, "Axel");
	}

	@Test
	public void caso01GuardiaSeleccionaLaCartaIncorrecta() {

		j1.agregarCartaAMano(new Guardia());
		j1.agregarCartaAMano(new Baron());
		j2.agregarCartaAMano(new Condesa());

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

		j1.agregarCartaAMano(new Guardia());
		j1.agregarCartaAMano(new Baron());
		j2.agregarCartaAMano(new Condesa());

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
		j1.agregarCartaAMano(new Baron());
		j2.agregarCartaAMano(new Condesa());

		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);

		new Rey().getEfectoInternoPrueba(j1, j2);

		assertEquals("Condesa", j1.getMano().get(0).getNombre());
		assertEquals("Baron", j2.getMano().get(0).getNombre());
	}

	@Test
	public void caso04PrincipeJugadorDescartaCarta() {
		j1.agregarCartaAMano(new Baron());
		j2.agregarCartaAMano(new Condesa());

		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);

		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, new Mazo());
		Jugador.setRondaActual(rondaDePrueba);
		new Principe().getEfectoInternoPrueba(j2);

		assertEquals(1, j2.getCantidadDeCartasDescartadas());
	}

	@Test
	public void caso05PrincipeJugadorCartaBocaAbajo() {
		j1.agregarCartaAMano(new Baron());
		j2.agregarCartaAMano(new Condesa());

		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);

		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, new Mazo());

		rondaDePrueba.getMazo().setMazoVacio(true);
		rondaDePrueba.setCartaBocaAbajo(new Rey());
		Jugador.setRondaActual(rondaDePrueba);
		new Principe().getEfectoInternoPrueba(j1);

		assertEquals(1, j1.getCantidadDeCartasDescartadas());
		assertEquals("Rey", j1.getMano().get(0).getNombre());
	}

	@Test
	public void caso06MucamaProtege() {
		j1.agregarCartaAMano(new Baron());

		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		jugadoresDePrueba.add(j1);
		new Mucama().efecto(j1);

		assertEquals(true, j1.isEstaProtegido());
	}

	@Test
	public void caso07CondesaConPrincipePrimero() {
		j1.agregarCartaAMano(new Principe());
		j1.agregarCartaAMano(new Condesa());
		j2.agregarCartaAMano(new Guardia());

		assertEquals(j1.getMano().indexOf(new Condesa()) + 1, j1.elegirCartaDeManoPrueba());
	}

	@Test
	public void caso08CondesaConReyPrimero() {
		j1.agregarCartaAMano(new Rey());
		j1.agregarCartaAMano(new Condesa());
		j2.agregarCartaAMano(new Guardia());

		assertEquals(j1.getMano().indexOf(new Condesa()) + 1, j1.elegirCartaDeManoPrueba());
	}

	@Test
	public void caso09CondesaConPrincipeSegundo() {
		j1.agregarCartaAMano(new Condesa());
		j1.agregarCartaAMano(new Principe());
		j2.agregarCartaAMano(new Guardia());

		assertEquals(j1.getMano().indexOf(new Condesa()) + 1, j1.elegirCartaDeManoPrueba());
	}

	@Test
	public void caso10CondesaConReySegundo() {
		j1.agregarCartaAMano(new Condesa());
		j1.agregarCartaAMano(new Rey());
		j2.agregarCartaAMano(new Guardia());

		assertEquals(j1.getMano().indexOf(new Condesa()) + 1, j1.elegirCartaDeManoPrueba());
	}

	@Test
	public void caso11Princesa() {
		LinkedList<Jugador> jugadoresDePrueba = new LinkedList<Jugador>();
		j1.agregarCartaAMano(new Princesa());
		j2.agregarCartaAMano(new Guardia());
		jugadoresDePrueba.add(j1);
		jugadoresDePrueba.add(j2);

		Ronda rondaDePrueba = new Ronda(jugadoresDePrueba, null);
		j1.getMano().get(0).efecto(j1);
		assertEquals(1, rondaDePrueba.getJugadoresDeRonda().size());
	}

	@Test
	public void caso12Sacerdote() {
		j1.agregarCartaAMano(new Baron());
		Sacerdote sacerdotePrueba = new Sacerdote();

		assertEquals("Carta del otro jugador: Baron", sacerdotePrueba.getEfectoInternoPrueba(j1));
	}

	@Test
	public void caso13BaronGana() {
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
	public void caso14BaronPierde() {
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
	public void caso15BaronEmpate() {
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

}

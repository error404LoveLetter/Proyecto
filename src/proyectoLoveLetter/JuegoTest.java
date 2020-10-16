package proyectoLoveLetter;

import static org.junit.Assert.*;

import java.util.LinkedList;
//import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class JuegoTest {
	
	private LinkedList<Jugador> jugadores;
	
	@Before
	public void setUp() {
		jugadores = new LinkedList<Jugador>();

		jugadores.add(new Jugador(1 , "Agustin"));
		jugadores.add(new Jugador(2 , "Lucas"));
		jugadores.add(new Jugador(3 , "Axel"));
		jugadores.add(new Jugador(4 , "Leandro"));
	}

	@Test
	public void queCreaBienLaPartida() {
		
		Partida partida1 = new Partida(jugadores , 3);
		
		LinkedList<Jugador> copia = new LinkedList<Jugador>();
		
		copia = partida1.getJugadores();
		
		String jugs = "";
		
		for (Jugador jugador : copia) 
			jugs += jugador.getNombre() + " ";
		
		
		assertEquals("Agustin Lucas Axel Leandro ", jugs);
	}
	
	/*
	
	@Test
	public void queElMazoCreaBienLasCartas() {
		
		
		
	}

	@Test
	public void queNoSePuedeCrearMasDeCuatroJugadores() {
		
		
		
	}
	
	@Test
	public void queNoSePuedeCrearMenosDeDosJugadores() {
		
		
		
	}
	
	@Test
	public void queFinalizaBienLaRonda() {
		
		
		
	}

	@Test
	public void queFinalizaBienLaPartida() {
		
		
		
	}
	
	@Test
	public void queIniciaLaRondaSacandoUnaCartaAlAzar() {
		
		
		
	}
	
	@Test
	public void queReparteBienLasCartasAlIniciarLaRonda() {
		
		
		
	}
	
	@Test
	public void queJugadorPuedeRobarCartasDelMazo() {
		
		
		
	}
	
	@Test
	public void queJugadorPuedeElegirQueCartaTirar() {
		
		
		
	}
	
	@Test
	public void queElEfectoActivadoPorLaCartaEsCorrecto() {
		
		
		
	}
	
	@Test
	public void queCorrenBienLosTurnos() {
		
		
		
	}
	
	@Test
	public void queFinalizaBienLaRondaSinEmpate() {
		
		
		
	}
	
	@Test
	public void queFinalizaBienLaRondaConEmpate() {
		
		
		
	}
	
	@Test
	public void queElGanadorDeRondaSumaUnSimboloDeAfecto() {
		
		
		
	}
	
	*/
}

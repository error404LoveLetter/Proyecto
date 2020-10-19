package juego;

import java.util.Collections;
import java.util.Stack;

import cartas.Baron;
import cartas.Carta;
import cartas.Condesa;
import cartas.CrearCarta;
import cartas.Guardia;
import cartas.Mucama;
import cartas.Princesa;
import cartas.Principe;
import cartas.Rey;
import cartas.Sacerdote;

public class Mazo {
	private Stack<Carta> pilaDeCartas;
	static public Carta[] vecCartas = {new Guardia(),
										  new Sacerdote(),
									      new Baron(),
									      new Mucama(),
									      new Principe(),
									      new Rey(),
									      new Condesa(),
									      new Princesa()};
	
	static private Carta []vecMazoOrdenado = {vecCartas[CrearCarta.GUARDIA.ordinal()],
											vecCartas[CrearCarta.GUARDIA.ordinal()],
											vecCartas[CrearCarta.GUARDIA.ordinal()],
											vecCartas[CrearCarta.GUARDIA.ordinal()],
											vecCartas[CrearCarta.GUARDIA.ordinal()],
											vecCartas[CrearCarta.SACERDOTE.ordinal()],
											vecCartas[CrearCarta.SACERDOTE.ordinal()],
											vecCartas[CrearCarta.BARON.ordinal()],
											vecCartas[CrearCarta.BARON.ordinal()],
											vecCartas[CrearCarta.MUCAMA.ordinal()],
											vecCartas[CrearCarta.MUCAMA.ordinal()],
											vecCartas[CrearCarta.PRINCIPE.ordinal()],
											vecCartas[CrearCarta.PRINCIPE.ordinal()],
											vecCartas[CrearCarta.REY.ordinal()],
											vecCartas[CrearCarta.CONDESA.ordinal()],
											vecCartas[CrearCarta.PRINCESA.ordinal()]};
	private boolean mazoVacio = false;
	
	public Mazo() {
		pilaDeCartas = new Stack<Carta>();
		for (Carta carta : vecMazoOrdenado) {
			this.pilaDeCartas.push(carta);
		}
		Collections.shuffle(pilaDeCartas);
	}

	public Carta sacarDePila() {
		if(pilaDeCartas.size() == 1)
			setMazoVacio(true);   
		
		return pilaDeCartas.pop();
	}

	public boolean isMazoVacio() {
		return mazoVacio;
	}

	public void setMazoVacio(boolean esMazoVacio) {
		this.mazoVacio = esMazoVacio;
	}
}

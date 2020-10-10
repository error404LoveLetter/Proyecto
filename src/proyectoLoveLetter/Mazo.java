package proyectoLoveLetter;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Mazo {
	private Carta cartasActuales [];
	private boolean esMazoVacio;
	
	
	public Mazo(Carta[] cartasActuales, boolean esMazoVacio) {
		this.cartasActuales = cartasActuales;
		this.esMazoVacio = false;
	}

	public Carta sacarDePila() {
		
		if(esMazoVacio == true)
		{
			return null; //deberia lanzar una excepcion   
		}
		Stack pila = new Stack();
		for (Carta carta : cartasActuales) {
			pila.push(carta);
		}
		return (Carta) pila.pop();
		//return cartasActuales[0];
	}
	
	public void mezclar() {
		List<Carta> cartas = new LinkedList<Carta>();
		for (Carta carta : cartasActuales) {
			cartas.add(carta);
		}
		Collections.shuffle(cartas);
		
		////////////////////// OTRA FORMA ////////////////////////
//		Carta auxiliar;
//		int posAleatoria = (int) Math.random()*cartasActuales.length;
//		
//		for(int i=0; i < cartasActuales.length; i++) {
//			posAleatoria = (int) (Math.random()*cartasActuales.length);
//			auxiliar = cartasActuales[i];
//			cartasActuales[i] = cartasActuales[posAleatoria];
//			cartasActuales[posAleatoria] = auxiliar;		
//		}
//	}

	public boolean isEsMazoVacio() {
		return esMazoVacio;
	}

	public void setEsMazoVacio(boolean esMazoVacio) {
		this.esMazoVacio = esMazoVacio;
	}
}

package proyectoLoveLetter;

import java.util.Stack;

public class Mazo {
	private Stack<Carta> pilaDeCartas;
	static private Carta []vecCartas = {new Guardia(),
									    new Guardia(),
									    new Guardia(),
									    new Guardia(),
									    new Guardia(),
									    new Sacerdote(),
									    new Sacerdote(),
									    new Baron(),
									    new Baron(),
									    new Mucama(),
									    new Mucama(),
									    new Principe(),
									    new Principe(),
									    new Rey(),
									    new Condesa(),
									    new Princesa()};
	
	private boolean mazoVacio = false;
	
	public Mazo() {
		pilaDeCartas = new Stack<Carta>();
		mezclar();
		for (Carta carta : vecCartas) {
			this.pilaDeCartas.push(carta);
		}
	}

	public Carta sacarDePila() {
		if(pilaDeCartas.size() == 1)
			setMazoVacio(true);   
		
		return pilaDeCartas.pop();
	}
	
	public void mezclar() {
//		List<Carta> cartas = new LinkedList<Carta>();
//		for (Carta carta : cartasActuales) {
//			cartas.add(carta);
//		}
//		Collections.shuffle(cartas);
		
		////////////////////// OTRA FORMA ////////////////////////
		Carta cartaAux;
		int posAleatoria = (int) Math.random()*vecCartas.length;
		
		for(int i=0; i < vecCartas.length; i++) {
			posAleatoria = (int) (Math.random()*vecCartas.length);
			cartaAux = vecCartas[i];
			vecCartas[i] = vecCartas[posAleatoria];
			vecCartas[posAleatoria] = cartaAux;		
		}
	}

	public boolean isMazoVacio() {
		return mazoVacio;
	}

	public void setMazoVacio(boolean esMazoVacio) {
		this.mazoVacio = esMazoVacio;
	}
}

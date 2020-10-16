package proyectoLoveLetter;

import java.util.LinkedList;
import java.util.List;

public class Jugador {
	private static Ronda rondaActual;
	private String nombre;
	private int idUsuario;
	private int contadorDeCartasDescartadas = 0;
	private List<Carta> mano;
	private int puntos;
	private boolean estaProtegido;
	private boolean turno = false;

	public Jugador(int idUsuario, String nombre) {
		mano = new LinkedList<Carta>();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
	}

	public Jugador(String nombreDePrueba, boolean estaProtegidoDePrueba, boolean turnoDePrueba, int puntosDePrueba,
			int contadorDeCartasDescartadasDePrueba) {
		this.nombre = nombreDePrueba;
		this.estaProtegido = estaProtegidoDePrueba;
		this.turno = turnoDePrueba;
		this.puntos = puntosDePrueba;
		this.contadorDeCartasDescartadas = contadorDeCartasDescartadasDePrueba;
		this.mano = new LinkedList<Carta>();
	}

	public Carta jugarCarta() {
		if (isTurno()) {
			int opcionElegida;
			Carta cartaRemovida;
			this.estaProtegido = false; // seteo que no esta protegido

			opcionElegida = elegirCarta();

			cartaRemovida = mano.get(opcionElegida - 1);
			mano.remove(opcionElegida - 1);
			cartaRemovida.efecto(this);
			contadorDeCartasDescartadas++;
			return cartaRemovida;// mano.get(opcionElegida - 1);
		}

		return null;
	}

	private int elegirCarta() { //ESTO VA PRIVADO
		int opcionElegida;

		if (mano.contains(new Condesa()) && (mano.contains(new Rey()) || mano.contains(new Principe())))
			opcionElegida = mano.indexOf(new Condesa()) + 1;
		else
			do {
				System.out.println("Elija una carta para jugar: " + "1- " + mano.get(0).getNombre() + "\t2- "
						+ mano.get(1).getNombre());
				opcionElegida = Integer.parseInt(Partida.sc.nextLine());
			} while (opcionElegida < 1 || opcionElegida > 2);

		return opcionElegida;
	}
	
	public int elegirCartaPrueba()
	{
		return elegirCarta();
	}

	public void agregarCartaAMano(Carta nuevaCarta) {
		mano.add(nuevaCarta);
	}

	public void descartarMano() {
		mano.clear();
		contadorDeCartasDescartadas++;
	}

	public void rendirse() {
		System.out.println("El jugador: " + nombre + "se ha rendido.");
		getRondaActual().jugadorSeRinde(this);
	}

//	public List<Carta> obMano() {
//		return this.mano;
//	}

	public List<Carta> getMano() {
		if (this.mano.size() != 0)
			return this.mano;
		return null;
	}

	public void setMano(Carta nuevaMano) {
		if (mano.isEmpty() != true)
			mano.remove(0);
		mano.add(nuevaMano);
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + "]";
	}

	public int getCantidadDeCartasDescartadas() {
		return this.contadorDeCartasDescartadas;
	}

	public void sumarPunto() {
		this.puntos++;
	}

	public int getPuntos() {
		return puntos;
	}

	public boolean isTurno() {
		return turno;
	}

	public void setTurno(boolean turno) {
		this.turno = turno;
	}

	public String getNombre() {
		return nombre;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public boolean isEstaProtegido() {
		return estaProtegido;
	}

	public void setEstaProtegido(boolean estaProtegido) {
		this.estaProtegido = estaProtegido;
	}

	public static Ronda getRondaActual() {
		return rondaActual;
	}

	public static void setRondaActual(Ronda rondaActual) {
		Jugador.rondaActual = rondaActual;
	}

}

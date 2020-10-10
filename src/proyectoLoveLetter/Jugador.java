package proyectoLoveLetter;

import java.util.Scanner;

public class Jugador {
	private int idUsuario;
	private String nombre;
	private Carta mano [];
	private int puntos;
	private boolean estaProtegido;
	private boolean turno = false;
	
	public boolean isTurno() {
		return turno;
	}

	public void setTurno(boolean turno) {
		this.turno = turno;
	}

	public Jugador(int idUsuario, String nombre) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdUsuario() {
		return idUsuario;
	}
	
	public Carta jugarCarta() {
		Scanner entrada = new Scanner(System.in);
		int opcionElegida;
		
		//set turno
		do
		{
			System.out.println("Elija una carta para jugar: " + "1- " + mano[0] + "2- " + mano[1]); // no esta copiado
			opcionElegida = Integer.parseInt(entrada.nextLine());
		}while(opcionElegida<1 || opcionElegida>2);
		
		ControladorDeJugada.activarEfecto(this, mano[opcionElegida-1]);
		//implementar descartar mano
		
		entrada.close();
		return mano[opcionElegida-1];
	}
	
	public void descartarMano() {
		this.mano[1] = null; //preguntar si descarta la ultima carta, o la primera
	}

//  Lo va a manejar ronda
//	
//	public void robarCarta() {
//		this.mano[1] = ControladorDeJugada.repartirCarta(mazo, this);
//	}
	
	public void rendirse() {
		System.out.println("El jugador: " + nombre + "se ha rendido.");
		ControladorDeJugada.eliminarJugador(this);
	}
	
	public void sumarPuntos() {
		this.puntos++;
	}

	public int getPuntos() {
		return puntos;
	}
}

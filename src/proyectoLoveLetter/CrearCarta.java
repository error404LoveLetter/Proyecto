package proyectoLoveLetter;

public class CrearCarta {
	static public String nombres[] = {"Guardia", 
									   "Sacerdote",
									   "Baron",
									   "Mucama",
									   "Principe",
									   "Rey",
									   "Condesa",
									   "Princesa"};
	static public int fuerza[] = {1,2,3,4,5,6,7,8};
	static public String descripciones[] = {"El jugador elige otro jugador oponente y nombra un tipo de carta (excepto \"Guardia\"). Si el oponente tiene en su mano una carta de ese tipo, el oponente es eliminado de la ronda",
									  "El jugador elige otro jugador para ver la cartas en su mano",
									  "El jugador elige otro jugador y se revelan las cartas de forma privada. El jugador que posee la carta con menos fuerza es eliminado de la ronda",
									  "El jugador está protegido y no puede ser afectado por cartas de otros jugadores hasta su siguiente turno",
									  "El jugador elige otro jugador (incluso a sí mismo) para descartar su mano y robar una carta nueva. Si la Princesa es descartada de esta manera, el jugador que la descartó es eliminado de la ronda",
									  "El jugador elige otro jugador e intercambian sus manos",
									  "Si un jugador tiene esta carta y el Rey o el Príncipe, esta carta debe ser jugada inmediatamente",
									  "Si un jugador juega o descarta esta carta por cualquier motivo, ese jugador es eliminado de la ronda"};
	
	
	static public Carta crearCarta(int numeroDeCarta)
	{
		switch(numeroDeCarta)
		{
			case 1: return new Guardia(nombres[numeroDeCarta], fuerza[numeroDeCarta], descripciones[numeroDeCarta]);
			case 2: return new Sacerdote(nombres[numeroDeCarta], fuerza[numeroDeCarta], descripciones[numeroDeCarta]);
			case 3: return new Baron(nombres[numeroDeCarta], fuerza[numeroDeCarta], descripciones[numeroDeCarta]);
			case 4: return new Mucama(nombres[numeroDeCarta], fuerza[numeroDeCarta], descripciones[numeroDeCarta]);
			case 5: return new Principe(nombres[numeroDeCarta], fuerza[numeroDeCarta], descripciones[numeroDeCarta]);
			case 6: return new Rey(nombres[numeroDeCarta], fuerza[numeroDeCarta], descripciones[numeroDeCarta]);
			case 7: return new Condesa(nombres[numeroDeCarta], fuerza[numeroDeCarta], descripciones[numeroDeCarta]);
			case 8: return new Princesa(nombres[numeroDeCarta], fuerza[numeroDeCarta], descripciones[numeroDeCarta]);
		}
		return null;
	}
}

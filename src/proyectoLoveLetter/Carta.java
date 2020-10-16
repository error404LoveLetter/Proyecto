package proyectoLoveLetter;

public abstract class Carta {
	static protected String nombres[] = { 
									  "Guardia", 
									"Sacerdote", 
										"Baron", 
									   "Mucama", 
									 "Principe", 
									 	  "Rey", 
									  "Condesa",
									 "Princesa" };
	static protected int fuerzas[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
	static protected String descripciones[] = {
			"El jugador elige otro jugador oponente y nombra un tipo de carta (excepto \"Guardia\"). Si el oponente tiene en su mano una carta de ese tipo, el oponente es eliminado de la ronda",
			"El jugador elige otro jugador para ver la cartas en su mano",
			"El jugador elige otro jugador y se revelan las cartas de forma privada. El jugador que posee la carta con menos fuerza es eliminado de la ronda",
			"El jugador está protegido y no puede ser afectado por cartas de otros jugadores hasta su siguiente turno",
			"El jugador elige otro jugador (incluso a sí mismo) para descartar su mano y robar una carta nueva. Si la Princesa es descartada de esta manera, el jugador que la descartó es eliminado de la ronda",
			"El jugador elige otro jugador e intercambian sus manos",
			"Si un jugador tiene esta carta y el Rey o el Príncipe, esta carta debe ser jugada inmediatamente",
			"Si un jugador juega o descarta esta carta por cualquier motivo, ese jugador es eliminado de la ronda" };
	private String nombre;
	private int fuerza;
	private String descripcion;
	
//	public Carta(String nombre, int fuerza, String descripcion) {
//		this.nombre = nombre;
//		this.fuerza = fuerza;
//		this.descripcion = descripcion;
//	}

	public Carta(CrearCarta tipoDeCarta) {
		this.nombre = nombres[tipoDeCarta.ordinal()];
		this.fuerza = fuerzas[tipoDeCarta.ordinal()];
		this.descripcion = descripciones[tipoDeCarta.ordinal()];
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public String getNombre() {
		return nombre;
	}

	public int getFuerza() {
		return fuerza;
	}

	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public String toString() {
		return "Carta [nombre=" + nombre + "]";
	}

	public abstract void efecto(Jugador j);
}

package proyectoLoveLetter;

public abstract class Carta {
	private String nombre;
	private int fuerza;
	private String descripcion;
	
	public Carta(String nombre, int fuerza, String descripcion) {
		this.nombre = nombre;
		this.fuerza = fuerza;
		this.descripcion = descripcion;
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
	
	public abstract void efecto(Jugador j);
}

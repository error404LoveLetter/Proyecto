package proyecto;

public class Jugador {
	private int turno = 0;
	private boolean seRindio;
	private int cantidadDescartadas;
	int puntos;
	public Carta mano[];
	
	public void setTurno(int turno) {
		this.turno = turno;
	}
	public boolean getseRindio()
	{
		return this.seRindio;
	}
	
	public int getCantidadDescartadas()
	{
		return this.cantidadDescartadas;
	}
	
	public void sumarPunto()
	{
		puntos++;
	}
}

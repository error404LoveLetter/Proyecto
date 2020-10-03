package proyectoLoveLetter;

public class Jugador {
	private Carta []mano;
	@SuppressWarnings("unused")
	private boolean estaProtegido;
	
	public Carta[] getMano()
	{
		return mano;
	}
	
	public void setEstaProtegido(boolean valor)
	{
		estaProtegido = valor;
	}
	
	public void descartarMano()
	{
		
	}
	
	public void setMano(Carta []vecCartas)
	{
		mano = vecCartas;
	}
}

package proyectoLoveLetter;

import java.util.Scanner;

public class Guardia extends Carta{
	
	public Guardia(String nombre, int fuerza, String descripcion)
	{
		super(nombre,fuerza,descripcion);
	}
	
	@SuppressWarnings("resource")
	public void efecto(Jugador esteJugador)
	{
		Scanner entrada = new Scanner(System.in); //Preguntar si es necesario validar si se pudo 
		int opcionElegida;
		Jugador otroJugador = ControladorDeJugada.SeleccionarJugador(false);
		
		do
		{
			System.out.println("Elija una carta:" + "1-Guardia\n"+ 
					   "2-Sacerdote\n"+
					   "3-Baron\n"+
					   "4-Mucama\n"+
					   "5-Principe\n"+
					   "6-Rey\n"+
					   "7-Condesa\n"+
					   "8-Princesa");
			
			opcionElegida = Integer.parseInt(entrada.nextLine());	
		}while(opcionElegida<1 || opcionElegida>8);
		
		if(otroJugador.getMano()[0].getNombre() == CrearCarta.nombres[opcionElegida])
			ControladorDeJugada.eliminarJugador(otroJugador);
		else
			System.out.println("La carta seleccionada no era la correcta");
		
	}
}

/**
 * 
 */
package ar.uba.fi.algo3.controlador;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

/**
 * @author Fede
 * Clase principal, el punto de inicio del juego.
 */
public class CorrerJuego {


	/**
	 * Crea una ventana y un controlador, que seran usados durante el juego.
	 * @param args
	 */
	public static void main(String[] args) {
		ControladorJuego controlador = ControladorJuego.getInstancia();
		Ventana ventana = new Ventana(801, 634, controlador);
		ventana.setTitle("AlgoTank");
		
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);		
		
		controlador.setIntervaloSimulacion(50);
		controlador.comenzarJuego();
	}

}

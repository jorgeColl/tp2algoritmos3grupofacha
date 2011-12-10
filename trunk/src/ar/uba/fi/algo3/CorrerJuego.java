/**
 * 
 */
package ar.uba.fi.algo3;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

/**
 * @author Fede
 *
 */
public class CorrerJuego {


	/**
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

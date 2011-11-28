/**
 * 
 */
package ar.uba.fi.algo3;

import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
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
		// TODO Auto-generated method stub
		
		/* esto no s� que es, pero me lo pide el contructor del 
		ControladorJuego, as� que para no harcodearlo lo inicializo
		ac�: */
		boolean activarReproductor = true;
		
		ControladorJuego controlador = new ControladorJuego(activarReproductor);
		Ventana ventana = new Ventana(800, 600, controlador);
		
		/* l�neas copiadas del ejemplo. */
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);		
		
		AlgoTank algoTank = new AlgoTank(new Posicion(400,300));
		controlador.agregarDibujable(algoTank);
		
		
		
		

	}

}

/**
 * 
 */
package ar.uba.fi.algo3;


import java.awt.Color;

import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.Cuadrado;
import ar.uba.fi.algo3.titiritero.vista.Ventana;
import ar.uba.fi.algo3.vista.PuntoParaTexto;

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
		
		Cuadrado cuadrado = new Cuadrado(200,600);
		cuadrado.setColor(Color.gray);
		cuadrado.setPosicionable(new PuntoParaTexto(new Posicion(602,0)));
		controlador.agregarDibujable(cuadrado);
		
		controlador.setIntervaloSimulacion(50);
		controlador.comenzarJuego();

	}

}

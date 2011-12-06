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
		// TODO Auto-generated method stub
		
		/* esto no s� que es, pero me lo pide el contructor del 
		ControladorJuego, as� que para no harcodearlo lo inicializo
		ac�: */
		ControladorJuego controlador = ControladorJuego.getInstancia();
		Ventana ventana = new Ventana(801, 601, controlador);
		ventana.setTitle("AlgoTank");
		
		/* l�neas copiadas del ejemplo. */
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);		
		
		//aca pongo el fondito gris
		Cuadrado cuadrado = new Cuadrado(200,601);
		cuadrado.setColor(Color.gray);
		cuadrado.setPosicionable(new PuntoParaTexto(new Posicion(601,0)));
		controlador.agregarDibujable(cuadrado);
		
	
		/*
		TextoEstatico texto = new TextoEstatico("fooo");
		texto.setPosicionable(paredMetal);
		texto.setColor(Color.black);
		controlador.agregarDibujable(texto);
		
		*/
		
		controlador.setIntervaloSimulacion(50);
		controlador.comenzarJuego();

	}

}

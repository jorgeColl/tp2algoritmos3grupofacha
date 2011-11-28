/**
 * 
 */
package ar.uba.fi.algo3.vista;

import java.awt.Color;
import java.awt.event.KeyEvent;

import ar.uba.fi.algo3.modelo.tanques.Tanque;
import ar.uba.fi.algo3.titiritero.vista.Cuadrado;

/**
 * @author Fede
 *
 */
public class VistaTanque extends Cuadrado {
	
	public VistaTanque(){
		super(25,25);
		setColor(Color.BLUE);
	}
	
	public void keyPressed(KeyEvent keyEvent){
		int c = keyEvent.getKeyCode();
		Tanque posicionable = (Tanque) this.getPosicionable();
		switch (c){
			case KeyEvent.VK_RIGHT:
				posicionable.moverDerecha();
				break;
			case KeyEvent.VK_LEFT:
				posicionable.moverIzquierda();
				break;
			case KeyEvent.VK_UP:
				posicionable.moverArriba();
				break;
			case KeyEvent.VK_DOWN:
				posicionable.moverAbajo();
				break;
		}
		
		
	}

}

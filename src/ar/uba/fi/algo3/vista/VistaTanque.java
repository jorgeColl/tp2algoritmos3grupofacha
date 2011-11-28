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
		Tanque tanque = (Tanque) this.getPosicionable();
		switch (c){
			case KeyEvent.VK_RIGHT:
				tanque.moverDerecha();
				break;
			case KeyEvent.VK_LEFT:
				tanque.moverIzquierda();
				break;
			case KeyEvent.VK_UP:
				tanque.moverArriba();
				break;
			case KeyEvent.VK_DOWN:
				tanque.moverAbajo();
				break;
		}
		
		
	}

}

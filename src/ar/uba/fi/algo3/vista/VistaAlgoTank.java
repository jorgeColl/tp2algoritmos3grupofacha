/**
 * 
 */
package ar.uba.fi.algo3.vista;

import java.awt.event.KeyEvent;

import ar.uba.fi.algo3.modelo.tanques.Tanque;

/**
 * Clase que modela la vista del AlgoTank.
 * @author Fede
 *
 */
public class VistaAlgoTank extends VistaImagenConOrientacion {
	
	
	public VistaAlgoTank(String directorio1,String dir2,String dir3,String di4){
		super(directorio1,dir2,dir3,di4);		
	}
	
	/* definicion del comportamiento del AlgoTank como observador
	 * de eventos del teclado.
	 * 
	 */
	public void keyPressed(KeyEvent keyEvent){
		int c = keyEvent.getKeyCode();
		Tanque tanque = (Tanque) this.getPosicionable();
		switch (c){
			case KeyEvent.VK_RIGHT:
				tanque.moverDerecha();
				this.cambiarAImagen(DERECHA);
				break;
			case KeyEvent.VK_LEFT:
				tanque.moverIzquierda();
				this.cambiarAImagen(IZQUIERDA);
				break;
			case KeyEvent.VK_UP:
				tanque.moverArriba();
				this.cambiarAImagen(ARRIBA);
				break;
			case KeyEvent.VK_DOWN:
				tanque.moverAbajo();
				this.cambiarAImagen(ABAJO);
				break;
			case KeyEvent.VK_SPACE:
				tanque.disparar();
				break;
		}
	}

}

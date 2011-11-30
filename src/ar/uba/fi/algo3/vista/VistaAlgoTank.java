/**
 * 
 */
package ar.uba.fi.algo3.vista;

import java.awt.event.KeyEvent;

import ar.uba.fi.algo3.modelo.tanques.Tanque;
import ar.uba.fi.algo3.titiritero.vista.ImagenDinamica;

/**
 * Clase que modela la vista del AlgoTank.
 * @author Fede
 *
 */
public class VistaAlgoTank extends ImagenDinamica {
	
	/* definiciones que se usan para el manejo de imagenes. */
	final static int DERECHA = 1;
	final static int IZQUIERDA = 2;
	final static int ARRIBA = 3;
	final static int ABAJO = 4;
	
	public VistaAlgoTank(){
		super();
		/* carga las imagenes en la clase de ImagenDinamica */
		this.agregarImagen(DERECHA, "img/AlgoTank_i.JPG");
		this.agregarImagen(IZQUIERDA, "img/AlgoTank_iNegativo.JPG");
		this.agregarImagen(ARRIBA, "img/AlgoTank_j.JPG");
		this.agregarImagen(ABAJO, "img/AlgoTank_jNegativo.JPG");
		
		/* setea por default que el tanque mire por defecto para arriba */
		this.cambiarAImagen(ARRIBA);
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

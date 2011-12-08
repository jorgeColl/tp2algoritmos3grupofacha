/**
 * 
 */
package ar.uba.fi.algo3.vista;

import java.awt.event.KeyEvent;

import ar.uba.fi.algo3.Nivel;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

/**
 * @author jc
 *
 */
public class VistaEscucha extends Imagen {
	
	

	@Override
	public void keyPressed(KeyEvent keyEvent){
		int c = keyEvent.getKeyCode();
		
		switch (c){
		
		case KeyEvent.VK_G:
			Nivel nivel = Nivel.getInstancia();
			nivel.guardarNivel();
			break;
		}
	}

}

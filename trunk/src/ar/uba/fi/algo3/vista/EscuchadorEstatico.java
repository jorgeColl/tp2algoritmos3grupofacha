/**
 * 
 */
package ar.uba.fi.algo3.vista;

import java.awt.event.KeyEvent;

import ar.uba.fi.algo3.Nivel;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

/**
 * @author jc
 * clase encargada de escuchar durante todo el juego a las teclas que no sean de interaccion
 * directa con los objetos del juego mostados en pantalla
 */
public class EscuchadorEstatico  implements KeyPressedObservador {
	
	public EscuchadorEstatico(){
		super();
	}
	
	public void keyPressed(KeyEvent keyEvent){
		int c = keyEvent.getKeyCode();
		
		switch (c){
			// cuando el usuario aprete g, el nivel se guardara¡
			case KeyEvent.VK_G:
				Nivel nivel = Nivel.getInstancia();
				nivel.guardarNivel();
				break;
		}
	}

}

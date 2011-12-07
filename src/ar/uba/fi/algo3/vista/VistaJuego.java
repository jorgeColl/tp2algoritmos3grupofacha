/**
 * 
 */
package ar.uba.fi.algo3.vista;

import java.awt.event.KeyEvent;
import java.io.File;

import ar.uba.fi.algo3.Nivel;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.TextoEstatico;

/**
 * @author jc
 *
 */
public class VistaJuego extends TextoEstatico{
	
	public VistaJuego(){
		super("JUEGO NUEVO	 (pulse arriba en el teclado)\n\n"+
				"CONTINUAR JUGANDO (pulse abajo en el teclado)");
	}
	
	@Override
	public void keyPressed(KeyEvent keyEvent){
		int c = keyEvent.getKeyCode();
		Nivel nivel = Nivel.getInstancia();
		switch (c){
			
			case KeyEvent.VK_UP:
				// elimino archivo .xml de juego guardado (si es que existe)
				File fichero = new File("save/juegoGuardado.xml");
				fichero.delete();
				
			case KeyEvent.VK_DOWN:
				nivel.cargarNivel();
				ControladorJuego.getInstancia().removerDibujable(this);
				ControladorJuego.getInstancia().removerKeyPressObservador(this);
				break;
			
		}
	}


}

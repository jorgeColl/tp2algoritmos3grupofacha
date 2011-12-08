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
public class VistaInicioDeJuego extends TextoEstatico{
	
	public VistaInicioDeJuego(){
		super("JUEGO NUEVO	 (pulse arriba en el teclado)\n\n"+
				"CONTINUAR JUGANDO (pulse abajo en el teclado)");
	}
	
	@Override
	public void keyPressed(KeyEvent keyEvent){
		int c = keyEvent.getKeyCode();
		Nivel nivel = Nivel.getInstancia();
		switch (c){
			
			case KeyEvent.VK_UP:
				nivel.cargarNivel();
				this.auxiliar();
				break;
				
			case KeyEvent.VK_DOWN:
				Nivel.getInstancia().cargarNivelGuardado();
				this.auxiliar();
				
				break;
		}
		
		
	}
	/**
	 * metodo que se encarga de eliminar la vista y el key obsevator, al mismo tiempo que crea
	 * otro
	 */
	private void auxiliar(){
		ControladorJuego.getInstancia().removerDibujable(this);
		ControladorJuego.getInstancia().removerKeyPressObservador(this);
		//crear escuchador
		Escuchador escuchador = new Escuchador();
		ControladorJuego.getInstancia().agregarKeyPressObservador(escuchador);
		
	}

}

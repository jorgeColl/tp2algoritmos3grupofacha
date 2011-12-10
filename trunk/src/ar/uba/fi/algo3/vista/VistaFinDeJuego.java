/**
 * 
 */
package ar.uba.fi.algo3.vista;

import ar.uba.fi.algo3.titiritero.vista.ObjetoDeTexto;

/**
 * @author jc
 *
 */
public class VistaFinDeJuego implements ObjetoDeTexto {

	protected int prioridad;
	
	public VistaFinDeJuego(){
		this.prioridad = 10;
	}
	
	@Override
	public String getTexto() {
		return "Juego \nterminado";
	}

	@Override
	public int getPrioridad() {
		return this.prioridad;
	}

}

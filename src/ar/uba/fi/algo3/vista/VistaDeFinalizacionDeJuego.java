/**
 * 
 */
package ar.uba.fi.algo3.vista;

import ar.uba.fi.algo3.titiritero.vista.ObjetoDeTexto;

/**
 * @author jc
 *
 */
public class VistaDeFinalizacionDeJuego implements ObjetoDeTexto {

	protected int prioridad;
	
	public VistaDeFinalizacionDeJuego(){
		this.prioridad = 10;
	}
	
	@Override
	public String getTexto() {
		return "GAME\nOVER\n   :(";
	}

	@Override
	public int getPrioridad() {
		return this.prioridad;
	}

}

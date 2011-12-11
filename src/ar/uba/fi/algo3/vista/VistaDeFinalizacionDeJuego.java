/**
 * 
 */
package ar.uba.fi.algo3.vista;

import ar.uba.fi.algo3.controlador.Nivel;
import ar.uba.fi.algo3.titiritero.vista.ObjetoDeTexto;

/**
 * @author jc
 * clase que modela la vista de finalizacion de juego, el texto de 
 * Juego terminado o Nivel ganado que se muestra al terminar un nivel.
 */
public class VistaDeFinalizacionDeJuego implements ObjetoDeTexto{

	protected Nivel nivel;
	protected int prioridad;
	public VistaDeFinalizacionDeJuego(Nivel nivel){
		this.nivel= nivel;
		this.prioridad = 10;
	}
	
	/**
	 * devuelve el texto correspondiente al estado del nivel.
	 */
	@Override
	public String getTexto() {
		if(this.nivel.nivelGanado())
			return "Nivel \ncompletado";
		if(this.nivel.nivelPerdido())
			return "Juego \nterminado";
		else
			return "";
	}

	@Override
	public int getPrioridad() {
		return this.prioridad;
	}

}

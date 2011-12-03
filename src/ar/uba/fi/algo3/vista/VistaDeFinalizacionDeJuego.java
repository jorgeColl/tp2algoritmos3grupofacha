/**
 * 
 */
package ar.uba.fi.algo3.vista;

import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.titiritero.vista.ObjetoDeTexto;

/**
 * @author jc
 *
 */
public class VistaDeFinalizacionDeJuego implements ObjetoDeTexto{

	protected Espacio espacio;
	
	public VistaDeFinalizacionDeJuego(Espacio espacio){
		this.espacio= espacio;
	}
	
	@Override
	public String getTexto() {
		// TODO Auto-generated method stub
		
		
		if(this.espacio.juegoGanado()){
			return "GANASTEEEEE";
		}else{
			if(this.espacio.juegoPerdido()){
				return "PERDISTEEEE :(";
			}else{
				return "jugando";
			}
		}
		
	}

}

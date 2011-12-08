/**
 * 
 */
package ar.uba.fi.algo3.vista;

import ar.uba.fi.algo3.Nivel;
import ar.uba.fi.algo3.titiritero.vista.ObjetoDeTexto;

/**
 * @author jc
 *
 */
public class VistaDeFinalizacionDeJuego implements ObjetoDeTexto{

	protected Nivel nivel;
	
	public VistaDeFinalizacionDeJuego(Nivel nivel){
		this.nivel= nivel;
	}
	
	@Override
	public String getTexto() {
		// TODO Auto-generated method stub
		
		
		if(this.nivel.nivelGanado()){
			return "GANASTEEEEE";
		}else{
			if(this.nivel.nivelPerdido()){
				return "PERDISTEEEE :(";
			}else{
				return "jugando";
			}
		}
		
	}

}

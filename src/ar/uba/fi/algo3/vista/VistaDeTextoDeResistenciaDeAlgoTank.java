/**
 * 
 */
package ar.uba.fi.algo3.vista;

import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import ar.uba.fi.algo3.titiritero.vista.ObjetoDeTexto;

/**
 * @author jc
 * Esta clase es una vista que va a ser usada por la clase TextoDinamico para
 * ir mostrando el estado de la resistencia del algotank durante el juego
 */
public class VistaDeTextoDeResistenciaDeAlgoTank implements ObjetoDeTexto{
	protected AlgoTank tanque;
	
	public  VistaDeTextoDeResistenciaDeAlgoTank(AlgoTank algoTanque){
		tanque=algoTanque;
	}

	@Override
	public String getTexto() {
		// TODO Auto-generated method stub
		return "resistencia:"+Integer.toString(tanque.getResistencia());
		
	}
	
}

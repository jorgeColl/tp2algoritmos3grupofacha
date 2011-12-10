/**
 * 
 */
package ar.uba.fi.algo3.vista;

import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import ar.uba.fi.algo3.titiritero.vista.ObjetoDeTexto;

/**
 * @author jc
 * Esta clase es una vista que va a ser usada por la clase TextoDinamico para
 * ir mostrando el estado de la resistencia del algotank durante el juego y tambien
 * de las municiones que tiene
 */
public class VistaDeTextoDeAlgoTank implements ObjetoDeTexto {
	protected AlgoTank tanque;
	protected int prioridad;
	
	public VistaDeTextoDeAlgoTank(AlgoTank algoTanque){
		tanque = algoTanque;
		this.prioridad = 11;
	}

	@Override
	public String getTexto() {
		int municionesEspeciales;
		if (! tanque.isVivo()) return "";
		if (tanque.getArmasPrioritarias().isEmpty()){
			municionesEspeciales = 0;
		} else {
			municionesEspeciales = tanque.getArmasPrioritarias().peek().getMunicion();
		}
		return  "\nAlgoTank\n\n\n\n\n\n" +
				"Resistencia: "+Integer.toString(tanque.getResistencia())+"\n"+"\n"+
				"Municiones especiales: "+ Integer.toString(municionesEspeciales)+"\n"+"\n"+
				"Puntaje: " + Integer.toString(tanque.getPuntaje());
	}

	@Override
	public int getPrioridad() {
		return this.prioridad;
	}
}

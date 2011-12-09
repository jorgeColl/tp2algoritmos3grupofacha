/**
 * 
 */
package ar.uba.fi.algo3.vista;


import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import ar.uba.fi.algo3.modelo.tanques.Tanque;
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
	public  VistaDeTextoDeAlgoTank(AlgoTank algoTanque){
		tanque = algoTanque;
		this.prioridad=11;
	}


	@Override
	public String getTexto() {
		// TODO Auto-generated method stub
		int municionesEspeciales;
		if (tanque.isVivo()==false){
			return "";
		}
		if (tanque.getArmasPrioritarias().isEmpty()){
			municionesEspeciales = 0;
		}else{
			municionesEspeciales = tanque.getArmasPrioritarias().peek().getMunicion();
		}
		
		return  "reistencia: "+Integer.toString(tanque.getResistencia())+"\n"+
				"municionesEspeciales:"+ Integer.toString(municionesEspeciales)+"\n"+
				"puntos: " + Integer.toString(tanque.getPuntaje());
	}


	@Override
	public int getPrioridad() {
		// TODO Auto-generated method stub
		return this.prioridad;
	}

	
	
}

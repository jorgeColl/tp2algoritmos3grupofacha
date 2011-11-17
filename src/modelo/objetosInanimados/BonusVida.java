/**
 * 
 */
package modelo.objetosInanimados;

import modelo.manejoEspacial.Posicion;
import modelo.tanques.Tanque;

/**
 * clase que hace que aumente la vida del tanque
 * @author jc
 *
 */
public class BonusVida extends Bonus {
	double porcentaje;
	
	public BonusVida(Posicion posicion){
		super(posicion);
		this.porcentaje = 0.4;
	}
	
	@Override 
	public  void efectuarCambiosDeBonus (Tanque tanque){
		int resistencia = tanque.getResistencia();
		resistencia = (int) (resistencia*porcentaje);
		tanque.sumarResistencia(resistencia);
		
	}

	

}

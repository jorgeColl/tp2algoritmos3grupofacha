/**
 * 
 */
package modelo.bonuses;

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
	public  void chocarConTanque(Tanque tanque){
		int resistencia = tanque.getResistencia();
		resistencia += resistencia*porcentaje;
		tanque.sumarResistencia(resistencia);
		
	}

	

}

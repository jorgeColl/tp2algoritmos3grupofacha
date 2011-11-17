/**
 * 
 */
package modelo.objetosInanimados;

import modelo.manejoEspacial.Posicion;
import modelo.tanques.Tanque;

/**
 * @author jc
 *
 */
public class BonusVelocidad extends Bonus {
	
	protected double porcentajeVelocidadDisparo;
	protected double porcentajeVelocidadTanque;

	public BonusVelocidad(Posicion posicion){
		super(posicion);
		this.porcentajeVelocidadDisparo = 0.3;
		this.porcentajeVelocidadTanque = 0.2 ;
	}

	@Override
	public void efectuarCambiosDeBonus(Tanque tanque) {
		
		
		int velocidadTanque = tanque.getVelocidad();
		int velocidadDisparo = tanque.getVelocidadDisparo();
		 
		tanque.sumarVelocidad((int)velocidadTanque*this.porcentajeVelocidadTanque);
		tanque.sumarVelocidadDisparo((int)velocidadDisparo*this.porcentajeVelocidadDisparo);
		  
		
	}

}

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
	
	protected double porcentajeVelDisparo;
	protected double porcentajeVelocidad;

	public BonusVelocidad(Posicion posicion){
		super(posicion);
		this.porcentajeVelDisparo = 0.3;
		this.porcentajeVelocidadTanque = 0.2 ;
	}

	@Override
	public void efectuarCambiosDeBonus(Tanque tanque) {
		
		
		int velocidadTanque = tanque.getVelocidad();
		int velocidadDisparo = tanque.getVelocidadDisparo();
		 
		tanque.sumarVelocidad(velocidadTanque*this.porcentajeVelocidadTanque);
		tanque.sumarVelocidadDisparo(velocidadDisparo*porcentajeVelocidadDisparo);
		  
		 /**
		 * op2
		 * que tanque implemente funcion chocarConBonus
		 * y q bonus sea un formato estandar a llenar
		 * limita mucho a futuras acciones de bonus
		 */
		
	}

}

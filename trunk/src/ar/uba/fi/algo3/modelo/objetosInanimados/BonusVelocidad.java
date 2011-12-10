/**
 * 
 */
package ar.uba.fi.algo3.modelo.objetosInanimados;

import ar.uba.fi.algo3.vista.ConstructorVista;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.Tanque;

/**
 * Al entrar en contacto con un tanque, mejora sus velocidades de movimiento y disparo.
 * @author Jorge
 *
 */
public class BonusVelocidad extends Bonus {
	
	protected int porcentajeVelocidadDisparo;
	protected int porcentajeVelocidadTanque;

	public BonusVelocidad(Posicion posicion){
		super(posicion);
		porcentajeVelocidadDisparo = 30;
		porcentajeVelocidadTanque = 20 ;
		tipo = "velocidad";
		try {
			Espacio.getInstancia().agregarObjetoInanimado(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (Espacio.getInstancia().incluyeA(this)){
			ConstructorVista.construirVista(this);
		}
	}

	public void efectuarCambiosDeBonus(Tanque tanque) {
		int velocidadTanque = tanque.getVelocidad();
		int velocidadDisparo = tanque.getVelocidadDisparo();
		tanque.sumarVelocidad((int)((velocidadTanque*porcentajeVelocidadTanque)/100));
		tanque.sumarVelocidadDisparo((int)((velocidadDisparo*porcentajeVelocidadDisparo)/100));  
	}

}

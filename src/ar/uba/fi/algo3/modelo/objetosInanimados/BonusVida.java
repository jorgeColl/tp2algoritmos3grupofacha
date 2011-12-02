/**
 * 
 */
package ar.uba.fi.algo3.modelo.objetosInanimados;

import ar.uba.fi.algo3.ConstructorVista;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.Tanque;

/**
 * Al entrar en contacto con un tanque, mejora su resistencia.
 * @author Jorge
 *
 */
public class BonusVida extends Bonus {
	
	int porcentaje;
	
	public BonusVida(Posicion posicion){
		super(posicion);
		porcentaje = 40;
		try {
			Espacio.getInstancia().agregarObjetoInanimado(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (Espacio.getInstancia().incluyeA(this)){
			ConstructorVista.construirVista(this);
		}
	}
	
	public  void efectuarCambiosDeBonus (Tanque tanque){
		int resistencia = tanque.getResistencia();
		resistencia = (int)((resistencia*porcentaje)/100);
		tanque.sumarResistencia(resistencia);
	}
	
}

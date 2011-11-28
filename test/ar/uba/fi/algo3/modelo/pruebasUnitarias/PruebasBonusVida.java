package ar.uba.fi.algo3.modelo.pruebasUnitarias;

import ar.uba.fi.algo3.modelo.objetosInanimados.BonusVida;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import ar.uba.fi.algo3.modelo.tanques.Tanque;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase BonusVelocidad.
 * @author Jorge
 * 
 */
public class PruebasBonusVida extends TestCase {
	BonusVida bonusVida;
	Tanque tanque;
	double porcentajeQueAumentaBonus;
	
	public void setUp (){
		this.tanque = new AlgoTank(new Posicion(0,0));
		this.bonusVida = new BonusVida(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado(),0));
		this.porcentajeQueAumentaBonus = 0.4;
	}
	
	/**
	 * Testeo que el bonus mejore al tanque como se espera.
	 */
	public void testBonusVida(){
		int resistenciaAntes = this.tanque.getResistencia();
		this.bonusVida.chocarCon(this.tanque);
		int resistenciaDespues = this.tanque.getResistencia();
		
		assertTrue( (resistenciaAntes += resistenciaAntes*porcentajeQueAumentaBonus) == resistenciaDespues);
	}
}

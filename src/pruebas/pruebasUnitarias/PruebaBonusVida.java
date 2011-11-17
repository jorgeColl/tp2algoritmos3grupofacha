/**
 * 
 */
package pruebas.pruebasUnitarias;

import modelo.objetosInanimados.BonusVida;
import modelo.manejoEspacial.Posicion;
import modelo.tanques.AlgoTank;
import modelo.tanques.Tanque;
import junit.framework.TestCase;



/**
 * @author jc
 *
 */
public class PruebaBonusVida extends TestCase {
	BonusVida bonusVida;
	Tanque tanque;
	double porcentajeQueAumentaBonus;
	
	public void setUp (){
		Posicion puntoCualquiera = new Posicion(0,0);
		this.tanque = new AlgoTank(puntoCualquiera);
		this.bonusVida = new BonusVida (puntoCualquiera);
		this.porcentajeQueAumentaBonus = 0.4;
	}
	
	public void testBonusVida(){
		int resistenciaAntes = this.tanque.getResistencia();
		this.bonusVida.chocarConTanque(this.tanque);
		int resistenciaDespues = this.tanque.getResistencia();
		
		assertTrue( (resistenciaAntes += resistenciaAntes*porcentajeQueAumentaBonus) == resistenciaDespues);
	}
}

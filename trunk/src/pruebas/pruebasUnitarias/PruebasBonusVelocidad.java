/**
 * 
 */
package pruebas.pruebasUnitarias;

import junit.framework.TestCase;
import modelo.manejoEspacial.Posicion;
import modelo.objetosInanimados.BonusVelocidad;
import modelo.tanques.AlgoTank;
import modelo.tanques.Tanque;

/**
 * @author jc
 *
 */
public class PruebasBonusVelocidad extends TestCase{
	BonusVelocidad bonusVelocidad;
	Tanque tanque;
	double porcentajeVelocidadQueAumentaBonus;
	double porcentajeVelocidadDeDisparoQueAumentaBonus;
	
	
	public void setUp (){
		Posicion puntoCualquiera = new Posicion(0,0);
		this.tanque = new AlgoTank(puntoCualquiera);
		this.bonusVelocidad = new BonusVelocidad (puntoCualquiera);
		this.porcentajeVelocidadQueAumentaBonus = 0.2;
		this.porcentajeVelocidadDeDisparoQueAumentaBonus = 0.3;
	}
	
	public void testBonusVida(){
		int velocidadTanqueAntes = this.tanque.getVelocidad();
		int velocidadDisparoTanqueAntes = this.tanque.getVelocidadDisparo();
		
		this.bonusVelocidad.chocarConTanque(this.tanque); 
		
		int velocidadTanqueDespues = this.tanque.getVelocidad();
		int velocidadDisparoTanqueDespues = this.tanque.getVelocidadDisparo();
		
		assertTrue( (velocidadTanqueAntes += velocidadTanqueAntes*porcentajeVelocidadQueAumentaBonus) == velocidadTanqueDespues);
		assertTrue( (velocidadDisparoTanqueAntes += velocidadDisparoTanqueAntes*porcentajeVelocidadDeDisparoQueAumentaBonus) == velocidadDisparoTanqueDespues);

	}
}

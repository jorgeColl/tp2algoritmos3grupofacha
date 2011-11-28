package ar.uba.fi.algo3.modelo.pruebasIntegracion;

import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.objetosInanimados.BonusVelocidad;
import ar.uba.fi.algo3.modelo.objetosInanimados.BonusVida;
import ar.uba.fi.algo3.modelo.objetosInanimados.ParedConcreto;
import ar.uba.fi.algo3.modelo.objetosInanimados.ParedMetal;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import ar.uba.fi.algo3.modelo.tanques.GrizzlyBattleTank;
import ar.uba.fi.algo3.modelo.tanques.IFV;
import ar.uba.fi.algo3.modelo.tanques.MirageTank;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas de integración de AlgoTank.
 * @author Tomás
 *
 */
public class PruebasIntegracionGrizzlyBattleTank extends TestCase {

	private GrizzlyBattleTank tanque;
	
	protected void setUp() throws Exception {
		super.setUp();
		Espacio.getInstancia().reiniciar();
	}
	
	/**
	 * Hago mover al tanque hasta que impacte con un BonusVelocidad y testeo que sus velocidades mejoren en el valor esperado.
	 */
	public void testGrizzlyBattleTankMejorarVelocidades() {
		tanque = new GrizzlyBattleTank(new Posicion(0,0));
		BonusVelocidad bonus = new BonusVelocidad(new Posicion(250,0));
		int velocidad = tanque.getVelocidad();
		int velocidadDisparo = tanque.getVelocidadDisparo();
		while (tanque.getOcupacion().getLimiteDerecho() < bonus.getOcupacion().getLimiteIzquierdo()) {
			tanque.moverDerecha();
		}
		assertEquals(tanque.getVelocidad(),(int)(velocidad+(velocidad*20/100)));
		assertEquals(tanque.getVelocidadDisparo(),(int)(velocidadDisparo+(velocidadDisparo*30/100)));
	}

	/**
	 * Hago mover al tanque hasta que impacte con un BonusVida y testeo que su resistencia mejore en el valor esperado.
	 */
	public void testGrizzlyBattleTankMejorarResistencia() {
		tanque = new GrizzlyBattleTank(new Posicion(0,0));
		BonusVida bonus = new BonusVida(new Posicion(250,0));
		int resistencia = tanque.getResistencia();
		while (tanque.getOcupacion().getLimiteDerecho() < bonus.getOcupacion().getLimiteIzquierdo()) {
			tanque.moverDerecha();
		}
		assertEquals(tanque.getResistencia(),(int)(resistencia+(resistencia*40/100)));
	}
	
	/* A CONTINUACIÓN PRUEBO LOS CHOQUES CON TODOS LOS TANQUES.
	 * PARA HACERLO MÁS GENERAL HAGO QUE LOS CHOQUE DESDE DISTINTAS POSICIONES RELATIVAS ASÍ DE PASO SE PRUEBAN TODAS.
	 */
	
	/**
	 * Hago chocar al tanque con una instancia de AlgoTank y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testGrizzlyBattleTankChocarConAlgoTankDesdeArriba() {
		AlgoTank otroTanque = new AlgoTank(new Posicion(0,0));
		tanque = new GrizzlyBattleTank(new Posicion(0,((OcupacionCuadrada)otroTanque.getOcupacion()).getLado()));
		tanque.moverArriba();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),((OcupacionCuadrada)tanque.getOcupacion()).getLado());
	}
	
	
	/**
	 * Hago chocar al tanque con una instancia de GrizzlyBattleTank y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testGrizzlyBattleTankChocarConGrizzlyBattleTankDesdeArriba() {
		tanque = new GrizzlyBattleTank(new Posicion(0,0));
		GrizzlyBattleTank otroTanque = new GrizzlyBattleTank(new Posicion(0,((OcupacionCuadrada)tanque.getOcupacion()).getLado()));
		tanque.moverAbajo();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/**
	 * Hago chocar al tanque con una instancia de IFV y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testGrizzlyBattleTankChocarConIFVDesdeIzquierda() {
		tanque = new GrizzlyBattleTank(new Posicion(0,0));
		IFV otroTanque = new IFV(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado(),0));
		tanque.moverDerecha();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/**
	 * Hago chocar al tanque con una instancia de MirageTank y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testGrizzlyBattleTankChocarConMirageTankDesdeDerecha() {
		MirageTank otroTanque = new MirageTank(new Posicion(0,0));
		tanque = new GrizzlyBattleTank(new Posicion(((OcupacionCuadrada)otroTanque.getOcupacion()).getLado(),0));
		tanque.moverIzquierda();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),((OcupacionCuadrada)otroTanque.getOcupacion()).getLado());
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}

	/* HAGO QUE CHOQUE CON TODOS LOS TIPOS DE PARED DESDE DISTINTAS POSICIONES RELATIVAS */
	
	/**
	 * Hago chocar al tanque con una instancia de ParedConcreto y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testGrizzlyBattleTankChocarConParedConcretoDesdeIzquierda() {
		tanque = new GrizzlyBattleTank(new Posicion(0,0));
		ParedConcreto pared = new ParedConcreto(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado(),0));
		tanque.moverDerecha();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/**
	 * Hago chocar al tanque con una instancia de ParedMetal y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testGrizzlyBattleTankChocarConParedMetalDesdeDerecha() {
		ParedMetal pared = new ParedMetal(new Posicion(0,0));
		tanque = new GrizzlyBattleTank(new Posicion(((OcupacionCuadrada)pared.getOcupacion()).getLado(),0));
		tanque.moverIzquierda();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),((OcupacionCuadrada)pared.getOcupacion()).getLado());
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/**
	 * Hago que el tanque viva reiteradamente disparando a AlgoTank hasta que este desaparezca.
	 */
	//public void testGrizzlyBattleTankDestruirAlgoTankDisparos() {
//		AlgoTank otroTanque = new AlgoTank(new Posicion(0,100));
		//tanque = new GrizzlyBattleTank(new Posicion(0,0));
		

	//}
	
}
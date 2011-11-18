package pruebas.pruebasIntegracion;

import modelo.armamentista.arma.Canion;
import modelo.armamentista.arma.LanzaCohetes;
import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.OcupacionCuadrada;
import modelo.manejoEspacial.Posicion;
import modelo.objetosInanimados.BonusVelocidad;
import modelo.objetosInanimados.BonusVida;
import modelo.objetosInanimados.ParedConcreto;
import modelo.objetosInanimados.ParedMetal;
import modelo.tanques.AlgoTank;
import modelo.tanques.GrizzlyBattleTank;
import modelo.tanques.IFV;
import modelo.tanques.MirageTank;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas de integración de AlgoTank.
 * @author Tomás
 *
 */
public class PruebasIntegracionAlgoTank extends TestCase {

	private AlgoTank tanque;
	
	protected void setUp() throws Exception {
		super.setUp();
		Espacio.getInstancia().reiniciar();
	}
	
	/**
	 * Hago mover al tanque hasta que impacte con un BonusVelocidad y testeo que sus velocidades mejoren en el valor esperado.
	 */
	public void testAlgoTankMejorarVelocidades() {
		tanque = new AlgoTank(new Posicion(0,0));
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
	public void testAlgoTankMejorarResistencia() {
		tanque = new AlgoTank(new Posicion(0,0));
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
	
	/*
	 * ALGO TANK NO PUEDE CHOCAR CON SÍ MISMO DADO QUE EL ESPACIO SÓLO TOLERA UNA INSTANCIA DE SU CLASE.
	 */
	
	/**
	 * Hago chocar al tanque con una instancia de GrizzlyBattleTank y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testAlgoTankChocarConGrizzlyBattleTankDesdeArriba() {
		tanque = new AlgoTank(new Posicion(0,0));
		GrizzlyBattleTank otroTanque = new GrizzlyBattleTank(new Posicion(0,((OcupacionCuadrada)tanque.getOcupacion()).getLado()));
		tanque.moverAbajo();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/**
	 * Hago chocar al tanque con una instancia de IFV y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testAlgoTankChocarConIFVDesdeIzquierda() {
		tanque = new AlgoTank(new Posicion(0,0));
		IFV otroTanque = new IFV(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado(),0));
		tanque.moverDerecha();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/**
	 * Hago chocar al tanque con una instancia de MirageTank y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testAlgoTankChocarConMirageTankDesdeDerecha() {
		MirageTank otroTanque = new MirageTank(new Posicion(0,0));
		tanque = new AlgoTank(new Posicion(((OcupacionCuadrada)otroTanque.getOcupacion()).getLado(),0));
		tanque.moverIzquierda();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),((OcupacionCuadrada)otroTanque.getOcupacion()).getLado());
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}

	/* HAGO QUE CHOQUE CON TODOS LOS TIPOS DE PARED DESDE DISTINTAS POSICIONES RELATIVAS */
	
	/**
	 * Hago chocar al tanque con una instancia de ParedConcreto y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testAlgoTankChocarConParedConcretoDesdeIzquierda() {
		tanque = new AlgoTank(new Posicion(0,0));
		ParedConcreto pared = new ParedConcreto(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado(),0));
		tanque.moverDerecha();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/**
	 * Hago chocar al tanque con una instancia de ParedMetal y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testAlgoTankChocarConParedMetalDesdeDerecha() {
		ParedMetal pared = new ParedMetal(new Posicion(0,0));
		tanque = new AlgoTank(new Posicion(((OcupacionCuadrada)pared.getOcupacion()).getLado(),0));
		tanque.moverIzquierda();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),((OcupacionCuadrada)pared.getOcupacion()).getLado());
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/* TESTEO SI AL SER DESTRUÍDOS LOS TANQUES ENEMIGOS QUE ENTREGAN MUNICIONES A ALGO TANK ESTO SE HACE CORRECTAMENTE */
	
	/**
	 * Chequeo que la munición inicial del cañón de una instancia de AlgoTank sea nula, y que luego de que desaparezca una instancia de IFV esta aumente.
	 */
	public void testAlgoTankAumentarMunicionCanionConDestruccionDeIFV() {
		tanque = new AlgoTank(new Posicion(0,0));
		IFV otroTanque = new IFV(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado(),0));
		int municionEsperada = ((Canion)otroTanque.getArma()).getMunicion();
		assertEquals(tanque.getCanion().getMunicion(),0);
		otroTanque.desaparecer();
		assertEquals(tanque.getCanion().getMunicion(),municionEsperada);
	}

	/**
	 * Chequeo que la munición inicial del lanza cohetes de una instancia de AlgoTank sea nula, y que luego de que desaparezca una instancia de MirageTank esta aumente.
	 */
	public void testAlgoTankAumentarMunicionLanzaCohetesConDestruccionDeMirageTank() {
		tanque = new AlgoTank(new Posicion(0,0));
		MirageTank otroTanque = new MirageTank(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado(),0));
		int municionEsperada = ((LanzaCohetes)otroTanque.getArma()).getMunicion();
		assertEquals(tanque.getLanzaCohetes().getMunicion(),0);
		otroTanque.desaparecer();
		assertEquals(tanque.getLanzaCohetes().getMunicion(),municionEsperada);
	}
}
package ar.uba.fi.algo3.modelo.pruebasUnitarias;

import ar.uba.fi.algo3.modelo.estrategias.estrategiasMovimiento.AlcanzarObjetivoBordes;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import ar.uba.fi.algo3.modelo.tanques.GrizzlyBattleTank;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase AlcanzarObjetivosBordes.
 * @author Tomás
 *
 */
public class PruebasAlcanzarObjetivoBordes extends TestCase {

	private GrizzlyBattleTank tanque;
	private AlgoTank objetivo;
	private AlcanzarObjetivoBordes estrategia;
	
	protected void setUp() throws Exception {
		super.setUp();
		Espacio.getInstancia().reiniciar();
		tanque = new GrizzlyBattleTank(new Posicion(5,10));
		objetivo = new AlgoTank(new Posicion(250,58));
		estrategia = new AlcanzarObjetivoBordes(tanque,objetivo);
	}
	
	/**
	 * Testeo si lo primero que hace el tanque cuando su estrategia le indica que se mueve es acercarse al borde lateral más cercano.
	 */
	public void testAlcanzarBorde() {
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getX(),4);
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getY(),10);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getX(),3);
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getY(),10);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getX(),2);
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getY(),10);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getX(),1);
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getY(),10);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getY(),10);
	}
	
	/**
	 * Testeo si luego de alcanzar al borde más cercano el objeto móvil se acerca a su objetivo verticalmente.
	 */
	public void testAlcanzarAObjetivoVerticalmente() {
		testAlcanzarBorde();
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getY(),11);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getY(),12);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getY(),13);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getY(),14);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getY(),15);
	}
	
	/**
	 * Testeo si antes de alcanzar a su objetivo la orientación del objeto móvil es una, pero después de alcanzarlo esta cambia, y al seguirle indicando que continúe moviéndose no lo hace porque ya llego a donde quería.
	 */
	public void testCambioOrientacionYNoContinuacionDeMovimiento() {
		testAlcanzarAObjetivoVerticalmente();
		assertEquals(tanque.getOrientacion(),Orientacion.jNegativo);
		int contador = 16;
		while (contador < 38) {
			estrategia.dedicirMovimiento();
			assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getX(),0);
			assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getY(),contador);
			++contador;
		}
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getY(),37);
		assertEquals(tanque.getOrientacion(),Orientacion.i);
	}
	
	/**
	 * Hago que el objetivo vuelva a salir de un lugar con coincidencia vertical con el objeto móvil, y testeo si el objeto móvil vuelve a moverse en busca de volver a una posición tal.
	 */
	public void testVolverAMoverse() {
		testCambioOrientacionYNoContinuacionDeMovimiento();
		objetivo.moverAbajo();
		objetivo.moverAbajo();
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getY(),38);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getY(),39);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getY(),40);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)(tanque.getOcupacion())).getPuntoMenorModulo().getY(),41);
		assertEquals(tanque.getOrientacion(),Orientacion.i);
	}
	
}

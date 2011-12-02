package ar.uba.fi.algo3.modelo.pruebasUnitarias;

import ar.uba.fi.algo3.modelo.estrategias.estrategiasMovimiento.AlcanzarObjetivoCentro;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import ar.uba.fi.algo3.modelo.tanques.MirageTank;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase AlcanzarObjetoCentro.
 * @author Tomás
 *
 */
public class PruebasAlcanzarObjetivoCentro extends TestCase {

	private AlgoTank objetivo;
	private MirageTank duenio;
	private AlcanzarObjetivoCentro estrategia;
	
	protected void setUp() throws Exception {
		super.setUp();
		Espacio.getInstancia().reiniciar();
		objetivo = new AlgoTank(new Posicion(350,212));
		duenio = new MirageTank(new Posicion(252,264));
		estrategia = new AlcanzarObjetivoCentro(duenio,objetivo);
	}
	
	/**
	 * Testeo que a medida que la estrategia hace mover al tanque este se acerque al centro del espacio.
	 */
	public void testAlcanzarCentro() {
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),254);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),264);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),256);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),264);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),258);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),264);
	}
	
	/**
	 * Testeo si luego de alcanzar el centro del espacio, comienza a moverse verticalmente en busca de coincidir ocupacionalmente el dicho eje con su objetivo.
	 */
	public void testAlcanzarVerticalmenteAObjetivo() {
		testAlcanzarCentro();
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),258);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),262);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),258);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),260);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),258);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),258);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),258);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),256);
	}
	
	/**
	 * Testeo si una vez alcanzado el objetivo verticalmente, el objeto no continúa moviéndose, y también que se oriente horizontalmente hacia él.
	 */
	public void testCambioOrientacionYNoContinuacionMovimiento() {
		testAlcanzarVerticalmenteAObjetivo();
		assertEquals(duenio.getOrientacion(),Orientacion.j);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),258);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),254);
		assertEquals(duenio.getOrientacion(),Orientacion.i);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),258);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),254);
	}
	
	/**
	 * Hago mover al objetivo y chequeo si luego el objeto móvil lo persigue adecuadamente, y una vez que lo alcanza se orienta hacia él adecuadamente.
	 */
	public void testVolverAPersecucionYNuevaOrientacionCorrecta() {
		testCambioOrientacionYNoContinuacionMovimiento();
		objetivo.moverArriba();
		objetivo.moverArriba();
		objetivo.moverArriba();
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),258);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),252);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),258);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(duenio.getOrientacion(),Orientacion.j);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),258);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),248);
		assertEquals(duenio.getOrientacion(),Orientacion.i);
	}
	
}

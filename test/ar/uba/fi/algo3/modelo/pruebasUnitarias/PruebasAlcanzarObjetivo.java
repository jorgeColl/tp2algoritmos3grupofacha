package ar.uba.fi.algo3.modelo.pruebasUnitarias;

import ar.uba.fi.algo3.modelo.estrategias.estrategiasMovimiento.AlcanzarObjetivo;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import ar.uba.fi.algo3.modelo.tanques.IFV;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase AlcanzarObjetivo.
 * @author Tomás
 *
 */
public class PruebasAlcanzarObjetivo extends TestCase {

	private IFV duenio;
	private AlgoTank objetivo;
	private AlcanzarObjetivo estrategia;
	
	protected void setUp() throws Exception {
		super.setUp();
		Espacio.getInstancia().reiniciar();
		duenio = new IFV(new Posicion(230,240));
		objetivo = new AlgoTank(new Posicion(298,300));
		estrategia = new AlcanzarObjetivo(duenio,objetivo);
	}
	
	/**
	 * Llevo a cabo movimientos que hagan que el objeto móvil se alinee con su objetivo.
	 */
	public void testAlcanzarAlineacionHorizontal() {
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),233);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),240);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),233);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),243);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),236);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),243);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),236);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),246);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),239);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),246);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),239);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),249);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),242);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),249);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),242);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),252);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),245);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),252);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),245);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),255);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),248);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),255);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),248);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),258);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),251);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),258);
	}
	
	/**
	 * En este momento ya alcanzo verticalmente a su objetivo, por lo que comienza a moverse sólo de manera horizontal.
	 */
	public void testMovimientoUnidireccionalHorizontal() {
		testAlcanzarAlineacionHorizontal();
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),254);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),258);
		estrategia.dedicirMovimiento();
		//A PARTIR DE AQUÍ SÓLO PUEDE MOVERSE UNA POSICIÓN PARA NO COINCIDIR ESPACIALMENTE CON SU OBJETIVO.
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),255);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),258);
		//AQUÍ YA LO ALCANZO Y POR LO TANTO SU POSICIÓN NO DEBE CAMBIAR.
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),255);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),258);
	}
	
	/**
	 * Hacemos que el objetivo realice una serie de movimientos y chequeamos si el objeto móvil lo sigue correctamente luego.
	 */
	public void testAlcanzarAlineacionDosVertical() {
		testMovimientoUnidireccionalHorizontal();
		int contador = 0;
		while (contador < 50) {
			objetivo.moverArriba();
			++contador;
		}
		contador = 0;
		while (contador < 4) {
			objetivo.moverDerecha();
			++contador;
		}
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),258);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),258);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),258);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),255);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),261);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),255);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),261);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),252);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),264);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),252);
	}
	
	/**
	 * En este momento ya alcanzo horizontalmente a su objetivo, por lo que comienza a moverse sólo de manera vertical.
	 */
	public void testMovimientoUnidireccionalVertical() {
		testAlcanzarAlineacionDosVertical();
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),264);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),249);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),264);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),246);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),264);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),243);
		//A PARTIR DE AQUÍ YA COMIENZA A CHOCAR CON SU OBJETIVO, POR LO QUE SU POSICIÓN NO CAMBIA
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),264);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),243);
	}
	
}

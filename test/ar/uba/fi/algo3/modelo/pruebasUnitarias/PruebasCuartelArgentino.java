package ar.uba.fi.algo3.modelo.pruebasUnitarias;

import ar.uba.fi.algo3.Nivel;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.objetosInanimados.CuartelArgentino;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase CuartelArgentino.
 * @author Jorge
 *
 */
public class PruebasCuartelArgentino extends TestCase {

	CuartelArgentino cuartel;
	
	protected void setUp() throws Exception {
		super.setUp();
		Espacio.getInstancia().reiniciar();
		cuartel = new CuartelArgentino(new Posicion(5,5));
	}
	
	/**
	 * Testeo que los atributos se hayan inicializado correctamente.
	 */
	public void testCuartelArgentinoCreacionCorrecta() {
		assertEquals(((OcupacionCuadrada)cuartel.getOcupacion()).getPuntoMenorModulo().getX(),5);
		assertEquals(((OcupacionCuadrada)cuartel.getOcupacion()).getPuntoMenorModulo().getY(),5);
		assertEquals(((OcupacionCuadrada)cuartel.getOcupacion()).getLado(),43);
	}
	
	/**
	 * Testeo si antes de desaparecer el cuartel el juego no est� perdido y si al desaparecer el juego se pierde.
	 */
	public void testJuegoPerdido() {
		new AlgoTank(new Posicion(250,250));
		Nivel.getInstancia().empezarNivel();
		assertFalse(Nivel.getInstancia().nivelPerdido());
		cuartel.desaparecer();
		assertTrue(Nivel.getInstancia().nivelPerdido());
	}
	
}

package pruebas.pruebasUnitarias;

import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.OcupacionCuadrada;
import modelo.manejoEspacial.Posicion;
import modelo.objetosInanimados.CuartelArgentino;
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
		assertEquals(((OcupacionCuadrada)cuartel.getOcupacion()).getLado(),5);
	}
	
	/**
	 * Testeo si antes de desaparecer el cuartel el juego no está perdido y si al desaparecer el juego se pierde.
	 */
	public void testJuegoPerdido() {
		assertFalse(Espacio.getInstancia().juegoPerdido());
		cuartel.desaparecer();
		assertTrue(Espacio.getInstancia().juegoPerdido());
	}
	
}

package pruebas;

import modelo.Posicion;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase Posicion.
 * @author Tomás
 *
 */
public class PruebasPosicion extends TestCase {

	private Posicion posicion;
	
	protected void setUp() throws Exception {
		super.setUp();
		posicion = new Posicion(3,4);
	}
	
	/**
	 * Testeo si los atributos se inicializaron correctamente.
	 */
	public void testCreacionValida() {
		assertEquals(posicion.getX(), 3);
		assertEquals(posicion.getY(), 4);
	}
	
	/**
	 * Testeo si el método modulo() devuelve el valor esperado.
	 */
	public void testModulo() {
		assertEquals(posicion.modulo(),5.0);
	}
	
	/**
	 * Testeo si la resta entre dos posiciones se hace correctamente.
	 */
	public void testResta() {
		Posicion posicionTest = posicion.restar(new Posicion(6,2));
		assertEquals(posicionTest.getX(),-3);
		assertEquals(posicionTest.getY(),2);
	}

}

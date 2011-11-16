package pruebas.pruebasUnitarias;

import modelo.manejoEspacial.Orientacion;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase Orientacion.
 * @author Tomás
 *
 */
public class PruebasOrientacion extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Testeo si los atributos de la orientacion i tienen los valores correctos.
	 */
	public void testOrientacionICreacionCorrecta() {
		assertEquals(Orientacion.i.getX(),1);
		assertEquals(Orientacion.i.getY(),0);
	}
	
	/**
	 * Testeo si los atributos de la orientacion iNegativo tienen los valores correctos.
	 */
	public void testOrientacionINegativoCreacionCorrecta() {
		assertEquals(Orientacion.iNegativo.getX(),-1);
		assertEquals(Orientacion.iNegativo.getY(),0);
	}
	
	/**
	 * Testeo si los atributos de la orientacion j tienen los valores correctos.
	 */
	public void testOrientacionJCreacionCorrecta() {
		assertEquals(Orientacion.j.getX(),0);
		assertEquals(Orientacion.j.getY(),1);
	}
	
	/**
	 * Testeo si los atributos de la orientacion jNegativo tienen los valores correctos.
	 */
	public void testOrientacionJNegativoCreacionCorrecta() {
		assertEquals(Orientacion.jNegativo.getX(),0);
		assertEquals(Orientacion.jNegativo.getY(),-1);
	}	
	
	
}

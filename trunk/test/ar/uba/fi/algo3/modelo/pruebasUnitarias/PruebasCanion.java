package ar.uba.fi.algo3.modelo.pruebasUnitarias;

import ar.uba.fi.algo3.modelo.armamentista.arma.Canion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase Canion.
 * @author Tom�s
 *
 */
public class PruebasCanion extends TestCase {

	private Canion canion;
	private AlgoTank duenio;
	
	protected void setUp() throws Exception {
		super.setUp();
		Espacio.getInstancia().reiniciar();
		duenio = new AlgoTank(new Posicion(5,5));
		canion = new Canion(duenio,5);
	}
	
	/**
	 * Testeo si los atributos se inicializaron correctamente.
	 */
	public void testCanionCreacionValida() {
		assertTrue(canion.getDuenio() == duenio);
		assertEquals(canion.getMunicion(),5);
	}

	/**
	 * Testeamos que a medida que el arma dispara la munici�n vaya disminuyendo correctamente.
	 */
	public void testCanionDisminucionMunicionConDisparos() {
		canion.disparar();
		assertEquals(canion.getMunicion(),4);
		canion.disparar();
		assertEquals(canion.getMunicion(),3);
		canion.disparar();
		assertEquals(canion.getMunicion(),2);
		canion.disparar();
		assertEquals(canion.getMunicion(),1);
		canion.disparar();
		assertEquals(canion.getMunicion(),0);
		canion.disparar();
		assertEquals(canion.getMunicion(),0);
	}
	
	/**
	 * Testeamos si el m�todo incrementar munici�n funciona como se espera.
	 */
	public void testCanionIncrementarMunicion() {
		canion.incrementarMunicion(7);
		assertEquals(canion.getMunicion(),12);
	}
	
}

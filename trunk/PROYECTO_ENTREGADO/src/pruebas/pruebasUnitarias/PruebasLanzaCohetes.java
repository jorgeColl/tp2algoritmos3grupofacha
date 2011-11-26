package pruebas.pruebasUnitarias;

import modelo.armamentista.arma.LanzaCohetes;
import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.Posicion;
import modelo.tanques.AlgoTank;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase LanzaCohetes.
 * @author Federico
 *
 */
public class PruebasLanzaCohetes extends TestCase {

	private LanzaCohetes lanzaCohetes;
	private AlgoTank duenio;
	
	protected void setUp() throws Exception {
		super.setUp();
		Espacio.getInstancia().reiniciar();
		duenio = new AlgoTank(new Posicion(5,5));
		lanzaCohetes = new LanzaCohetes(duenio,3);
	}
	
	/**
	 * Testeo si los atributos se inicializaron correctamente.
	 */
	public void testLanzaCohetesCreacionValida() {
		assertTrue(lanzaCohetes.getDuenio() == duenio);
		assertEquals(lanzaCohetes.getMunicion(),3);
	}

	/**
	 * Testeamos que a medida que el arma dispara la munición vaya disminuyendo correctamente.
	 */
	public void testLanzaCohetesDisminucionMunicionConDisparos() {
		lanzaCohetes.disparar();
		assertEquals(lanzaCohetes.getMunicion(),2);
		lanzaCohetes.disparar();
		assertEquals(lanzaCohetes.getMunicion(),1);
		lanzaCohetes.disparar();
		assertEquals(lanzaCohetes.getMunicion(),0);
		lanzaCohetes.disparar();
		assertEquals(lanzaCohetes.getMunicion(),0);
	}
	
	/**
	 * Testeamos si el método incrementar munición funciona como se espera.
	 */
	public void testLanzaCohetesIncrementarMunicion() {
		lanzaCohetes.incrementarMunicion(7);
		assertEquals(lanzaCohetes.getMunicion(),10);
	}
	
}

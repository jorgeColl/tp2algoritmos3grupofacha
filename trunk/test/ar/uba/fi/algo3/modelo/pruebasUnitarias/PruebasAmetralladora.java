package pruebas.pruebasUnitarias;

import modelo.armamentista.arma.Ametralladora;
import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.Posicion;
import modelo.tanques.AlgoTank;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase Ametralladora.
 * @author Tomás
 *
 */
public class PruebasAmetralladora extends TestCase {

	private Ametralladora ametralladora;
	private AlgoTank duenio;
	
	protected void setUp() throws Exception {
		super.setUp();
		Espacio.getInstancia().reiniciar();
		duenio = new AlgoTank(new Posicion(5,5));
		ametralladora = new Ametralladora(duenio);
	}
	
	/**
	 * Testeo si los atributos se inicializaron correctamente.
	 */
	public void testAmetralladoraCreacionValida() {
		assertTrue(ametralladora.getDuenio() == duenio);
	}
	
}

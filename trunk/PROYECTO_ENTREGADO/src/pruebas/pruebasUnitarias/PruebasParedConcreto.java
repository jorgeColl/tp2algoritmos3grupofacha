package pruebas.pruebasUnitarias;

import modelo.armamentista.disparo.DisparoAmetralladora;
import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.Orientacion;
import modelo.manejoEspacial.Posicion;
import modelo.objetosInanimados.ParedConcreto;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase ParedConcreto.
 * @author Jorge
 *
 */
public class PruebasParedConcreto extends TestCase {

	private ParedConcreto pared;
	
	protected void setUp() throws Exception {
		super.setUp();
		Espacio.getInstancia().reiniciar();
		pared = new ParedConcreto(new Posicion(250,250));
	}
	
	/**
	 * Testeo si las paredes están incluídas inicialmente en el espacio, y si luego de recibir un impacto desaparece.
	 * Como agrego al disparo en una ocupación coincidente con la de la pared, ya lo choca automáticamente.
	 */
	public void testDesaparecerConImpacto() {
		assertTrue(Espacio.getInstancia().incluyeA(pared));
		DisparoAmetralladora disparo = new DisparoAmetralladora(Orientacion.i, new Posicion(250,250));
		assertFalse(Espacio.getInstancia().incluyeA(pared));
	}

}
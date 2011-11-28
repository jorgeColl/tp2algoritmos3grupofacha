package pruebas.pruebasUnitarias;

import modelo.armamentista.disparo.DisparoAmetralladora;
import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.Orientacion;
import modelo.manejoEspacial.Posicion;
import modelo.objetosInanimados.ParedMetal;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase ParedParedMetal.
 * @author Tomás
 *
 */
public class PruebasParedMetal extends TestCase {

	private ParedMetal pared;
	
	protected void setUp() throws Exception {
		super.setUp();
		Espacio.getInstancia().reiniciar();
		pared = new ParedMetal(new Posicion(250,250));
	}
	
	/**
	 * Testeo si la pared no desaparece con un solo impacto.
	 * Como agrego al disparo en una ocupación coincidente con la de la pared, ya lo choca automáticamente.
	 */
	public void testNoDesaparicionConUnImpacto() {
		assertTrue(Espacio.getInstancia().incluyeA(pared));
		DisparoAmetralladora disparo = new DisparoAmetralladora(Orientacion.i, new Posicion(250,250));
		assertTrue(Espacio.getInstancia().incluyeA(pared));
	}
	
	/**
	 * Testeo si las paredes están incluídas inicialmente en el espacio, y si luego de recibir dos impactos desaparece.
	 * Como agrego a los disparos en ocupaciones coincidentes con la de la pared, ya lo chocan automáticamente.
	 */
	public void testDesaparecerConImpacto() {
		assertTrue(Espacio.getInstancia().incluyeA(pared));
		DisparoAmetralladora disparo = new DisparoAmetralladora(Orientacion.i, new Posicion(250,250));
		DisparoAmetralladora disparoDos = new DisparoAmetralladora(Orientacion.i, new Posicion(250,250));
		assertFalse(Espacio.getInstancia().incluyeA(pared));
	}

}
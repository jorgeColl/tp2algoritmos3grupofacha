package pruebas.pruebasUnitarias;

import modelo.armamentista.disparo.DisparoAmetralladora;
import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.Orientacion;
import modelo.manejoEspacial.Posicion;
import modelo.tanques.AlgoTank;
import modelo.tanques.GrizzlyBattleTank;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase Espacio.
 * @author Samanta
 *
 */
public class PruebasEspacio extends TestCase {
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Testeo si los atributos se inicializaron correctamente.
	 */
	public void testCreacionValida() {
		assertEquals(Espacio.getInstancia().getLimiteDerecho(), 601);
		assertEquals(Espacio.getInstancia().getLimiteInferior(), 601);
	}
	
	/**
	 * Pruebo si obteniendo dos veces la instancia de Espacio obtengo al mismo objeto.
	 */
	public void testUnicaInstancia() {
		assertTrue(Espacio.getInstancia() == Espacio.getInstancia());
	}
	
	/**
	 * Testeo si instanciando un disparo el mismo está luego incluído en el espacio.
	 */
	public void testAgregarDisparo() {
		Espacio.getInstancia().reiniciar();
		DisparoAmetralladora disparo = new DisparoAmetralladora(Orientacion.i, new Posicion(5,5));
		assertTrue(Espacio.getInstancia().incluyeA(disparo));
	}
	
	/**
	 * Testeo instanciando un tanque de jugador el mismo está incluído en el espacio.
	 */
	public void testAgregarTanqueJugador() {
		Espacio.getInstancia().reiniciar();
		AlgoTank tanque = new AlgoTank(new Posicion(5,5));
		assertTrue(Espacio.getInstancia().incluyeA(tanque));
	}

	/**
	 * Testeo instanciando un tanque enemigo el mismo está incluído en el espacio.
	 */
	public void testAgregarTanqueEnemigo() {
		Espacio.getInstancia().reiniciar();
		GrizzlyBattleTank tanque = new GrizzlyBattleTank(new Posicion(5,5));
		assertTrue(Espacio.getInstancia().incluyeA(tanque));
	}
	
	/**
	 * Testeo si instanciando un disparo y luego desapareciéndolo, el mismo no está incluído en el espacio.
	 */
	public void testDesaparecerDisparo() {
		Espacio.getInstancia().reiniciar();
		DisparoAmetralladora disparo = new DisparoAmetralladora(Orientacion.i, new Posicion(5,5));
		Espacio.getInstancia().desaparecerA(disparo);
		assertFalse(Espacio.getInstancia().incluyeA(disparo));
	}
	
	/**
	 * Testeo si instanciando un tanque de jugador y luego desapareciéndolo, el mismo no está incluído en el espacio.
	 */
	public void testDesaparecerTanqueJugador() {
		Espacio.getInstancia().reiniciar();
		AlgoTank tanque = new AlgoTank(new Posicion(5,5));
		Espacio.getInstancia().desaparecerA(tanque);
		assertFalse(Espacio.getInstancia().incluyeA(tanque));
	}

	/**
	 * Testeo si instanciando un tanque de enemigo y luego desapareciéndolo, el mismo no está incluído en el espacio.
	 */
	public void testDesaparecerTanqueEnemigo() {
		Espacio.getInstancia().reiniciar();
		GrizzlyBattleTank tanque = new GrizzlyBattleTank(new Posicion(5,5));
		Espacio.getInstancia().desaparecerA(tanque);
		assertFalse(Espacio.getInstancia().incluyeA(tanque));
	}
	
	/**
	 * Instancio varios objetos de juego, luego reinicio el espacio y testeo que no estén incluídos en este.
	 */
	public void testReiniciar() {
		Espacio.getInstancia().reiniciar();
		DisparoAmetralladora disparo = new DisparoAmetralladora(Orientacion.i, new Posicion(5,5));
		AlgoTank tanque = new AlgoTank(new Posicion(50,50));
		GrizzlyBattleTank tanqueEnemigo = new GrizzlyBattleTank(new Posicion(150,150));
		Espacio.getInstancia().reiniciar();
		assertFalse(Espacio.getInstancia().incluyeA(disparo));
		assertFalse(Espacio.getInstancia().incluyeA(tanque));
		assertFalse(Espacio.getInstancia().incluyeA(tanqueEnemigo));
	}
	
}

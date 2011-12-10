package ar.uba.fi.algo3.modelo.pruebasUnitarias;

import ar.uba.fi.algo3.modelo.armamentista.disparo.DisparoAmetralladora;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.objetosInanimados.BonusVida;
import ar.uba.fi.algo3.modelo.objetosInanimados.CuartelArgentino;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import ar.uba.fi.algo3.modelo.tanques.GrizzlyBattleTank;
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
	 * Testeo si instanciando un disparo el mismo estï¿½ luego incluï¿½do en el espacio.
	 */
	public void testAgregarDisparo() {
		Espacio.getInstancia().reiniciar();
		DisparoAmetralladora disparo = new DisparoAmetralladora(Orientacion.i, new Posicion(50,50));
		assertTrue(Espacio.getInstancia().incluyeA(disparo));
	}
	
	/**
	 * Testeo instanciando un tanque de jugador el mismo estï¿½ incluï¿½do en el espacio.
	 */
	public void testAgregarTanqueJugador() {
		Espacio.getInstancia().reiniciar();
		AlgoTank tanque = new AlgoTank(new Posicion(5,5));
		assertTrue(Espacio.getInstancia().incluyeA(tanque));
	}

	/**
	 * Testeo instanciando un tanque enemigo el mismo estï¿½ incluï¿½do en el espacio.
	 */
	public void testAgregarTanqueEnemigo() {
		Espacio.getInstancia().reiniciar();
		GrizzlyBattleTank tanque = new GrizzlyBattleTank(new Posicion(5,5));
		assertTrue(Espacio.getInstancia().incluyeA(tanque));
	}
	
	/**
	 * Testeo si instanciando un disparo y luego desapareciï¿½ndolo, el mismo no estï¿½ incluï¿½do en el espacio.
	 */
	public void testDesaparecerDisparo() {
		Espacio.getInstancia().reiniciar();
		DisparoAmetralladora disparo = new DisparoAmetralladora(Orientacion.i, new Posicion(5,5));
		Espacio.getInstancia().desaparecerA(disparo);
		assertFalse(Espacio.getInstancia().incluyeA(disparo));
	}
	
	/**
	 * Testeo si instanciando un tanque de jugador y luego desapareciï¿½ndolo, el mismo no estï¿½ incluï¿½do en el espacio.
	 */
	public void testDesaparecerTanqueJugador() {
		Espacio.getInstancia().reiniciar();
		AlgoTank tanque = new AlgoTank(new Posicion(5,5));
		Espacio.getInstancia().desaparecerA(tanque);
		assertFalse(Espacio.getInstancia().incluyeA(tanque));
	}

	/**
	 * Testeo si instanciando un tanque de enemigo y luego desapareciï¿½ndolo, el mismo no estï¿½ incluï¿½do en el espacio.
	 */
	public void testDesaparecerTanqueEnemigo() {
		Espacio.getInstancia().reiniciar();
		GrizzlyBattleTank tanque = new GrizzlyBattleTank(new Posicion(5,5));
		Espacio.getInstancia().desaparecerA(tanque);
		assertFalse(Espacio.getInstancia().incluyeA(tanque));
	}
	
	/**
	 * Instancio varios objetos de juego, luego reinicio el espacio y testeo que no estï¿½n incluï¿½dos en este.
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
	
	/*
	 * Corrijo la prueba planteada por Jorge.
	 * La cuestión es que el segundo tanque enemigo no puede ser agregado, lo cual se demuestra con el lanzado de una excepción.
	 * No se puede chequear el lanzado de la excepción porque se resuelve internamente en el constructor de los objetos. 
	 */
	/**
	 * Testeo que se pueda agregar un objeto de cada tipo al espacio correctamente.
	 */
	public void testIncluyeA() {
		Espacio.getInstancia().reiniciar();
		AlgoTank tanqueJugador = new AlgoTank(new Posicion(0,0));
		GrizzlyBattleTank tanqueEnemigo = new GrizzlyBattleTank(new Posicion(50,50));
		CuartelArgentino cuartel = new CuartelArgentino(new Posicion(100,100));
		BonusVida objetoInanimado = new BonusVida(new Posicion(150,150));
		assertTrue(Espacio.getInstancia().incluyeA(tanqueJugador));
		assertTrue(Espacio.getInstancia().incluyeA(tanqueEnemigo));
		assertTrue(Espacio.getInstancia().incluyeA(cuartel));
		assertTrue(Espacio.getInstancia().incluyeA(objetoInanimado));
	}
	
}

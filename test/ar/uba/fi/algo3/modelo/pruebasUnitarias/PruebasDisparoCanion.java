package ar.uba.fi.algo3.modelo.pruebasUnitarias;

import ar.uba.fi.algo3.modelo.armamentista.disparo.DisparoCanion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase DisparoCanion.
 * @author Tomás
 *
 */
public class PruebasDisparoCanion extends TestCase {

	DisparoCanion disparo;
	
	protected void setUp() throws Exception {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoCanion(Orientacion.i, new Posicion(15,15));
		super.setUp();
	}
	
	/**
	 * Testeo si los atributos se inicializaron correctamente.
	 */
	public void testDisparoCanionCreacionCorrecta() {
		assertEquals(disparo.getOrientacion(),Orientacion.i);
		assertEquals(disparo.getVelocidad(),4);
		assertEquals(disparo.getDanioNeto(),30);
		assertEquals(disparo.getDanioPorcentual(),0);
		OcupacionCuadrada ocupacionAuxiliar = (OcupacionCuadrada)disparo.getOcupacion();
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getX(),15);
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getY(),15);
		assertEquals(ocupacionAuxiliar.getLado(),1);
	}
	
	/**
	 * Ubico a un disparo en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia la derecha su nueva ocupación sea la esperada.
	 */
	public void testDisparoCanionMovimientoEstandarDerecha() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoCanion(Orientacion.i,new Posicion(250,250));
		disparo.moverDerecha();
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getX(),254);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getLado(),((OcupacionCuadrada)disparo.getOcupacion()).getLado());
	}

	/**
	 * Ubico a un disparo en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia arriba su nueva ocupación sea la esperada.
	 */
	public void testDisparoCanionMovimientoEstandarArriba() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoCanion(Orientacion.j,new Posicion(250,250));
		disparo.moverArriba();
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getY(),246);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getLado(),((OcupacionCuadrada)disparo.getOcupacion()).getLado());
	}
	
	/**
	 * Ubico a un disparo en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia la izquierda su nueva ocupación sea la esperada.
	 */
	public void testDisparoCanionMovimientoEstandarIzquierda() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoCanion(Orientacion.iNegativo,new Posicion(250,250));
		disparo.moverIzquierda();
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getX(),246);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getLado(),((OcupacionCuadrada)disparo.getOcupacion()).getLado());
	}
	
	/**
	 * Ubico a un disparo en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia abajo su nueva ocupación sea la esperada.
	 */
	public void testDisparoCanionMovimientoEstandarAbajo() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoCanion(Orientacion.jNegativo,new Posicion(250,250));
		disparo.moverAbajo();
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getY(),254);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getLado(),((OcupacionCuadrada)disparo.getOcupacion()).getLado());
	}
	
	/**
	 * Ubico al disparo en una posición límite a derecha y chequeo que al moverse a la derecha haya desaparecido del espacio.
	 */
	public void testDisparoCanionMovimientoInvalidoDerecha() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoCanion(Orientacion.i, new Posicion(Espacio.getInstancia().getLimiteDerecho()-((OcupacionCuadrada)disparo.getOcupacion()).getLado()+1,250));
		assertTrue(Espacio.getInstancia().incluyeA(disparo));
		disparo.moverDerecha();
		assertFalse(Espacio.getInstancia().incluyeA(disparo));		
	}
	
	/**
	 * Ubico al disparo en una posición límite hacia arriba y chequeo que al moverse hacia arriba haya desaparecido del espacio.
	 */
	public void testDisparoCanionMovimientoInvalidoArriba() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoCanion(Orientacion.j, new Posicion(250,0));
		assertTrue(Espacio.getInstancia().incluyeA(disparo));
		disparo.moverArriba();
		assertFalse(Espacio.getInstancia().incluyeA(disparo));		
	}
	
	/**
	 * Ubico al disparo en una posición límite a izquierda y chequeo que al moverse a la izquierda haya desaparecido del espacio.
	 */
	public void testDisparoCanionMovimientoInvalidoIzquierda() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoCanion(Orientacion.iNegativo, new Posicion(0,250));
		assertTrue(Espacio.getInstancia().incluyeA(disparo));
		disparo.moverIzquierda();
		assertFalse(Espacio.getInstancia().incluyeA(disparo));		
	}

	/**
	 * Ubico al disparo en una posición hacia abajo y chequeo que al moverse hacia abajo haya desaparecido del espacio.
	 */
	public void testDisparoCanionMovimientoInvalidoAbajo() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoCanion(Orientacion.j, new Posicion(250,Espacio.getInstancia().getLimiteInferior()-((OcupacionCuadrada)disparo.getOcupacion()).getLado()+1));
		assertTrue(Espacio.getInstancia().incluyeA(disparo));
		disparo.moverAbajo();
		assertFalse(Espacio.getInstancia().incluyeA(disparo));		
	}

	/**
	 * Testeo si al invocarle el método vivir a un disparo con orientación j se mueve hacia arriba en la manera esperada.
	 */
	public void testDisparoCanionVivirArriba() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoCanion(Orientacion.j, new Posicion(250,250));
		disparo.vivir();
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getY(),246);
	}
	
	/**
	 * Testeo si al invocarle el método vivir a un disparo con orientación jNegativo se mueve hacia abajo en la manera esperada.
	 */
	public void testDisparoCanionVivirAbajo() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoCanion(Orientacion.jNegativo, new Posicion(250,250));
		disparo.vivir();
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getY(),254);
	}
	
	/**
	 * Testeo si al invocarle el método vivir a un disparo con orientación i se mueve hacia la derecha en la manera esperada.
	 */
	public void testDisparoCanionVivirDerecha() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoCanion(Orientacion.i, new Posicion(250,250));
		disparo.vivir();
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getX(),254);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getY(),250);
	}

	/**
	 * Testeo si al invocarle el método vivir a un disparo con orientación iNegativo se mueve hacia la izquierda en la manera esperada.
	 */
	public void testDisparoCanionVivirIzquierda() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoCanion(Orientacion.iNegativo, new Posicion(250,250));
		disparo.vivir();
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getX(),246);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getY(),250);
	}
	
}
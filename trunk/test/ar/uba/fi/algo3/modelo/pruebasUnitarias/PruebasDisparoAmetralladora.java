package ar.uba.fi.algo3.modelo.pruebasUnitarias;

import ar.uba.fi.algo3.modelo.armamentista.disparo.DisparoAmetralladora;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase DisparoAmetralladora.
 * @author Federico
 *
 */
public class PruebasDisparoAmetralladora extends TestCase {

	DisparoAmetralladora disparo;
	
	protected void setUp() throws Exception {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoAmetralladora(Orientacion.i, new Posicion(10,10));
		super.setUp();
	}
	
	/**
	 * Testeo si los atributos se inicializaron correctamente.
	 */
	public void testDisparoAmetralladoraCreacionCorrecta() {
		assertEquals(disparo.getOrientacion(),Orientacion.i);
		assertEquals(disparo.getVelocidad(),4);
		assertEquals(disparo.getDanioNeto(),20);
		assertEquals(disparo.getDanioPorcentual(),0);
		OcupacionCuadrada ocupacionAuxiliar = (OcupacionCuadrada)disparo.getOcupacion();
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getX(),10);
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getY(),3);
		assertEquals(ocupacionAuxiliar.getLado(),15);
	}
	
	/**
	 * Ubico a un disparo en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia la derecha su nueva ocupación sea la esperada.
	 */
	public void testDisparoAmetralladoraMovimientoEstandarDerecha() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoAmetralladora(Orientacion.i,new Posicion(250,250));
		disparo.moverDerecha();
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getX(),254);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getY(),243);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getLado(),((OcupacionCuadrada)disparo.getOcupacion()).getLado());
	}

	/**
	 * Ubico a un disparo en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia arriba su nueva ocupación sea la esperada.
	 */
	public void testDisparoAmetralladoraMovimientoEstandarArriba() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoAmetralladora(Orientacion.j,new Posicion(250,250));
		disparo.moverArriba();
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getX(),243);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getY(),232);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getLado(),((OcupacionCuadrada)disparo.getOcupacion()).getLado());
	}
	
	/**
	 * Ubico a un disparo en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia la izquierda su nueva ocupación sea la esperada.
	 */
	public void testDisparoAmetralladoraMovimientoEstandarIzquierda() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoAmetralladora(Orientacion.iNegativo,new Posicion(250,250));
		disparo.moverIzquierda();
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getX(),232);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getY(),243);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getLado(),((OcupacionCuadrada)disparo.getOcupacion()).getLado());
	}
	
	/**
	 * Ubico a un disparo en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia abajo su nueva ocupación sea la esperada.
	 */
	public void testDisparoAmetralladoraMovimientoEstandarAbajo() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoAmetralladora(Orientacion.jNegativo,new Posicion(250,250));
		disparo.moverAbajo();
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getX(),243);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getY(),254);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getLado(),((OcupacionCuadrada)disparo.getOcupacion()).getLado());
	}

	/**
	 * Ubico al disparo en una posición límite a derecha y chequeo que al moverse a la derecha haya desaparecido del espacio.
	 */
	public void testDisparoAmetralladoraMovimientoInvalidoDerecha() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoAmetralladora(Orientacion.i, new Posicion(Espacio.getInstancia().getLimiteDerecho()-((OcupacionCuadrada)disparo.getOcupacion()).getLado()+1,250));
		assertTrue(Espacio.getInstancia().incluyeA(disparo));
		disparo.moverDerecha();
		assertFalse(Espacio.getInstancia().incluyeA(disparo));		
	}
	
	/**
	 * Ubico al disparo en una posición límite hacia arriba y chequeo que al moverse hacia arriba haya desaparecido del espacio.
	 */
	public void testDisparoAmetralladoraMovimientoInvalidoArriba() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoAmetralladora(Orientacion.j, new Posicion(250,14));
		assertTrue(Espacio.getInstancia().incluyeA(disparo));
		disparo.moverArriba();
		assertFalse(Espacio.getInstancia().incluyeA(disparo));		
	}
	
	/**
	 * Ubico al disparo en una posición límite a izquierda y chequeo que al moverse a la izquierda haya desaparecido del espacio.
	 */
	public void testDisparoAmetralladoraMovimientoInvalidoIzquierda() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoAmetralladora(Orientacion.iNegativo, new Posicion(14,250));
		assertTrue(Espacio.getInstancia().incluyeA(disparo));
		disparo.moverIzquierda();
		assertFalse(Espacio.getInstancia().incluyeA(disparo));		
	}

	/**
	 * Ubico al disparo en una posición hacia abajo y chequeo que al moverse hacia abajo haya desaparecido del espacio.
	 */
	public void testDisparoAmetralladoraMovimientoInvalidoAbajo() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoAmetralladora(Orientacion.jNegativo, new Posicion(250,587));
		assertTrue(Espacio.getInstancia().incluyeA(disparo));
		disparo.moverAbajo();
		assertFalse(Espacio.getInstancia().incluyeA(disparo));		
	}
	
	/**
	 * Testeo si al invocarle el método vivir a un disparo con orientación j se mueve hacia arriba en la manera esperada.
	 */
	public void testDisparoAmetralladoraVivirArriba() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoAmetralladora(Orientacion.j, new Posicion(250,250));
		disparo.vivir();
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getX(),243);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getY(),232);
	}
	
	/**
	 * Testeo si al invocarle el método vivir a un disparo con orientación jNegativo se mueve hacia abajo en la manera esperada.
	 */
	public void testDisparoAmetralladoraVivirAbajo() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoAmetralladora(Orientacion.jNegativo, new Posicion(250,250));
		disparo.vivir();
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getX(),243);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getY(),254);
	}
	
	/**
	 * Testeo si al invocarle el método vivir a un disparo con orientación i se mueve hacia la derecha en la manera esperada.
	 */
	public void testDisparoAmetralladoraVivirDerecha() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoAmetralladora(Orientacion.i, new Posicion(250,250));
		disparo.vivir();
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getX(),254);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getY(),243);
	}

	/**
	 * Testeo si al invocarle el método vivir a un disparo con orientación iNegativo se mueve hacia la izquierda en la manera esperada.
	 */
	public void testDisparoAmetralladoraVivirIzquierda() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoAmetralladora(Orientacion.iNegativo, new Posicion(250,250));
		disparo.vivir();
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getX(),232);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getY(),243);
	}
	
}

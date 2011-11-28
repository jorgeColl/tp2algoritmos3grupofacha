package ar.uba.fi.algo3.modelo.pruebasUnitarias;

import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.GrizzlyBattleTank;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase GrizzlyBattleTank.
 * @author Tomás
 *
 */
public class PruebasGrizzlyBattleTank extends TestCase {

	private GrizzlyBattleTank tanqueTest;
	
	protected void setUp() throws Exception {
		super.setUp();
		Espacio.getInstancia().reiniciar();
		tanqueTest = new GrizzlyBattleTank(new Posicion(5,5));
	}
	
	/**
	 * Testeamos si los atributos se inicializaron correctamente.
	 */
	public void testGrizzlyBattleTankCreacionValida() {
		OcupacionCuadrada ocupacionAuxiliar = (OcupacionCuadrada)tanqueTest.getOcupacion();
		assertEquals(tanqueTest.getOrientacion(),Orientacion.jNegativo);
		assertEquals(tanqueTest.getVelocidad(),1);
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getX(),5);
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getY(),5);
		assertEquals(ocupacionAuxiliar.getLado(),5);
		assertEquals(tanqueTest.getResistencia(),100);
		assertEquals(tanqueTest.getPuntosPorDestruccion(),20);
	}
	
	/**
	 * Ubico a un GrizzlyBattleTank en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia la derecha su nueva ocupación sea la esperada.
	 */
	public void testGrizzlyBattleTankMovimientoEstandarDerecha() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new GrizzlyBattleTank(new Posicion(250,250));
		tanqueTest.moverDerecha();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),251);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.i);
	}

	/**
	 * Ubico a un GrizzlyBattleTank en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia arriba su nueva ocupación sea la esperada.
	 */
	public void testGrizzlyBattleTankMovimientoEstandarArriba() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new GrizzlyBattleTank(new Posicion(250,250));
		tanqueTest.moverArriba();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),249);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.j);
	}
	
	/**
	 * Ubico a un GrizzlyBattleTank en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia la izquierda su nueva ocupación sea la esperada.
	 */
	public void testGrizzlyBattleTankMovimientoEstandarIzquierda() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new GrizzlyBattleTank(new Posicion(250,250));
		tanqueTest.moverIzquierda();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),249);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.iNegativo);
	}
	
	/**
	 * Ubico a un GrizzlyBattleTank en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia abajo su nueva ocupación sea la esperada.
	 */
	public void testGrizzlyBattleTankMovimientoEstandarAbajo() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new GrizzlyBattleTank(new Posicion(250,250));
		tanqueTest.moverAbajo();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),251);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.jNegativo);
	}

	/**
	 * Ubico al tanque en una posición límite a derecha y chequeo que al moverse a la derecha siga en su posición anterior.
	 */
	public void testGrizzlyBattleTankMovimientoInvalidoDerecha() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new GrizzlyBattleTank(new Posicion(Espacio.getInstancia().getLimiteDerecho()-((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado()+1,250));
		tanqueTest.moverDerecha();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),Espacio.getInstancia().getLimiteDerecho()-((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado()+1);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.i);		
	}
	
	/**
	 * Ubico al tanque en una posición límite hacia arriba y chequeo que al moverse a hacia arriba siga en su posición anterior.
	 */
	public void testGrizzlyBattleTankMovimientoInvalidoArriba() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new GrizzlyBattleTank(new Posicion(250,0));
		tanqueTest.moverArriba();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),0);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.j);		
	}
	
	/**
	 * Ubico al tanque en una posición límite a izquierda y chequeo que al moverse a la izquierda siga en su posición anterior.
	 */
	public void testGrizzlyBattleTankMovimientoInvalidoIzquierda() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new GrizzlyBattleTank(new Posicion(0,250));
		tanqueTest.moverIzquierda();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.iNegativo);		
	}

	/**
	 * Ubico al tanque en una posición límite hacia abajo y chequeo que al moverse a hacia abajo siga en su posición anterior.
	 */
	public void testGrizzlyBattleTankMovimientoInvalidoAbajo() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new GrizzlyBattleTank(new Posicion(250,Espacio.getInstancia().getLimiteInferior()-((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado()+1));
		tanqueTest.moverAbajo();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),Espacio.getInstancia().getLimiteInferior()-((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado()+1);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.jNegativo);		
	}
	
	/**
	 * Testeamos que el método moverEnDireccionContraria() mueva al tanque como se espera y que su orientacion no cambie. 
	 */
	public void testGrizzlyBattleTankMoverEnDireccionContrariaIzquierda() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new GrizzlyBattleTank(new Posicion(250,250));
		tanqueTest.moverIzquierda();
		tanqueTest.moverEnDireccionContraria();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.iNegativo);
	}
	
	/**
	 * Testeamos que el método moverEnDireccionContraria() mueva al tanque como se espera y que su orientacion no cambie. 
	 */
	public void testGrizzlyBattleTankMoverEnDireccionContrariaDerecha() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new GrizzlyBattleTank(new Posicion(250,250));
		tanqueTest.moverDerecha();
		tanqueTest.moverEnDireccionContraria();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.i);
	}
	
	/**
	 * Testeamos que el método moverEnDireccionContraria() mueva al tanque como se espera y que su orientacion no cambie. 
	 */
	public void testGrizzlyBattleTankMoverEnDireccionContrariaArriba() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new GrizzlyBattleTank(new Posicion(250,250));
		tanqueTest.moverArriba();
		tanqueTest.moverEnDireccionContraria();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.j);
	}
	
	/**
	 * Testeamos que el método moverEnDireccionContraria() mueva al tanque como se espera y que su orientacion no cambie. 
	 */
	public void testGrizzlyBattleTankMoverEnDireccionContrariaAbajo() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new GrizzlyBattleTank(new Posicion(250,250));
		tanqueTest.moverAbajo();
		tanqueTest.moverEnDireccionContraria();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.jNegativo);
	}

	/**
	 * Pruebo si al chocar con otra instancia de la misma clase la ocupación de ambas es la que tenían originalmente.
	 */
	public void testGrizzlyBattleTankChocarConGrizzlyBattleTankDesdeIzquierda() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new GrizzlyBattleTank(new Posicion(250,250));
		GrizzlyBattleTank tanqueDos = new GrizzlyBattleTank(new Posicion(255,250));
		tanqueTest.moverDerecha();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getX(),255);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}
	
	/**
	 * Pruebo si al chocar con otra instancia de la misma clase la ocupación de ambas es la que tenían originalmente.
	 */
	public void testGrizzlyBattleTankChocarConGrizzlyBattleTankDesdeDerecha() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new GrizzlyBattleTank(new Posicion(255,250));
		GrizzlyBattleTank tanqueDos = new GrizzlyBattleTank(new Posicion(250,250));
		tanqueTest.moverIzquierda();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),255);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}
	
	/**
	 * Pruebo si al chocar con otra instancia de la misma clase la ocupación de ambas es la que tenían originalmente.
	 */
	public void testGrizzlyBattleTankChocarConGrizzlyBattleTankDesdeAbajo() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new GrizzlyBattleTank(new Posicion(250,255));
		GrizzlyBattleTank tanqueDos = new GrizzlyBattleTank(new Posicion(250,250));
		tanqueTest.moverArriba();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),255);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}
	
	/**
	 * Pruebo si al chocar con otra instancia de la misma clase la ocupación de ambas es la que tenían originalmente.
	 */
	public void testGrizzlyBattleTankChocarConGrizzlyBattleTankDesdeArriba() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new GrizzlyBattleTank(new Posicion(250,250));
		GrizzlyBattleTank tanqueDos = new GrizzlyBattleTank(new Posicion(250,255));
		tanqueTest.moverAbajo();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getY(),255);
	}
	
	/**
	 * Situo al tanque más cerca del borde izquierdo que del derecho y testeo que el método acercarseAlBordeLateralMasCercano() lo acerque a allí, y que una vez que haya llegado no se continúe moviendo al invocárselo. 
	 */
	public void testGrizzlyBattleTankAcercarseAlBordeLateralMasCercanoIzquierdo() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new GrizzlyBattleTank(new Posicion(5,250));
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),4);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),3);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),2);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),1);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}
	
	/**
	 * Situo al tanque más cerca del borde derecho que del izquierdo y testeo que el método acercarseAlBordeLateralMasCercano() lo acerque a allí, y que una vez que haya llegado no se continúe moviendo al invocárselo.
	 */
	public void testGrizzlyBattleTankAcercarseAlBordeLateralMasCercanoDerecho() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new GrizzlyBattleTank(new Posicion(591,250));
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),592);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),593);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),594);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),595);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),596);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),597);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),597);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}
	
	/**
	 * Sitúo al tanque a la izquierda del centro del espacio y testeo si a medida que lo hago moverse con el método acercarseAlCentroDelEspacio() se acerca a este, hasta que allí se encuentre y entonces el método no cause ningún efecto.
	 */
	public void testGrizzlyBattleTankAcercarseAlCentroDelEspacioDesdeIzquierda() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new GrizzlyBattleTank(new Posicion(293,250));
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),294);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),295);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),296);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),296);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}
	
	/**
	 * Sitúo al tanque a la derecha del centro del espacio y testeo si a medida que lo hago moverse con el método acercarseAlCentroDelEspacio() se acerca a este, hasta que allí se encuentre y entonces el método no cause ningún efecto.
	 */
	public void testGrizzlyBattleTankAcercarseAlCentroDelEspacioDesdeDerecha() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new GrizzlyBattleTank(new Posicion(306,250));
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),305);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),304);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),303);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),302);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),301);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),300);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),300);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}
	
}
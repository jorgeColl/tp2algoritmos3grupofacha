package pruebas.pruebasUnitarias;

import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.OcupacionCuadrada;
import modelo.manejoEspacial.Orientacion;
import modelo.manejoEspacial.Posicion;
import modelo.tanques.AlgoTank;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase AlgoTank.
 * @author Tom�s
 *
 */
public class PruebasAlgoTank extends TestCase {

	private AlgoTank tanqueTest;
	
	protected void setUp() throws Exception {
		super.setUp();
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(5,5));
	}
	
	/**
	 * Testeamos si los atributos se inicializaron correctamente.
	 */
	public void testAlgoTankCreacionValida() {
		OcupacionCuadrada ocupacionAuxiliar = (OcupacionCuadrada)tanqueTest.getOcupacion();
		assertEquals(tanqueTest.getOrientacion(),Orientacion.j);
		assertEquals(tanqueTest.getVelocidad(),2);
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getX(),5);
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getY(),5);
		assertEquals(ocupacionAuxiliar.getLado(),5);
		assertEquals(tanqueTest.getResistencia(),100);
	}
	
	/**
	 * Ubico a un AlgoTank en una posici�n central de la pantalla, sin obstaculizaci�n, y chequeo que al moverse hacia la derecha su nueva ocupaci�n sea la esperada.
	 */
	public void testAlgoTankMovimientoEstandarDerecha() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(250,250));
		tanqueTest.moverDerecha();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),252);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.i);
	}

	/**
	 * Ubico a un AlgoTank en una posici�n central de la pantalla, sin obstaculizaci�n, y chequeo que al moverse hacia arriba su nueva ocupaci�n sea la esperada.
	 */
	public void testAlgoTankMovimientoEstandarArriba() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(250,250));
		tanqueTest.moverArriba();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),248);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.j);
	}
	
	/**
	 * Ubico a un AlgoTank en una posici�n central de la pantalla, sin obstaculizaci�n, y chequeo que al moverse hacia la izquierda su nueva ocupaci�n sea la esperada.
	 */
	public void testAlgoTankMovimientoEstandarIzquierda() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(250,250));
		tanqueTest.moverIzquierda();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),248);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.iNegativo);
	}
	
	/**
	 * Ubico a un AlgoTank en una posici�n central de la pantalla, sin obstaculizaci�n, y chequeo que al moverse hacia abajo su nueva ocupaci�n sea la esperada.
	 */
	public void testAlgoTankMovimientoEstandarAbajo() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(250,250));
		tanqueTest.moverAbajo();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),252);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.jNegativo);
	}
	
	/**
	 * Ubico al tanque en una posici�n l�mite a derecha y chequeo que al moverse a la derecha siga en su posici�n anterior.
	 */
	public void testAlgoTankMovimientoInvalidoDerecha() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(Espacio.getInstancia().getLimiteDerecho()-((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado()+1,250));
		tanqueTest.moverDerecha();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),Espacio.getInstancia().getLimiteDerecho()-((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado()+1);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.i);		
	}
	
	/**
	 * Ubico al tanque en una posici�n l�mite hacia arriba y chequeo que al moverse a hacia arriba siga en su posici�n anterior.
	 */
	public void testAlgoTankMovimientoInvalidoArriba() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(250,0));
		tanqueTest.moverArriba();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),0);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.j);		
	}
	
	/**
	 * Ubico al tanque en una posici�n l�mite a izquierda y chequeo que al moverse a la izquierda siga en su posici�n anterior.
	 */
	public void testAlgoTankMovimientoInvalidoIzquierda() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(0,250));
		tanqueTest.moverIzquierda();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.iNegativo);		
	}

	/**
	 * Ubico al tanque en una posici�n l�mite hacia abajo y chequeo que al moverse a hacia abajo siga en su posici�n anterior.
	 */
	public void testAlgoTankMovimientoInvalidoAbajo() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(250,Espacio.getInstancia().getLimiteInferior()-((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado()+1));
		tanqueTest.moverAbajo();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),Espacio.getInstancia().getLimiteInferior()-((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado()+1);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.jNegativo);		
	}
	
	/**
	 * Testeamos que el m�todo moverEnDireccionContraria() mueva al tanque como se espera y que su orientacion no cambie. 
	 */
	public void testAlgoTankMoverEnDireccionContrariaIzquierda() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(250,250));
		tanqueTest.moverIzquierda();
		tanqueTest.moverEnDireccionContraria();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),249);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.iNegativo);
	}
	
	/**
	 * Testeamos que el m�todo moverEnDireccionContraria() mueva al tanque como se espera y que su orientacion no cambie. 
	 */
	public void testAlgoTankMoverEnDireccionContrariaDerecha() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(250,250));
		tanqueTest.moverDerecha();
		tanqueTest.moverEnDireccionContraria();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),251);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.i);
	}
	
	/**
	 * Testeamos que el m�todo moverEnDireccionContraria() mueva al tanque como se espera y que su orientacion no cambie. 
	 */
	public void testAlgoTankMoverEnDireccionContrariaArriba() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(250,250));
		tanqueTest.moverArriba();
		tanqueTest.moverEnDireccionContraria();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),249);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.j);
	}
	
	/**
	 * Testeamos que el m�todo moverEnDireccionContraria() mueva al tanque como se espera y que su orientacion no cambie. 
	 */
	public void testAlgoTankMoverEnDireccionContrariaAbajo() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(250,250));
		tanqueTest.moverAbajo();
		tanqueTest.moverEnDireccionContraria();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),251);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.jNegativo);
	}
	
	/**
	 * Otorgo municiones a una instancia de AlgoTank y chequeo que a medida que este dispare, las municiones disminuyan seg�n se espera.
	 */
	public void testAlgoTankDisminucionMunicionDisparo() {
		tanqueTest.incrementarMunicionCanion(3);
		tanqueTest.incrementarMunicionLanzaCohetes(4);
		assertEquals(tanqueTest.getLanzaCohetes().getMunicion(),4);
		tanqueTest.dispararLanzaCohetes();
		assertEquals(tanqueTest.getLanzaCohetes().getMunicion(),3);
		tanqueTest.dispararLanzaCohetes();
		assertEquals(tanqueTest.getLanzaCohetes().getMunicion(),2);
		tanqueTest.dispararLanzaCohetes();
		assertEquals(tanqueTest.getLanzaCohetes().getMunicion(),1);
		tanqueTest.dispararLanzaCohetes();
		assertEquals(tanqueTest.getLanzaCohetes().getMunicion(),0);
		assertEquals(tanqueTest.getCanion().getMunicion(),3);
		tanqueTest.dispararCanion();
		assertEquals(tanqueTest.getCanion().getMunicion(),2);
		tanqueTest.dispararCanion();
		assertEquals(tanqueTest.getCanion().getMunicion(),1);
		tanqueTest.dispararCanion();
		assertEquals(tanqueTest.getCanion().getMunicion(),0);
	}
	
	/**
	 * Pruebo si al chocar con otra instancia de la misma clase la ocupaci�n de ambas es la que ten�an originalmente.
	 */
	public void testAlgoTankChocarConAlgoTankDesdeIzquierda() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(250,250));
		AlgoTank tanqueDos = new AlgoTank(new Posicion(255,250));
		tanqueTest.moverDerecha();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getX(),255);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}
	
	/**
	 * Pruebo si al chocar con otra instancia de la misma clase la ocupaci�n de ambas es la que ten�an originalmente.
	 */
	public void testAlgoTankChocarConAlgoTankDesdeDerecha() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(255,250));
		AlgoTank tanqueDos = new AlgoTank(new Posicion(250,250));
		tanqueTest.moverIzquierda();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),255);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}
	
	/**
	 * Pruebo si al chocar con otra instancia de la misma clase la ocupaci�n de ambas es la que ten�an originalmente.
	 */
	public void testAlgoTankChocarConAlgoTankDesdeAbajo() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(250,255));
		AlgoTank tanqueDos = new AlgoTank(new Posicion(250,250));
		tanqueTest.moverArriba();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),255);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}
	
	/**
	 * Pruebo si al chocar con otra instancia de la misma clase la ocupaci�n de ambas es la que ten�an originalmente.
	 */
	public void testAlgoTankChocarConAlgoTankDesdeArriba() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(250,250));
		AlgoTank tanqueDos = new AlgoTank(new Posicion(250,255));
		tanqueTest.moverAbajo();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getY(),255);
	}
	
	/**
	 * Situo al tanque m�s cerca del borde izquierdo que del derecho y testeo que el m�todo acercarseAlBordeLateralMasCercano() lo acerque a all�, y que una vez que haya llegado no se contin�e moviendo al invoc�rselo. 
	 */
	public void testAlgoTankAcercarseAlBordeLateralMasCercanoIzquierdo() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(10,250));
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),8);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),6);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),4);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),2);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}
	
	/**
	 * Situo al tanque m�s cerca del borde derecho que del izquierdo y testeo que el m�todo acercarseAlBordeLateralMasCercano() lo acerque a all�, y que una vez que haya llegado no se contin�e moviendo al invoc�rselo.
	 */
	public void testAlgoTankAcercarseAlBordeLateralMasCercanoDerecho() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(590,250));
		tanqueTest.acercarseAlBordeLateralMasCercano();		
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),592);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),594);
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
	 * Sit�o al tanque a la izquierda del centro del espacio y testeo si a medida que lo hago moverse con el m�todo acercarseAlCentroDelEspacio() se acerca a este, hasta que all� se encuentre y entonces el m�todo no cause ning�n efecto.
	 */
	public void testAlgoTankAcercarseAlCentroDelEspacioDesdeIzquierda() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(289,250));
		tanqueTest.acercarseAlCentroDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),291);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),293);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),295);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),297);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),297);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}
	
	/**
	 * Sit�o al tanque a la derecha del centro del espacio y testeo si a medida que lo hago moverse con el m�todo acercarseAlCentroDelEspacio() se acerca a este, hasta que all� se encuentre y entonces el m�todo no cause ning�n efecto.
	 */
	public void testAlgoTankAcercarseAlCentroDelEspacioDesdeDerecha() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(311,250));
		tanqueTest.acercarseAlCentroDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),309);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),307);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),305);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),303);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),301);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}
	
}
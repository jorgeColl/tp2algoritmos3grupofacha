package ar.uba.fi.algo3.modelo.pruebasUnitarias;

import ar.uba.fi.algo3.modelo.armamentista.arma.Canion;
import ar.uba.fi.algo3.modelo.armamentista.arma.LanzaCohetes;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase AlgoTank.
 * @author Tomás
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
		assertEquals(ocupacionAuxiliar.getLado(),43);
		assertEquals(tanqueTest.getResistencia(),100);
	}
	
	/**
	 * Ubico a un AlgoTank en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia la derecha su nueva ocupación sea la esperada.
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
	 * Ubico a un AlgoTank en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia arriba su nueva ocupación sea la esperada.
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
	 * Ubico a un AlgoTank en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia la izquierda su nueva ocupación sea la esperada.
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
	 * Ubico a un AlgoTank en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia abajo su nueva ocupación sea la esperada.
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
	 * Ubico al tanque en una posición límite a derecha y chequeo que al moverse a la derecha siga en su posición anterior.
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
	 * Ubico al tanque en una posición límite hacia arriba y chequeo que al moverse a hacia arriba siga en su posición anterior.
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
	 * Ubico al tanque en una posición límite a izquierda y chequeo que al moverse a la izquierda siga en su posición anterior.
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
	 * Ubico al tanque en una posición límite hacia abajo y chequeo que al moverse a hacia abajo siga en su posición anterior.
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
	 * Testeamos que el método moverEnDireccionContraria() mueva al tanque como se espera y que su orientacion no cambie. 
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
	 * Testeamos que el método moverEnDireccionContraria() mueva al tanque como se espera y que su orientacion no cambie. 
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
	 * Testeamos que el método moverEnDireccionContraria() mueva al tanque como se espera y que su orientacion no cambie. 
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
	 * Testeamos que el método moverEnDireccionContraria() mueva al tanque como se espera y que su orientacion no cambie. 
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
	 * Otorgo municiones a una instancia de AlgoTank y chequeo que a medida que este dispare, las municiones disminuyan según se espera.
	 */
	public void testAlgoTankDisminucionMunicionDisparo() {
		tanqueTest.entregarArma(new LanzaCohetes(tanqueTest,4));
		assertEquals(tanqueTest.getArmasPrioritarias().peek().getMunicion(),4);
		int contador = 0;
		while (contador < 27) {
			tanqueTest.vivir();
			++contador;
		}
		tanqueTest.disparar();
		assertEquals(tanqueTest.getArmasPrioritarias().peek().getMunicion(),3);
	}
	
	/**
	 * Pruebo si al chocar con otra instancia de la misma clase la ocupación de ambas es la que tenían originalmente.
	 */
	/*public void testAlgoTankChocarConAlgoTankDesdeIzquierda() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(250,250));
		AlgoTank tanqueDos = new AlgoTank(new Posicion(293,250));
		tanqueTest.moverDerecha();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getX(),293);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}*/
	
	/**
	 * Pruebo si al chocar con otra instancia de la misma clase la ocupación de ambas es la que tenían originalmente.
	 */
	/*public void testAlgoTankChocarConAlgoTankDesdeDerecha() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(293,250));
		AlgoTank tanqueDos = new AlgoTank(new Posicion(250,250));
		tanqueTest.moverIzquierda();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),293);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}*/
	
	/**
	 * Pruebo si al chocar con otra instancia de la misma clase la ocupación de ambas es la que tenían originalmente.
	 */
	/*public void testAlgoTankChocarConAlgoTankDesdeAbajo() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(250,293));
		AlgoTank tanqueDos = new AlgoTank(new Posicion(250,250));
		tanqueTest.moverArriba();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),293);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}*/
	
	/**
	 * Pruebo si al chocar con otra instancia de la misma clase la ocupación de ambas es la que tenían originalmente.
	 */
	/*public void testAlgoTankChocarConAlgoTankDesdeArriba() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(250,250));
		AlgoTank tanqueDos = new AlgoTank(new Posicion(250,293));
		tanqueTest.moverAbajo();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getY(),293);
	}*/
	
	/**
	 * Situo al tanque más cerca del borde izquierdo que del derecho y testeo que el método acercarseAlBordeLateralMasCercano() lo acerque a allí, y que una vez que haya llegado no se continúe moviendo al invocárselo. 
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
	 * Situo al tanque más cerca del borde derecho que del izquierdo y testeo que el método acercarseAlBordeLateralMasCercano() lo acerque a allí, y que una vez que haya llegado no se continúe moviendo al invocárselo.
	 */
	public void testAlgoTankAcercarseAlBordeLateralMasCercanoDerecho() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(549,250));
		tanqueTest.acercarseAlBordeLateralMasCercano();		
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),551);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),553);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),555);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),557);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),559);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}
	
	/**
	 * Sitúo al tanque a la izquierda del centro del espacio y testeo si a medida que lo hago moverse con el método acercarseAlCentroDelEspacio() se acerca a este, hasta que allí se encuentre y entonces el método no cause ningún efecto.
	 */
	public void testAlgoTankAcercarseAlCentroDelEspacioDesdeIzquierda() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(249,250));
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),251);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),253);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),255);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),257);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),259);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}
	
	/**
	 * Sitúo al tanque a la derecha del centro del espacio y testeo si a medida que lo hago moverse con el método acercarseAlCentroDelEspacio() se acerca a este, hasta que allí se encuentre y entonces el método no cause ningún efecto.
	 */
	public void testAlgoTankAcercarseAlCentroDelEspacioDesdeDerecha() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new AlgoTank(new Posicion(311,250));
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),309);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),307);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),305);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),303);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),301);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}
	
	/**
	 * Otorgo al tanque un cañón y un lanza cohetes, y testeo que a medida que dispara dispare las armas esperadas y sus municiones vayan decreciendo de la manera correcta.
	 */
	public void testAlgoTankOtorgarArmasYDisparos() {
		tanqueTest.entregarArma(new Canion(tanqueTest,3));
		tanqueTest.entregarArma(new LanzaCohetes(tanqueTest,2));
		assertEquals(tanqueTest.getArmasPrioritarias().peek().getMunicion(),2);
		int contador = 0;
		while (contador < 27) {
			tanqueTest.vivir();
			++contador;
		}
		tanqueTest.disparar();
		assertEquals(tanqueTest.getArmasPrioritarias().peek().getMunicion(),1);
		contador = 0;
		while (contador < 27) {
			tanqueTest.vivir();
			++contador;
		}
		tanqueTest.disparar();
		//AQUÍ DESECHA EL LANZA COHETES PORQUE SE QUEDÓ SIN MUNICIÓN ENTONCES PASA A PRIORIZAR EL CAÑÓN.
		assertEquals(tanqueTest.getArmasPrioritarias().peek().getMunicion(),3);
		contador = 0;
		while (contador < 27) {
			tanqueTest.vivir();
			++contador;
		}
		tanqueTest.disparar();
		assertEquals(tanqueTest.getArmasPrioritarias().peek().getMunicion(),2);
		contador = 0;
		while (contador < 27) {
			tanqueTest.vivir();
			++contador;
		}
		tanqueTest.disparar();
		assertEquals(tanqueTest.getArmasPrioritarias().peek().getMunicion(),1);
	}
	
}
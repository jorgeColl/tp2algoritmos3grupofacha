package pruebas.pruebasUnitarias;

import modelo.armamentista.arma.LanzaCohetes;
import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.OcupacionCuadrada;
import modelo.manejoEspacial.Orientacion;
import modelo.manejoEspacial.Posicion;
import modelo.tanques.MirageTank;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase MirageTank.
 * @author Tomás
 *
 */
public class PruebasMirageTank extends TestCase {

	private MirageTank tanqueTest;
	
	protected void setUp() throws Exception {
		super.setUp();
		Espacio.getInstancia().reiniciar();
		tanqueTest = new MirageTank(new Posicion(5,5));
	}
	
	/**
	 * Testeamos si los atributos se inicializaron correctamente.
	 */
	public void testMirageTankCreacionValida() {
		OcupacionCuadrada ocupacionAuxiliar = (OcupacionCuadrada)tanqueTest.getOcupacion();
		assertEquals(tanqueTest.getOrientacion(),Orientacion.jNegativo);
		assertEquals(tanqueTest.getVelocidad(),2);
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getX(),5);
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getY(),5);
		assertEquals(ocupacionAuxiliar.getLado(),5);
		assertEquals(tanqueTest.getResistencia(),100);
		assertEquals(tanqueTest.getPuntosPorDestruccion(),50);
	}
	
	/**
	 * Ubico a un MirageTank en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia la derecha su nueva ocupación sea la esperada.
	 */
	public void testMirageTankMovimientoEstandarDerecha() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new MirageTank(new Posicion(250,250));
		tanqueTest.moverDerecha();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),252);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.i);
	}

	/**
	 * Ubico a un MirageTank en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia arriba su nueva ocupación sea la esperada.
	 */
	public void testMirageTankMovimientoEstandarArriba() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new MirageTank(new Posicion(250,250));
		tanqueTest.moverArriba();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),248);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.j);
	}
	
	/**
	 * Ubico a un MirageTank en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia la izquierda su nueva ocupación sea la esperada.
	 */
	public void testMirageTankMovimientoEstandarIzquierda() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new MirageTank(new Posicion(250,250));
		tanqueTest.moverIzquierda();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),248);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.iNegativo);
	}
	
	/**
	 * Ubico a un MirageTanken una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia abajo su nueva ocupación sea la esperada.
	 */
	public void testMirageTankMovimientoEstandarAbajo() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new MirageTank(new Posicion(250,250));
		tanqueTest.moverAbajo();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),252);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.jNegativo);
	}
	
	/**
	 * Ubico al tanque en una posición límite a derecha y chequeo que al moverse a la derecha siga en su posición anterior.
	 */
	public void testMirageTankMovimientoInvalidoDerecha() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new MirageTank(new Posicion(Espacio.getInstancia().getLimiteDerecho()-((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado()+1,250));
		tanqueTest.moverDerecha();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),Espacio.getInstancia().getLimiteDerecho()-((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado()+1);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.i);		
	}
	
	/**
	 * Ubico al tanque en una posición límite hacia arriba y chequeo que al moverse a hacia arriba siga en su posición anterior.
	 */
	public void testMirageTankMovimientoInvalidoArriba() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new MirageTank(new Posicion(250,0));
		tanqueTest.moverArriba();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),0);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.j);		
	}
	
	/**
	 * Ubico al tanque en una posición límite a izquierda y chequeo que al moverse a la izquierda siga en su posición anterior.
	 */
	public void testMirageTankMovimientoInvalidoIzquierda() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new MirageTank(new Posicion(0,250));
		tanqueTest.moverIzquierda();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.iNegativo);		
	}

	/**
	 * Ubico al tanque en una posición límite hacia abajo y chequeo que al moverse a hacia abajo siga en su posición anterior.
	 */
	public void testMirageTankMovimientoInvalidoAbajo() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new MirageTank(new Posicion(250,Espacio.getInstancia().getLimiteInferior()-((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado()+1));
		tanqueTest.moverAbajo();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),Espacio.getInstancia().getLimiteInferior()-((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado()+1);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.jNegativo);		
	}

	/**
	 * Testeamos que el método moverEnDireccionContraria() mueva al tanque como se espera y que su orientacion no cambie. 
	 */
	public void testMirageTankMoverEnDireccionContrariaIzquierda() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new MirageTank(new Posicion(250,250));
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
	public void testMirageTankMoverEnDireccionContrariaDerecha() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new MirageTank(new Posicion(250,250));
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
	public void testMirageTankMoverEnDireccionContrariaArriba() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new MirageTank(new Posicion(250,250));
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
	public void testMirageTankMoverEnDireccionContrariaAbajo() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new MirageTank(new Posicion(250,250));
		tanqueTest.moverAbajo();
		tanqueTest.moverEnDireccionContraria();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),251);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.jNegativo);
	}

	/**
	 * Pruebo si al chocar con otra instancia de la misma clase la ocupación de ambas es la que tenían originalmente.
	 */
	public void testMirageTankChocarConMirageTankDesdeIzquierda() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new MirageTank(new Posicion(250,250));
		MirageTank tanqueDos = new MirageTank(new Posicion(255,250));
		tanqueTest.moverDerecha();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getX(),255);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}
	
	/**
	 * Pruebo si al chocar con otra instancia de la misma clase la ocupación de ambas es la que tenían originalmente.
	 */
	public void testMirageTankChocarConMirageTankDesdeDerecha() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new MirageTank(new Posicion(255,250));
		MirageTank tanqueDos = new MirageTank(new Posicion(250,250));
		tanqueTest.moverIzquierda();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),255);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}
	
	/**
	 * Pruebo si al chocar con otra instancia de la misma clase la ocupación de ambas es la que tenían originalmente.
	 */
	public void testMirageTankChocarConMirageTankDesdeAbajo() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new MirageTank(new Posicion(250,255));
		MirageTank tanqueDos = new MirageTank(new Posicion(250,250));
		tanqueTest.moverArriba();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),255);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}
	
	/**
	 * Pruebo si al chocar con otra instancia de la misma clase la ocupación de ambas es la que tenían originalmente.
	 */
	public void testMirageTankChocarConMirageTankDesdeArriba() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new MirageTank(new Posicion(250,250));
		MirageTank tanqueDos = new MirageTank(new Posicion(250,255));
		tanqueTest.moverAbajo();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getY(),255);
	}

	/**
	 * Situo al tanque más cerca del borde izquierdo que del derecho y testeo que el método acercarseAlBordeLateralMasCercano() lo acerque a allí, y que una vez que haya llegado no se continúe moviendo al invocárselo. 
	 */
	public void testMirageTankAcercarseAlBordeLateralMasCercanoIzquierdo() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new MirageTank(new Posicion(12,250));
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),10);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
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
	public void testMirageTankAcercarseAlBordeLateralMasCercanoDerecho() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new MirageTank(new Posicion(585,250));
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),587);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),589);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),591);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),593);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),595);
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
	public void testMirageTankTankAcercarseAlCentroDelEspacioDesdeIzquierda() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new MirageTank(new Posicion(288,250));
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),290);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),292);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),294);
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
	public void testMirageTankAcercarseAlCentroDelEspacioDesdeDerecha() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new MirageTank(new Posicion(312,250));
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),310);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),308);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),306);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),304);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),302);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),300);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),300);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}
	
	/**
	 * Hago que el tanque dispare y chequeo que su munición disminuya.
	 */
	public void testDisminuirMunicionConDisparo() {
		assertEquals(((LanzaCohetes)tanqueTest.getArma()).getMunicion(),25);
		tanqueTest.disparar();
		assertEquals(((LanzaCohetes)tanqueTest.getArma()).getMunicion(),24);
	}
	
}
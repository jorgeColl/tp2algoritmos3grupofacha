package pruebas.pruebasUnitarias;

import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.OcupacionCuadrada;
import modelo.manejoEspacial.Orientacion;
import modelo.manejoEspacial.Posicion;
import modelo.tanques.IFV;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase IFV.
 * @author Tomás
 *
 */
public class PruebasIFV extends TestCase {

	private IFV tanqueTest;
	
	protected void setUp() throws Exception {
		super.setUp();
		Espacio.getInstancia().reiniciar();
		tanqueTest = new IFV(new Posicion(5,5));
	}
	
	/**
	 * Testeamos si los atributos se inicializaron correctamente.
	 */
	public void testIFVCreacionValida() {
		OcupacionCuadrada ocupacionAuxiliar = (OcupacionCuadrada)tanqueTest.getOcupacion();
		assertEquals(tanqueTest.getOrientacion(),Orientacion.jNegativo);
		assertEquals(tanqueTest.getVelocidad(),3);
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getX(),5);
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getY(),5);
		assertEquals(ocupacionAuxiliar.getLado(),5);
		assertEquals(tanqueTest.getResistencia(),100);
		assertEquals(tanqueTest.getPuntosPorDestruccion(),30);
	}

	/**
	 * Ubico a un IFV en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia la derecha su nueva ocupación sea la esperada.
	 */
	public void testIFVMovimientoEstandarDerecha() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new IFV(new Posicion(250,250));
		tanqueTest.moverDerecha();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),253);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.i);
	}

	/**
	 * Ubico a un IFV en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia arriba su nueva ocupación sea la esperada.
	 */
	public void testIFVMovimientoEstandarArriba() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new IFV(new Posicion(250,250));
		tanqueTest.moverArriba();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),247);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.j);
	}
	
	/**
	 * Ubico a un IFV en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia la izquierda su nueva ocupación sea la esperada.
	 */
	public void testIFVMovimientoEstandarIzquierda() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new IFV(new Posicion(250,250));
		tanqueTest.moverIzquierda();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),247);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.iNegativo);
	}
	
	/**
	 * Ubico a un IFV en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia abajo su nueva ocupación sea la esperada.
	 */
	public void testIFVMovimientoEstandarAbajo() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new IFV(new Posicion(250,250));
		tanqueTest.moverAbajo();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),253);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.jNegativo);
	}
	
	/**
	 * Ubico al tanque en una posición límite a derecha y chequeo que al moverse a la derecha siga en su posición anterior.
	 */
	public void testIFVMovimientoInvalidoDerecha() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new IFV(new Posicion(Espacio.getInstancia().getLimiteDerecho()-((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado()+1,250));
		tanqueTest.moverDerecha();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),Espacio.getInstancia().getLimiteDerecho()-((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado()+1);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.i);		
	}
	
	/**
	 * Ubico al tanque en una posición límite hacia arriba y chequeo que al moverse a hacia arriba siga en su posición anterior.
	 */
	public void testIFVMovimientoInvalidoArriba() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new IFV(new Posicion(250,0));
		tanqueTest.moverArriba();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),0);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.j);		
	}
	
	/**
	 * Ubico al tanque en una posición límite a izquierda y chequeo que al moverse a la izquierda siga en su posición anterior.
	 */
	public void testIFVMovimientoInvalidoIzquierda() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new IFV(new Posicion(0,250));
		tanqueTest.moverIzquierda();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.iNegativo);		
	}

	/**
	 * Ubico al tanque en una posición límite hacia abajo y chequeo que al moverse a hacia abajo siga en su posición anterior.
	 */
	public void testIFVMovimientoInvalidoAbajo() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new IFV(new Posicion(250,Espacio.getInstancia().getLimiteInferior()-((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado()+1));
		tanqueTest.moverAbajo();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),Espacio.getInstancia().getLimiteInferior()-((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado()+1);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.jNegativo);		
	}
	
	/**
	 * Testeamos que el método moverEnDireccionContraria() mueva al tanque como se espera y que su orientacion no cambie. 
	 */
	public void testIFVMoverEnDireccionContrariaIzquierda() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new IFV(new Posicion(250,250));
		tanqueTest.moverIzquierda();
		tanqueTest.moverEnDireccionContraria();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),248);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.iNegativo);
	}
	
	/**
	 * Testeamos que el método moverEnDireccionContraria() mueva al tanque como se espera y que su orientacion no cambie. 
	 */
	public void testIFVMoverEnDireccionContrariaDerecha() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new IFV(new Posicion(250,250));
		tanqueTest.moverDerecha();
		tanqueTest.moverEnDireccionContraria();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),252);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.i);
	}
	
	/**
	 * Testeamos que el método moverEnDireccionContraria() mueva al tanque como se espera y que su orientacion no cambie. 
	 */
	public void testIFVMoverEnDireccionContrariaArriba() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new IFV(new Posicion(250,250));
		tanqueTest.moverArriba();
		tanqueTest.moverEnDireccionContraria();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),248);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.j);
	}
	
	/**
	 * Testeamos que el método moverEnDireccionContraria() mueva al tanque como se espera y que su orientacion no cambie. 
	 */
	public void testIFVMoverEnDireccionContrariaAbajo() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new IFV(new Posicion(250,250));
		tanqueTest.moverAbajo();
		tanqueTest.moverEnDireccionContraria();
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getPuntoMenorModulo().getY(),252);
		assertEquals(((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado(),((OcupacionCuadrada)tanqueTest.getOcupacion()).getLado());
		assertEquals(tanqueTest.getOrientacion(),Orientacion.jNegativo);
	}

	/**
	 * Pruebo si al chocar con otra instancia de la misma clase la ocupación de ambas es la que tenían originalmente.
	 */
	public void testIFVChocarConIFVDesdeIzquierda() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new IFV(new Posicion(250,250));
		IFV tanqueDos = new IFV(new Posicion(255,250));
		tanqueTest.moverDerecha();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getX(),255);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}
	
	/**
	 * Pruebo si al chocar con otra instancia de la misma clase la ocupación de ambas es la que tenían originalmente.
	 */
	public void testIFVChocarConIFVDesdeDerecha() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new IFV(new Posicion(255,250));
		IFV tanqueDos = new IFV(new Posicion(250,250));
		tanqueTest.moverIzquierda();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),255);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}
	
	/**
	 * Pruebo si al chocar con otra instancia de la misma clase la ocupación de ambas es la que tenían originalmente.
	 */
	public void testIFVChocarConIFVDesdeAbajo() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new IFV(new Posicion(250,255));
		IFV tanqueDos = new IFV(new Posicion(250,250));
		tanqueTest.moverArriba();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),255);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}
	
	/**
	 * Pruebo si al chocar con otra instancia de la misma clase la ocupación de ambas es la que tenían originalmente.
	 */
	public void testIFVChocarConIFVDesdeArriba() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new IFV(new Posicion(250,250));
		IFV tanqueDos = new IFV(new Posicion(250,255));
		tanqueTest.moverAbajo();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getX(),250);
		assertEquals(((OcupacionCuadrada)(tanqueDos.getOcupacion())).getPuntoMenorModulo().getY(),255);
	}
	
	/**
	 * Situo al tanque más cerca del borde izquierdo que del derecho y testeo que el método acercarseAlBordeLateralMasCercano() lo acerque a allí, y que una vez que haya llegado no se continúe moviendo al invocárselo. 
	 */
	public void testIFVAcercarseAlBordeLateralMasCercanoIzquierdo() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new IFV(new Posicion(12,250));
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),9);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),6);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),3);
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
	public void testIFVAcercarseAlBordeLateralMasCercanoDerecho() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new IFV(new Posicion(579,250));
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),582);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),585);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),588);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),591);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlBordeLateralMasCercano();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),594);
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
	public void testIFVTankAcercarseAlCentroDelEspacioDesdeIzquierda() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new IFV(new Posicion(284,250));
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),287);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),290);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),293);
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
	public void testIFVAcercarseAlCentroDelEspacioDesdeDerecha() {
		Espacio.getInstancia().reiniciar();
		tanqueTest = new IFV(new Posicion(318,250));
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),315);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),312);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),309);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),306);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),303);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),300);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
		tanqueTest.acercarseAlCentroHorizontalDelEspacio();
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getX(),300);
		assertEquals(((OcupacionCuadrada)(tanqueTest.getOcupacion())).getPuntoMenorModulo().getY(),250);
	}
	
}
package ar.uba.fi.algo3.modelo.pruebasUnitarias;

import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase OcupacionCuadrada.
 * @author Tomás
 *
 */
public class PruebasOcupacionCuadrada extends TestCase {
	
	private OcupacionCuadrada ocupacion;
	
	protected void setUp() throws Exception {
		super.setUp();
		ocupacion = new OcupacionCuadrada(new Posicion(3,5), 4);
	}
	
	/**
	 * Testeo si los atributos de ocupacion se inicializaron correctamente.
	 */
	public void testOcupacionCuadradaCreacionValida() {
		assertEquals(ocupacion.getPuntoMenorModulo().getX(),3);
		assertEquals(ocupacion.getPuntoMenorModulo().getY(),5);
		assertEquals(ocupacion.getLado(),4);
	}
	
	/**
	 * Testeo si el metodo coincidenciaOcupacionalCon(OcupacionCuadrada ocupacion) devuelve true cuando tiene que hacerlo con respecto a una ocupacion ubicada a su noroeste.
	 */
	public void testCoincidenciaOcupacionalConNoroeste() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(1,3),3);
		assertTrue(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroeste()
	 */
	public void testCoincidenciaOcupacionalConNorte() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(3,3),3);
		assertTrue(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroeste()
	 */
	public void testCoincidenciaOcupacionalConNoreste() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(5,3),3);
		assertTrue(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroeste()
	 */
	public void testCoincidenciaOcupacionalConEste() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(6,5),1);
		assertTrue(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroeste()
	 */
	public void testCoincidenciaOcupacionalConSureste() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(6,8),1);
		assertTrue(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroeste()
	 */
	public void testCoincidenciaOcupacionalConSur() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(3,8),4);
		assertTrue(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroeste()
	 */
	public void testCoincidenciaOcupacionalConSuroste() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(2,8),2);
		assertTrue(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroeste()
	 */
	public void testCoincidenciaOcupacionalConOeste() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(2,5),2);
		assertTrue(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * Testeo si el metodo coincidenciaOcupacionalCon(OcupacionCuadrada ocupacion) devuelve false cuando tiene que hacerlo con respecto a una ocupacion ubicada a su noroeste.
	 */
	public void testCoincidenciaOcupacionalConNoroesteNegada() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(1,3),2);
		assertFalse(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroesteNegada()
	 */
	public void testCoincidenciaOcupacionalConNorteNegada() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(3,3),2);
		assertFalse(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroesteNegada()
	 */
	public void testCoincidenciaOcupacionalConNoresteNegada() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(5,3),2);
		assertFalse(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroesteNegada()
	 */
	public void testCoincidenciaOcupacionalConEsteNegada() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(7,5),1);
		assertFalse(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroesteNegada()
	 */
	public void testCoincidenciaOcupacionalConSuresteNegada() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(7,8),1);
		assertFalse(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroesteNegada()
	 */
	public void testCoincidenciaOcupacionalConSurNegada() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(3,9),1);
		assertFalse(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroesteNegada()
	 */
	public void testCoincidenciaOcupacionalConSurosteNegada() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(2,8),1);
		assertFalse(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroesteNegada()
	 */
	public void testCoincidenciaOcupacionalConOesteNegada() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(2,5),1);
		assertFalse(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/*
	 * NOTA IMPORTANTE: Todos los tests de ocupación válida se hacen teniendo en cuenta un espacio cuyo tamaño
	 * es de 601x601.
	 */

	/**
	 * Testeo si el método espacialmenteValida() devuelve true con una ocupación que no está próxima a ningún límite.
	 */
	public void testOcupacionValida() {
		ocupacion = new OcupacionCuadrada(new Posicion(50,50),5);
		assertTrue(ocupacion.espacialmenteValida());
	}
	
	/**
	 * Testeo si el método espacialmenteValida() devuelve true con una ocupación que llega hasta las posiciones límites a la izquierda y arriba.
	 */
	public void testOcupacionValidaCercanaANoroeste() {
		ocupacion = new OcupacionCuadrada(new Posicion(0,0),5);
		assertTrue(ocupacion.espacialmenteValida());
	}
	
	/**
	 * Testeo si el método espacialmenteValida() devuelve true con una ocupación que llega hasta las posiciones límites a la derecha y abajo.
	 */
	public void testOcupacionValidaCercanaASureste() {
		ocupacion = new OcupacionCuadrada(new Posicion(597,597),5);
		assertTrue(ocupacion.espacialmenteValida());
	}
	
	/**
	 * Testeo si el método espacialmenteValida() devuelve false con una ocupación cuyo límite izquierdo es menor que el del escenario. 
	 */
	public void testOcupacionNoValidaOeste() {
		ocupacion = new OcupacionCuadrada(new Posicion(-1,50),5);
		assertFalse(ocupacion.espacialmenteValida());
	}
	
	/**
	 * Testeo si el método espacialmenteValida() devuelve false con una ocupación cuyo límite superior es menor que el del escenario.
	 */
	public void testOcupacionNoValidaNorte() {
		ocupacion = new OcupacionCuadrada(new Posicion(50,-1),5);
		assertFalse(ocupacion.espacialmenteValida());
	}
	
	/**
	 * Testeo si el método espacialmenteValida() devuelve false con una ocupación cuyo límite derecho es mayor que el del escenario. 
	 */
	public void testOcupacionNoValidaEste() {
		ocupacion = new OcupacionCuadrada(new Posicion(598,50),5);
		assertFalse(ocupacion.espacialmenteValida());
	}
	
	/**
	 * Testeo si el método espacialmenteValida() devuelve false con una ocupación cuyo límite inferior es mayor que el del escenario. 
	 */
	public void testOcupacionNoValidaSur() {
		ocupacion = new OcupacionCuadrada(new Posicion(50,598),5);
		assertFalse(ocupacion.espacialmenteValida());
	}

	/**
	 * Testeo el método getPosicionPerimetralCentradaEnOrientacion con parámetro Orientacion.j.
	 */
	public void testGetPosicionPerimetralCentradaEnOrientacionNorte() {
		ocupacion = new OcupacionCuadrada(new Posicion(250,250),5);
		Posicion posicionAuxiliar = ocupacion.getPosicionPerimetralCentradaEnOrientacion(Orientacion.j);
		assertEquals(posicionAuxiliar.getX(),252);
		assertEquals(posicionAuxiliar.getY(),249);
	}
	
	/**
	 * Testeo el método getPosicionPerimetralCentradaEnOrientacion con parámetro Orientacion.jNegativo.
	 */
	public void testGetPosicionPerimetralCentradaEnOrientacionSur() {
		ocupacion = new OcupacionCuadrada(new Posicion(250,250),5);
		Posicion posicionAuxiliar = ocupacion.getPosicionPerimetralCentradaEnOrientacion(Orientacion.jNegativo);
		assertEquals(posicionAuxiliar.getX(),252);
		assertEquals(posicionAuxiliar.getY(),255);
	}
	
	/**
	 * Testeo el método getPosicionPerimetralCentradaEnOrientacion con parámetro Orientacion.iNegativo.
	 */
	public void testGetPosicionPerimetralCentradaEnOrientacionOeste() {
		ocupacion = new OcupacionCuadrada(new Posicion(250,250),5);
		Posicion posicionAuxiliar = ocupacion.getPosicionPerimetralCentradaEnOrientacion(Orientacion.iNegativo);
		assertEquals(posicionAuxiliar.getX(),249);
		assertEquals(posicionAuxiliar.getY(),252);
	}
	
	/**
	 * Testeo el método getPosicionPerimetralCentradaEnOrientacion con parámetro Orientacion.i.
	 */
	public void testGetPosicionPerimetralCentradaEnOrientacionEste() {
		ocupacion = new OcupacionCuadrada(new Posicion(250,250),5);
		Posicion posicionAuxiliar = ocupacion.getPosicionPerimetralCentradaEnOrientacion(Orientacion.i);
		assertEquals(posicionAuxiliar.getX(),255);
		assertEquals(posicionAuxiliar.getY(),252);
	}
	
	/**
	 * Testeo que el método getOcupacionMovidaAbajo() devuelva del valor esperado.
	 */
	public void testGetOcupacionMovidaAbajo() {
		OcupacionCuadrada ocupacionAuxiliar = (OcupacionCuadrada)ocupacion.getOcupacionMovidaAbajo();
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getX(),3);
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getY(),6);
	}
	
	/**
	 * Testeo que el método getOcupacionMovidaArriba() devuelva del valor esperado.
	 */
	public void testGetOcupacionMovidaArriba() {
		OcupacionCuadrada ocupacionAuxiliar = (OcupacionCuadrada)ocupacion.getOcupacionMovidaArriba();
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getX(),3);
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getY(),4);
	}
	
	/**
	 * Testeo que el método getOcupacionMovidaDerecha() devuelva del valor esperado.
	 */
	public void testGetOcupacionMovidaDerecha() {
		OcupacionCuadrada ocupacionAuxiliar = (OcupacionCuadrada)ocupacion.getOcupacionMovidaDerecha();
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getX(),4);
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getY(),5);
	}
	
	/**
	 * Testeo que el método getOcupacionMovidaDerecha() devuelva del valor esperado.
	 */
	public void testGetOcupacionMovidaIzquierda() {
		OcupacionCuadrada ocupacionAuxiliar = (OcupacionCuadrada)ocupacion.getOcupacionMovidaIzquierda();
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getX(),2);
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getY(),5);
	}
	
	/**
	 * Testeo si el método en cuestión devuelve el valor esperado. 3.5.4
	 */
	public void testGetLimiteDerecho() {
		assertEquals(ocupacion.getLimiteDerecho(),6);
	}
	
	/**
	 * @see testGetLimiteDerecho()
	 */
	public void testGetLimiteInferior() {
		assertEquals(ocupacion.getLimiteInferior(),8);
	}
	
	/**
	 * @see testGetLimiteDerecho()
	 */
	public void testGetLimiteIzquierdo() {
		assertEquals(ocupacion.getLimiteIzquierdo(),3);
	}
	
	/**
	 * @see testGetLimiteDerecho()
	 */
	public void testGetLimiteSuperior() {
		assertEquals(ocupacion.getLimiteSuperior(),5);
	}
	
	/**
	 * Testeo si el método estaEnBorde() devuelve true con una ocupación situada en el borde derecho del espacio
	 */
	public void testEstaEnBordeDerecho() {
		ocupacion = new OcupacionCuadrada(new Posicion(Espacio.getInstancia().getLimiteDerecho(),250),1);
		assertTrue(ocupacion.estaEnBorde());
	}
	
	/**
	 * @see testEstaEnBordeDerecho()
	 */
	public void testEstaEnBordeInferior() {
		ocupacion = new OcupacionCuadrada(new Posicion(250,Espacio.getInstancia().getLimiteInferior()),1);
		assertTrue(ocupacion.estaEnBorde());
	}
	
	/**
	 * @see testEstaEnBordeDerecho()
	 */
	public void testEstaEnBordeIzquierdo() {
		ocupacion = new OcupacionCuadrada(new Posicion(0,250),4);
		assertTrue(ocupacion.estaEnBorde());
	}
	
	/**
	 * @see testEstaEnBordeDerecho()
	 */
	public void testEstaEnBordeSuperior() {
		ocupacion = new OcupacionCuadrada(new Posicion(250,0),4);
		assertTrue(ocupacion.estaEnBorde());
	}
	
	/**
	 * Testeamos si el método estaEnBorde() devuelve false cuando la posición no se encuentra en ningún borde.
	 */
	public void testEstaEnBordeNegado() {
		ocupacion = new OcupacionCuadrada(new Posicion(250,250),4);
		assertFalse(ocupacion.estaEnBorde());
	}
	
	/**
	 * Instancio dos ocupaciones que coincidan espacialmente de manera horizontal, donde la que recibe el mensaje se encuentre más a la izquierda de la otra, y chequeo que el método devuelva correspondiente true.
	 */
	public void testCoincidenciaProyeccionHorizontalAIzquierda() {
		ocupacion = new OcupacionCuadrada(new Posicion(250,250),5);
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(246,10),5);
		assertTrue(ocupacionAuxiliar.coincidenciaProyeccionHorizontalCon(ocupacion));
	}
	
	/**
	 * Instancio dos ocupaciones que coincidan espacialmente de manera horizontal, donde la que recibe el mensaje se encuentre más a la derecha de la otra, y chequeo que el método devuelva correspondiente true.
	 */
	public void testCoincidenciaProyeccionHorizontalADerecha() {
		ocupacion = new OcupacionCuadrada(new Posicion(246,250),5);
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(250,10),5);
		assertTrue(ocupacionAuxiliar.coincidenciaProyeccionHorizontalCon(ocupacion));
	}
	
	/**
	 * Instancio dos ocupaciones que no coincidan espacialmente de manera horizontal, y chequeo que el método devuelva correspondiente false.
	 */
	public void testCoincidenciaProyeccionHorizontalNegada() {
		ocupacion = new OcupacionCuadrada(new Posicion(10,250),5);
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(250,250),5);
		assertFalse(ocupacionAuxiliar.coincidenciaProyeccionHorizontalCon(ocupacion));
	}
	
	/**
	 * Instancio dos ocupaciones que coincidan espacialmente de manera vertical, donde la que recibe el mensaje se encuentre más al norte de la otra, y chequeo que el método devuelva correspondiente true.
	 */
	public void testCoincidenciaProyeccionVerticalANorte() {
		ocupacion = new OcupacionCuadrada(new Posicion(250,250),5);
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(10,246),5);
		assertTrue(ocupacionAuxiliar.coincidenciaProyeccionVerticalCon(ocupacion));
	}
	
	/**
	 * Instancio dos ocupaciones que coincidan espacialmente de manera vertical, donde la que recibe el mensaje se encuentre más al sur de la otra, y chequeo que el método devuelva correspondiente true.
	 */
	public void testCoincidenciaProyeccionVerticalASur() {
		ocupacion = new OcupacionCuadrada(new Posicion(250,246),5);
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(10,250),5);
		assertTrue(ocupacionAuxiliar.coincidenciaProyeccionVerticalCon(ocupacion));
	}
	
	/**
	 * Instancio dos ocupaciones que no coincidan espacialmente de manera vertical, y chequeo que el método devuelva correspondiente false.
	 */
	public void testCoincidenciaProyeccionVerticalNegada() {
		ocupacion = new OcupacionCuadrada(new Posicion(10,250),5);
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(10,10),5);
		assertFalse(ocupacionAuxiliar.coincidenciaProyeccionVerticalCon(ocupacion));
	}
	
	/**
	 * Instancio una ocupación que tenga parte de sus posiciones sobre la recta central vertical del espacio y chequeamos que el método estaEnCentroHorizontal() devuelva true.
	 */
	public void testEstaEnCentroHorizontalAIzquierda() {
		ocupacion = new OcupacionCuadrada(new Posicion(296,250),5);
		assertTrue(ocupacion.estaEnCentroHorizontal());
	}
	
	/**
	 * Instancio una ocupación que tenga parte de sus posiciones sobre la recta central vertical del espacio y chequeamos que el método estaEnCentroHorizontal() devuelva true.
	 */
	public void testEstaEnCentroHorizontalADerecha() {
		ocupacion = new OcupacionCuadrada(new Posicion(300,250),5);
		assertTrue(ocupacion.estaEnCentroHorizontal());
	}
	
	/**
	 * Instancio una ocupación que no tenga parte de sus posiciones sobre la recta central vertical del espacio sino que se encuentre totalmente a su izquierda, y chequeamos que el método estaEnCentroHorizontal() devuelva false.
	 */
	public void testEstaEnCentroHorizontalNegadaAIzquierda() {
		ocupacion = new OcupacionCuadrada(new Posicion(0,250),5);
		assertFalse(ocupacion.estaEnCentroHorizontal());
	}
	
	/**
	 * Instancio una ocupación que no tenga parte de sus posiciones sobre la recta central vertical del espacio sino que se encuentre totalmente a su derecha, y chequeamos que el método estaEnCentroHorizontal() devuelva false.
	 */
	public void testEstaEnCentroHorizontalNegadaADerecha() {
		ocupacion = new OcupacionCuadrada(new Posicion(350,250),5);
		assertFalse(ocupacion.estaEnCentroHorizontal());
	}
	
}

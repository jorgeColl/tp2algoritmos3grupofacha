package pruebas;

import modelo.OcupacionCuadrada;
import modelo.Posicion;
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

	/* ****************** */
	
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
	
}

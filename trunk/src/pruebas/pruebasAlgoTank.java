
package pruebas;

import junit.framework.TestCase;
import modelo.*; 

/**
 * @author jc
 *
 */
public class pruebasAlgoTank extends TestCase {
	private AlgoTank algoTanque;
	private int velocidadDePrueba;
	private Posicion posicionDePrueba;
	private int posicionXPrueba;
	private int posicionYPrueba;
	
	public void setUp() throws Exception {
		velocidadDePrueba = 2;
		posicionXPrueba = 11;
		posicionYPrueba = 22;
		posicionDePrueba = new Posicion(posicionXPrueba,posicionYPrueba);
		algoTanque = new AlgoTank(velocidadDePrueba, posicionDePrueba);
	}
	
	/**
	 * funcion auxiliar que ayuda a probar los distintos metodos de movimiento del objeto
	 * 
	 * @param posicionEsperadaX es la posicion en x que se espera en la que este el objeto a testear
	 * @param posicionEsperadaY es la posicion en y que se espera en la que este el objeto a testear
	 * @param orientacionEsperadaX es la orientacion en x que se espera que tenga el objeto a testear
	 * @param orientacionEsperadaY es la orientacion en y que se espera que tenga el objeto a testear
	 */
	private void metodoAuxParaProbarMover(int posicionEsperadaX,int posicionEsperadaY,int orientacionEsperadaX,int orientacionEsperadaY){
		assertEquals(algoTanque.devolverPosicion().getX() , posicionEsperadaX);
		assertEquals(algoTanque.devolverPosicion().getY() , posicionEsperadaY);
		assertEquals(algoTanque.devolverOrientacion().getX() , orientacionEsperadaX);
		assertEquals(algoTanque.devolverOrientacion().getY() , orientacionEsperadaY);
	}
	
	public void testMoverseEnI(){
		this.algoTanque.moverEnI();
		this.metodoAuxParaProbarMover(posicionXPrueba + velocidadDePrueba, posicionYPrueba, 1, 0);
		
	}
	
	public void testMoverseEnINegativo(){
		this.algoTanque.moverEnINegativo();
		this.metodoAuxParaProbarMover(posicionXPrueba - velocidadDePrueba, posicionYPrueba, -1, 0);
		
	}
	
	public void testMoverseEnJ(){
		this.algoTanque.moverEnJ();
		this.metodoAuxParaProbarMover(posicionXPrueba , posicionYPrueba + velocidadDePrueba, 0, 1);
		
	}
	
	public void testMoverseEnJNegativo(){
		this.algoTanque.moverEnJNegativo();
		this.metodoAuxParaProbarMover(posicionXPrueba , posicionYPrueba - velocidadDePrueba, 0, -1);
		
	}
	
	
}

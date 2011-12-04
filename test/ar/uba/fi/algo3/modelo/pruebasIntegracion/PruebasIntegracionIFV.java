package ar.uba.fi.algo3.modelo.pruebasIntegracion;

import ar.uba.fi.algo3.modelo.armamentista.arma.Canion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.objetosInanimados.BonusVelocidad;
import ar.uba.fi.algo3.modelo.objetosInanimados.BonusVida;
import ar.uba.fi.algo3.modelo.objetosInanimados.CuartelArgentino;
import ar.uba.fi.algo3.modelo.objetosInanimados.ParedConcreto;
import ar.uba.fi.algo3.modelo.objetosInanimados.ParedMetal;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import ar.uba.fi.algo3.modelo.tanques.GrizzlyBattleTank;
import ar.uba.fi.algo3.modelo.tanques.IFV;
import ar.uba.fi.algo3.modelo.tanques.MirageTank;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas de integración de IFV con los demás objetos del juego.
 * @author Tomás
 *
 */
public class PruebasIntegracionIFV extends TestCase {

	private IFV tanque;
	
	protected void setUp() throws Exception {
		super.setUp();
		Espacio.getInstancia().reiniciar();
	}
	
	/**
	 * Hago mover al tanque hasta que impacte con un BonusVelocidad y testeo que sus velocidades mejoren en el valor esperado.
	 */
	public void testIFVMejorarVelocidades() {
		tanque = new IFV(new Posicion(0,0));
		BonusVelocidad bonus = new BonusVelocidad(new Posicion(250,0));
		int velocidad = tanque.getVelocidad();
		int velocidadDisparo = tanque.getVelocidadDisparo();
		while (tanque.getOcupacion().getLimiteDerecho() < bonus.getOcupacion().getLimiteIzquierdo()) {
			tanque.moverDerecha();
		}
		assertEquals(tanque.getVelocidad(),(int)(velocidad+(velocidad*20/100)));
		assertEquals(tanque.getVelocidadDisparo(),(int)(velocidadDisparo+(velocidadDisparo*30/100)));
	}

	/**
	 * Hago mover al tanque hasta que impacte con un BonusVida y testeo que su resistencia mejore en el valor esperado.
	 */
	public void testIFVMejorarResistencia() {
		tanque = new IFV(new Posicion(0,0));
		BonusVida bonus = new BonusVida(new Posicion(250,0));
		int resistencia = tanque.getResistencia();
		while (tanque.getOcupacion().getLimiteDerecho() < bonus.getOcupacion().getLimiteIzquierdo()) {
			tanque.moverDerecha();
		}
		assertEquals(tanque.getResistencia(),(int)(resistencia+(resistencia*40/100)));
	}
	
	/* A CONTINUACIÓN PRUEBO LOS CHOQUES CON TODOS LOS TANQUES.
	 * PARA HACERLO MÁS GENERAL HAGO QUE LOS CHOQUE DESDE DISTINTAS POSICIONES RELATIVAS ASÍ DE PASO SE PRUEBAN TODAS.
	 */
	
	/**
	 * Hago chocar al tanque con una instancia de AlgoTank y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testIFVChocarConAlgoTankDesdeArriba() {
		AlgoTank otroTanque = new AlgoTank(new Posicion(0,0));
		tanque = new IFV(new Posicion(0,((OcupacionCuadrada)otroTanque.getOcupacion()).getLado()));
		tanque.moverArriba();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),((OcupacionCuadrada)tanque.getOcupacion()).getLado());
	}
	
	
	/**
	 * Hago chocar al tanque con una instancia de GrizzlyBattleTank y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testIFVChocarConGrizzlyBattleTankDesdeArriba() {
		tanque = new IFV(new Posicion(0,0));
		GrizzlyBattleTank otroTanque = new GrizzlyBattleTank(new Posicion(0,((OcupacionCuadrada)tanque.getOcupacion()).getLado()));
		tanque.moverAbajo();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/**
	 * Hago chocar al tanque con una instancia de IFV y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testIFVChocarConIFVDesdeIzquierda() {
		tanque = new IFV(new Posicion(0,0));
		IFV otroTanque = new IFV(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado(),0));
		tanque.moverDerecha();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/**
	 * Hago chocar al tanque con una instancia de MirageTank y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testIFVChocarConMirageTankDesdeDerecha() {
		MirageTank otroTanque = new MirageTank(new Posicion(0,0));
		tanque = new IFV(new Posicion(((OcupacionCuadrada)otroTanque.getOcupacion()).getLado(),0));
		tanque.moverIzquierda();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),((OcupacionCuadrada)otroTanque.getOcupacion()).getLado());
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}

	/* HAGO QUE CHOQUE CON TODOS LOS TIPOS DE PARED DESDE DISTINTAS POSICIONES RELATIVAS */
	
	/**
	 * Hago chocar al tanque con una instancia de ParedConcreto y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testIFVChocarConParedConcretoDesdeIzquierda() {
		tanque = new IFV(new Posicion(0,0));
		ParedConcreto pared = new ParedConcreto(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado(),0));
		tanque.moverDerecha();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/**
	 * Hago chocar al tanque con una instancia de ParedMetal y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testIFVChocarConParedMetalDesdeDerecha() {
		ParedMetal pared = new ParedMetal(new Posicion(0,0));
		tanque = new IFV(new Posicion(((OcupacionCuadrada)pared.getOcupacion()).getLado(),0));
		tanque.moverIzquierda();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),((OcupacionCuadrada)pared.getOcupacion()).getLado());
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/**
	 * Sitúo a una instancia del tanque contiguamente a una del cuartel, a su izquierda. Lo hago mover a la derecha. Testeo que su posición siga siendo la inicial porque el cuartel se interpuso en su camino.
	 */
	public void testIFVChocarConCuartelArgentinoDesdeIzquierda() {
		tanque = new IFV(new Posicion(0,0));
		CuartelArgentino cuartel = new CuartelArgentino(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado(),0));		
		tanque.moverDerecha();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/* TESTEO QUE ESTE TANQUE DESTRUYA A TODOS LOS DEMAS A DISPAROS, EN DISTINTAS POSICIONES RELATIVAS */
	
	/**
	 * Ubico a la instancia de IFV cerca del borde izquierdo de la pantalla, al cuartel sobre el borde superior y al tanque del jugador entre medio de los dos.
	 * Hago correr la lógica del juego hasta que el tanque del jugador sea destruido.
	 * Cuando esto ya haya ocurrido, la instancia de IFV tuvo que haberse acercado a su borde más cercano dado que eso le ordena su estrategia de movimiento.
	 * Su munición tuvo que haber disminuído.
	 * NOTA: Pongo un contador para que si la lógica falla no se entre en un ciclo infinito, y si la resistencia de la instancia AlgoTank no es menor o igual que cero luego de la finalización del ciclo (salida esperada) fallo el test.
	 */
	public void testIFVDestruirAlgoTankDisparosDesdeIzquierda() {
		AlgoTank otroTanque = new AlgoTank(new Posicion(400,0));
		CuartelArgentino cuartel = new CuartelArgentino(new Posicion(500,0));
		tanque = new IFV(new Posicion(10,0));
		int municionInicial = ((Canion)tanque.getArma()).getMunicion();
		int contador = 0;
		while ((otroTanque.getResistencia() > 0)&&(contador < 300)) {
			Espacio.getInstancia().correrLogica();
			++contador;
		}
		if (otroTanque.getResistencia() > 0)
			fail();   
		assertTrue(((Canion)tanque.getArma()).getMunicion() < municionInicial);
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/**
	 * Ubico a los dos tanques contiguamente.
	 * Oriento al del test hacia el otro.
	 * Lo hago disparar y testeo que con cada disparo la resistencia del otro vaya disminuyendo adecuadamente, hasta que sea destruido.
	 * Testeo que antes de desaparecer el tanque esté incluido en el espacio, y que luego no.
	 */
	public void testIFVDestruirGrizzlyBattleTankDisparosDesdeArriba() {
		tanque = new IFV(new Posicion(0,0));
		GrizzlyBattleTank tanqueDos = new GrizzlyBattleTank(new Posicion(0,((OcupacionCuadrada)tanque.getOcupacion()).getLado()));
		tanque.moverAbajo();
		assertEquals(tanqueDos.getResistencia(),100);
		tanque.disparar();
		assertEquals(tanqueDos.getResistencia(),70);
		tanque.disparar();
		assertEquals(tanqueDos.getResistencia(),40);
		tanque.disparar();
		assertEquals(tanqueDos.getResistencia(),10);
		assertTrue(Espacio.getInstancia().incluyeA(tanqueDos));
		tanque.disparar();
		assertEquals(tanqueDos.getResistencia(),-20);
		assertFalse(Espacio.getInstancia().incluyeA(tanqueDos));
	}

	/**
	 * @see testIFVDestruirGrizzlyBattleTankDisparosDesdeArriba()
	 */
	public void testIFVDestruirIFVDisparosDesdeDerecha() {
		IFV tanqueDos = new IFV(new Posicion(0,0));
		tanque = new IFV(new Posicion(((OcupacionCuadrada)tanqueDos.getOcupacion()).getLado(),0));
		tanque.moverIzquierda();
		assertEquals(tanqueDos.getResistencia(),100);
		tanque.disparar();
		assertEquals(tanqueDos.getResistencia(),70);
		tanque.disparar();
		assertEquals(tanqueDos.getResistencia(),40);
		tanque.disparar();
		assertEquals(tanqueDos.getResistencia(),10);
		assertTrue(Espacio.getInstancia().incluyeA(tanqueDos));
		tanque.disparar();
		assertEquals(tanqueDos.getResistencia(),-20);
		assertFalse(Espacio.getInstancia().incluyeA(tanqueDos));
	}

	/**
	 * @see testIFVDestruirGrizzlyBattleTankDisparosDesdeArriba()
	 */
	public void testIFVDestruirMirageTankDisparosDesdeAbajo() {
		MirageTank tanqueDos = new MirageTank(new Posicion(0,0));
		tanque = new IFV(new Posicion(0,((OcupacionCuadrada)tanqueDos.getOcupacion()).getLado()));
		tanque.moverArriba();
		assertEquals(tanqueDos.getResistencia(),100);
		tanque.disparar();
		assertEquals(tanqueDos.getResistencia(),70);
		tanque.disparar();
		assertEquals(tanqueDos.getResistencia(),40);
		tanque.disparar();
		assertEquals(tanqueDos.getResistencia(),10);
		assertTrue(Espacio.getInstancia().incluyeA(tanqueDos));
		tanque.disparar();
		assertEquals(tanqueDos.getResistencia(),-20);
		assertFalse(Espacio.getInstancia().incluyeA(tanqueDos));
	}
	
	/* TESTEO QUE EL TANQUE DESTRUYA CORRECTAMENTE A LAS PAREDES CON SUS DISPAROS */
	
	/**
	 * Sitúo a una instancia de la pared contiguamente al tanque.
	 * Testeo que la pared esté incluída en el espacio.
	 * Oriento a este hacia ella y lo hago disparar.
	 * Testeo que la pared no esté incluída en el espacio.
	 */
	public void testIFVDestruirParedConcretoDisparosDesdeIzquierda() {
		tanque = new IFV(new Posicion(0,0));
		ParedConcreto pared = new ParedConcreto(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado(),0));
		tanque.moverDerecha();
		assertTrue(Espacio.getInstancia().incluyeA(pared));
		tanque.disparar();
		assertFalse(Espacio.getInstancia().incluyeA(pared));
	}
	
	/**
	 * Sitúo a una instancia de la pared contiguamente al tanque.
	 * Testeo que la pared esté incluída en el espacio.
	 * Oriento a este hacia ella y lo hago disparar.
	 * Testeo nuevamente que la pared esté incluída en el espacio.
	 * Hago disparar al tanque nuevamente.
	 * Testeo que la pared no esté incluída en el espacio.
	 */
	public void testIFVDestruirParedMetalDisparosDesdeDerecha() {
		ParedMetal pared = new ParedMetal(new Posicion(0,0));
		tanque = new IFV(new Posicion(((OcupacionCuadrada)pared.getOcupacion()).getLado(),0));
		tanque.moverIzquierda();
		assertTrue(Espacio.getInstancia().incluyeA(pared));
		tanque.disparar();
		assertTrue(Espacio.getInstancia().incluyeA(pared));
		tanque.disparar();
		assertFalse(Espacio.getInstancia().incluyeA(pared));
	}
	
	/* TESTEO QUE LOS DISPAROS DEL TANQUE NO AFECTEN A LOS BONUS */
	
	/**
	 * Sitúo a una instancia del bonus a una distancia prudencial del tanque para que cuando este se mueva para orientarse no lo choque.
	 * Testeo que el bonus esté incluído en el espacio.
	 * Oriento el tanque hacia él y lo hago disparar.
	 * Testeo que el bonus esté incluído en el espacio.
	 */
	public void testIFVNoAfectarBonusVidaDesdeIzquierda() {
		tanque = new IFV(new Posicion(0,0));
		BonusVida bonus = new BonusVida(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado()+tanque.getVelocidad(),0));
		tanque.moverDerecha();
		assertTrue(Espacio.getInstancia().incluyeA(bonus));
		tanque.disparar();
		assertTrue(Espacio.getInstancia().incluyeA(bonus));
	}
	
	/**
	 * @see testIFVNoAfectarBonusVidaDesdeIzquierda()
	 */
	public void testIFVNoAfectarBonusVelocidadDesdeIzquierda() {
		tanque = new IFV(new Posicion(0,0));
		BonusVelocidad bonus = new BonusVelocidad(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado()+tanque.getVelocidad(),0));
		tanque.moverDerecha();
		assertTrue(Espacio.getInstancia().incluyeA(bonus));
		tanque.disparar();
		assertTrue(Espacio.getInstancia().incluyeA(bonus));
	}
	
	/* HAGO QUE EL TANQUE DESTRUYA A DISPAROS AL CUARTEL ARGENTINO Y TESTEO QUE EL JUEGO SE PIERDA */
	
	/**
	 * Sitúo a una instancia de AlgoTank a la izquierda contígua de una instancia de CuartelArgentino.
	 * Oriento al tanque hacia el cuartel.
	 * Testeo que la segunda esté incluída en el espacio.
	 * Testeo que el juego no esté perdido.
	 * Hago disparar al tanque.
	 * Testeo que el cuartel no esté incluído en el espacio.
	 * Testeo que el juego esté perdido.
	 */
	public void testIFVDestruirCuartelArgentinoYJuegoPerdidoDesdeIzquierda() {
		tanque = new IFV(new Posicion(0,0));
		CuartelArgentino cuartel = new CuartelArgentino(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado()+tanque.getVelocidad(),0));
		AlgoTank algoTank = new AlgoTank(new Posicion(250,250));
		tanque.moverDerecha();
		assertTrue(Espacio.getInstancia().incluyeA(cuartel));
		assertFalse(Espacio.getInstancia().juegoPerdido());
		tanque.disparar();
		assertFalse(Espacio.getInstancia().incluyeA(cuartel));
		assertTrue(Espacio.getInstancia().juegoPerdido());
	}

}
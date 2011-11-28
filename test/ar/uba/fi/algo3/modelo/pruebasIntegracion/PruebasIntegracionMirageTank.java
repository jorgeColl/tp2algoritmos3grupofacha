package ar.uba.fi.algo3.modelo.pruebasIntegracion;

import ar.uba.fi.algo3.modelo.armamentista.arma.Canion;
import ar.uba.fi.algo3.modelo.armamentista.arma.LanzaCohetes;
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
public class PruebasIntegracionMirageTank extends TestCase {

	private MirageTank tanque;
	
	protected void setUp() throws Exception {
		super.setUp();
		Espacio.getInstancia().reiniciar();
	}
	
	/**
	 * Hago mover al tanque hasta que impacte con un BonusVelocidad y testeo que sus velocidades mejoren en el valor esperado.
	 */
	public void testMirageTankMejorarVelocidades() {
		tanque = new MirageTank(new Posicion(0,0));
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
	public void testMirageTankMejorarResistencia() {
		tanque = new MirageTank(new Posicion(0,0));
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
	public void testMirageTankChocarConAlgoTankDesdeArriba() {
		AlgoTank otroTanque = new AlgoTank(new Posicion(0,0));
		tanque = new MirageTank(new Posicion(0,((OcupacionCuadrada)otroTanque.getOcupacion()).getLado()));
		tanque.moverArriba();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),((OcupacionCuadrada)tanque.getOcupacion()).getLado());
	}
	
	
	/**
	 * Hago chocar al tanque con una instancia de GrizzlyBattleTank y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testMirageTankChocarConGrizzlyBattleTankDesdeArriba() {
		tanque = new MirageTank(new Posicion(0,0));
		GrizzlyBattleTank otroTanque = new GrizzlyBattleTank(new Posicion(0,((OcupacionCuadrada)tanque.getOcupacion()).getLado()));
		tanque.moverAbajo();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/**
	 * Hago chocar al tanque con una instancia de IFV y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testMirageTankChocarConIFVDesdeIzquierda() {
		tanque = new MirageTank(new Posicion(0,0));
		IFV otroTanque = new IFV(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado(),0));
		tanque.moverDerecha();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/**
	 * Hago chocar al tanque con una instancia de MirageTank y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testMirageTankChocarConMirageTankDesdeDerecha() {
		MirageTank otroTanque = new MirageTank(new Posicion(0,0));
		tanque = new MirageTank(new Posicion(((OcupacionCuadrada)otroTanque.getOcupacion()).getLado(),0));
		tanque.moverIzquierda();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),((OcupacionCuadrada)otroTanque.getOcupacion()).getLado());
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}

	/* HAGO QUE CHOQUE CON TODOS LOS TIPOS DE PARED DESDE DISTINTAS POSICIONES RELATIVAS */
	
	/**
	 * Hago chocar al tanque con una instancia de ParedConcreto y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testMirageTankChocarConParedConcretoDesdeIzquierda() {
		tanque = new MirageTank(new Posicion(0,0));
		ParedConcreto pared = new ParedConcreto(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado(),0));
		tanque.moverDerecha();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/**
	 * Hago chocar al tanque con una instancia de ParedMetal y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testMirageTankChocarConParedMetalDesdeDerecha() {
		ParedMetal pared = new ParedMetal(new Posicion(0,0));
		tanque = new MirageTank(new Posicion(((OcupacionCuadrada)pared.getOcupacion()).getLado(),0));
		tanque.moverIzquierda();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),((OcupacionCuadrada)pared.getOcupacion()).getLado());
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/**
	 * Sitúo a una instancia del tanque contiguamente a una del cuartel, a su izquierda. Lo hago mover a la derecha. Testeo que su posición siga siendo la inicial porque el cuartel se interpuso en su camino.
	 */
	public void testMirageTankChocarConCuartelArgentinoDesdeIzquierda() {
		tanque = new MirageTank(new Posicion(0,0));
		CuartelArgentino cuartel = new CuartelArgentino(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado(),0));		
		tanque.moverDerecha();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/* TESTEO QUE ESTE TANQUE DESTRUYA A TODOS LOS DEMAS A DISPAROS, EN DISTINTAS POSICIONES RELATIVAS */
	
	/**
	 * Ubico a la instancia de MirageTank y al cuartel sobre el borde superior, y al tanque del jugador entre medio de los dos.
	 * Hago correr la lógica del juego hasta que el tanque del jugador disminuya su resistencia considerablemente (notar que esta no puede anularse dado que el lanza cohetes quita la mitad de la resistencia actual de los tanques, por lo cual nunca es 0).
	 * Cuando esto ya haya ocurrido, la instancia de MirageTank tuvo que haberse acercado a al centro vertical dado que eso le ordena su estrategia de movimiento.
	 * Su munición tuvo que haber disminuído.
	 * NOTA: Pongo un contador para que si la lógica falla no se entre en un ciclo infinito, y si la resistencia de la instancia AlgoTank no es menor o igual que cero luego de la finalización del ciclo (salida esperada) fallo el test.
	 */
	public void testMirageTankDaniarAlgoTankDisparosDesdeIzquierda() {
		AlgoTank otroTanque = new AlgoTank(new Posicion(400,0));
		CuartelArgentino cuartel = new CuartelArgentino(new Posicion(500,0));
		tanque = new MirageTank(new Posicion(10,0));
		int municionInicial = ((LanzaCohetes)tanque.getArma()).getMunicion();
		int contador = 0;
		while ((otroTanque.getResistencia() > 1)&&(contador < 200)) {
			Espacio.getInstancia().correrLogica();
			++contador;
		}
		if (otroTanque.getResistencia() > 1)
			fail();   
		assertTrue(((LanzaCohetes)tanque.getArma()).getMunicion() < municionInicial);
		assertTrue(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX() > 0);
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/**
	 * Ubico a los dos tanques contiguamente.
	 * Oriento al del test hacia el otro.
	 * Lo hago disparar y testeo que con cada disparo la resistencia del otro vaya disminuyendo adecuadamente (no se lo puede destruir por cuestiones del lanza cohetes).
	 */
	public void testMirageTankDestruirGrizzlyBattleTankDisparosDesdeArriba() {
		tanque = new MirageTank(new Posicion(0,0));
		GrizzlyBattleTank tanqueDos = new GrizzlyBattleTank(new Posicion(0,((OcupacionCuadrada)tanque.getOcupacion()).getLado()));
		tanque.moverAbajo();
		assertEquals(tanqueDos.getResistencia(),100);
		tanque.disparar();
		assertEquals(tanqueDos.getResistencia(),50);
		tanque.disparar();
		assertEquals(tanqueDos.getResistencia(),25);
		tanque.disparar();
		assertEquals(tanqueDos.getResistencia(),13);
	}

	/**
	 * @see testMirageTankDestruirGrizzlyBattleTankDisparosDesdeArriba()
	 */
	public void testMirageTankDaniarIFVDisparosDesdeDerecha() {
		IFV tanqueDos = new IFV(new Posicion(0,0));
		tanque = new MirageTank(new Posicion(((OcupacionCuadrada)tanqueDos.getOcupacion()).getLado(),0));
		tanque.moverIzquierda();
		assertEquals(tanqueDos.getResistencia(),100);
		tanque.disparar();
		assertEquals(tanqueDos.getResistencia(),50);
		tanque.disparar();
		assertEquals(tanqueDos.getResistencia(),25);
		tanque.disparar();
		assertEquals(tanqueDos.getResistencia(),13);
	}

	/**
	 * @see testMirageTankDestruirGrizzlyBattleTankDisparosDesdeArriba()
	 */
	public void testMirageTankDaniarMirageTankDisparosDesdeAbajo() {
		MirageTank tanqueDos = new MirageTank(new Posicion(0,0));
		tanque = new MirageTank(new Posicion(0,((OcupacionCuadrada)tanqueDos.getOcupacion()).getLado()));
		tanque.moverArriba();
		assertEquals(tanqueDos.getResistencia(),100);
		tanque.disparar();
		assertEquals(tanqueDos.getResistencia(),50);
		tanque.disparar();
		assertEquals(tanqueDos.getResistencia(),25);
		tanque.disparar();
		assertEquals(tanqueDos.getResistencia(),13);
	}
	
	/* TESTEO QUE EL TANQUE DESTRUYA CORRECTAMENTE A LAS PAREDES CON SUS DISPAROS */
	
	/**
	 * Sitúo a una instancia de la pared contiguamente al tanque.
	 * Testeo que la pared esté incluída en el espacio.
	 * Oriento a este hacia ella y lo hago disparar.
	 * Testeo que la pared no esté incluída en el espacio.
	 */
	public void testMirageTankDestruirParedConcretoDisparosDesdeIzquierda() {
		tanque = new MirageTank(new Posicion(0,0));
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
	public void testMirageTankDestruirParedMetalDisparosDesdeDerecha() {
		ParedMetal pared = new ParedMetal(new Posicion(0,0));
		tanque = new MirageTank(new Posicion(((OcupacionCuadrada)pared.getOcupacion()).getLado(),0));
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
	public void testMirageTankNoAfectarBonusVidaDesdeIzquierda() {
		tanque = new MirageTank(new Posicion(0,0));
		BonusVida bonus = new BonusVida(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado()+tanque.getVelocidad(),0));
		tanque.moverDerecha();
		assertTrue(Espacio.getInstancia().incluyeA(bonus));
		tanque.disparar();
		assertTrue(Espacio.getInstancia().incluyeA(bonus));
	}
	
	/**
	 * @see testMirageTankNoAfectarBonusVidaDesdeIzquierda()
	 */
	public void testMirageTankNoAfectarBonusVelocidadDesdeIzquierda() {
		tanque = new MirageTank(new Posicion(0,0));
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
	public void testMirageTankDestruirCuartelArgentinoYJuegoPerdidoDesdeIzquierda() {
		tanque = new MirageTank(new Posicion(0,0));
		CuartelArgentino cuartel = new CuartelArgentino(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado()+tanque.getVelocidad(),0));
		tanque.moverDerecha();
		assertTrue(Espacio.getInstancia().incluyeA(cuartel));
		assertFalse(Espacio.getInstancia().juegoPerdido());
		tanque.disparar();
		assertFalse(Espacio.getInstancia().incluyeA(cuartel));
		assertTrue(Espacio.getInstancia().juegoPerdido());
	}

}
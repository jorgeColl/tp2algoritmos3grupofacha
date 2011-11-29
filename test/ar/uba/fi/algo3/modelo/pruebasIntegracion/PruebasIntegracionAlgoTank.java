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
 * Llevo a cabo las pruebas de integración de AlgoTank con los demás objetos del juego.
 * @author Tomás
 *
 */
public class PruebasIntegracionAlgoTank extends TestCase {

	private AlgoTank tanque;
	
	protected void setUp() throws Exception {
		super.setUp();
		Espacio.getInstancia().reiniciar();
	}
	
	/**
	 * Hago mover al tanque hasta que impacte con un BonusVelocidad y testeo que sus velocidades mejoren en el valor esperado.
	 */
	public void testAlgoTankMejorarVelocidades() {
		tanque = new AlgoTank(new Posicion(0,0));
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
	public void testAlgoTankMejorarResistencia() {
		tanque = new AlgoTank(new Posicion(0,0));
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
	
	/* ALGO TANK NO PUEDE CHOCAR CON SÍ MISMO DADO QUE EL ESPACIO SÓLO TOLERA UNA INSTANCIA DE SU CLASE. */
	
	/**
	 * Hago chocar al tanque con una instancia de GrizzlyBattleTank y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testAlgoTankChocarConGrizzlyBattleTankDesdeArriba() {
		tanque = new AlgoTank(new Posicion(0,0));
	//	GrizzlyBattleTank otroTanque = new GrizzlyBattleTank(new Posicion(0,((OcupacionCuadrada)tanque.getOcupacion()).getLado()));
		tanque.moverAbajo();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/**
	 * Hago chocar al tanque con una instancia de IFV y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testAlgoTankChocarConIFVDesdeIzquierda() {
		tanque = new AlgoTank(new Posicion(0,0));
	//	IFV otroTanque = new IFV(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado(),0));
		tanque.moverDerecha();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/**
	 * Hago chocar al tanque con una instancia de MirageTank y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testAlgoTankChocarConMirageTankDesdeDerecha() {
		MirageTank otroTanque = new MirageTank(new Posicion(0,0));
		tanque = new AlgoTank(new Posicion(((OcupacionCuadrada)otroTanque.getOcupacion()).getLado(),0));
		tanque.moverIzquierda();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),((OcupacionCuadrada)otroTanque.getOcupacion()).getLado());
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}

	/* HAGO QUE CHOQUE CON TODOS LOS TIPOS DE PARED DESDE DISTINTAS POSICIONES RELATIVAS */
	
	/**
	 * Hago chocar al tanque con una instancia de ParedConcreto y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testAlgoTankChocarConParedConcretoDesdeIzquierda() {
		tanque = new AlgoTank(new Posicion(0,0));
	//	ParedConcreto pared = new ParedConcreto(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado(),0));
		tanque.moverDerecha();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/**
	 * Hago chocar al tanque con una instancia de ParedMetal y testeo que su ocupación no cambie porque este se interpuso en su camino.
	 */
	public void testAlgoTankChocarConParedMetalDesdeDerecha() {
		ParedMetal pared = new ParedMetal(new Posicion(0,0));
		tanque = new AlgoTank(new Posicion(((OcupacionCuadrada)pared.getOcupacion()).getLado(),0));
		tanque.moverIzquierda();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),((OcupacionCuadrada)pared.getOcupacion()).getLado());
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/* HAGO QUE EL TANQUE CHOQUE CON UNA INSTANCIA DE CUARTEL ARGENTINO Y TESTEO QUE ESTA SE INTERPONGA EN SU CAMINO */
	
	/**
	 * Sitúo a una instancia del tanque contiguamente a una del cuartel, a su izquierda. Lo hago mover a la derecha. Testeo que su posición siga siendo la inicial porque el cuartel se interpuso en su camino.
	 */
	public void testAlgoTankChocarConCuartelArgentinoDesdeIzquierda() {
		tanque = new AlgoTank(new Posicion(0,0));
	//	CuartelArgentino cuartel = new CuartelArgentino(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado(),0));		
		tanque.moverDerecha();
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getX(),0);
		assertEquals(((OcupacionCuadrada)tanque.getOcupacion()).getPuntoMenorModulo().getY(),0);
	}
	
	/* TESTEO SI AL SER DESTRUIDOS LOS TANQUES ENEMIGOS QUE ENTREGAN ARMAS A ALGO TANK ESTO SE HACE CORRECTAMENTE */
	
	/**
	 * Chequeo que la munición inicial del cañón de una instancia de AlgoTank sea nula (no tiene armas prioritarias), y que luego de que desaparezca una instancia de IFV esta aumente.
	 */
	public void testAlgoTankAumentarMunicionCanionConDestruccionDeIFV() {
		tanque = new AlgoTank(new Posicion(0,0));
		IFV otroTanque = new IFV(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado(),0));
		int municionEsperada = ((Canion)otroTanque.getArma()).getMunicion();
		assertTrue(tanque.getArmasPrioritarias().isEmpty());
		otroTanque.desaparecer();
		assertEquals(tanque.getArmasPrioritarias().peek().getMunicion(),municionEsperada);
	}

	/**
	 * Chequeo que la munición inicial del lanza cohetes de una instancia de AlgoTank sea nula (no tiene armas prioritarias), y que luego de que desaparezca una instancia de MirageTank esta aumente.
	 */
	public void testAlgoTankAumentarMunicionLanzaCohetesConDestruccionDeMirageTank() {
		tanque = new AlgoTank(new Posicion(0,0));
		MirageTank otroTanque = new MirageTank(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado(),0));
		int municionEsperada = ((LanzaCohetes)otroTanque.getArma()).getMunicion();
		assertTrue(tanque.getArmasPrioritarias().isEmpty());
		otroTanque.desaparecer();
		assertEquals(tanque.getArmasPrioritarias().peek().getMunicion(),municionEsperada);
	}
	
	/* A CONTINUACION HAGO QUE UNA INSTANCIA DE ALGO TANK DESTRUYA O DAÑE A CADA UNO DE LOS OTROS TANQUES CON CADA UNA DE LAS ARMAS QUE PUEDE TENER Y EN DISTINTAS POSICIONES RELATIVAS */
	
	/**
	 * Sitúo un tanque continuamente a AlgoTank y hago que el dispare su ametralladora hasta que lo destrulla.
	 * Testeo que el tanque enemigo haya desaparecido del escenario.
	 * NOTA: Pongo un contador para evitar que si el test falla se inicie un ciclo infinito, y si la salida del ciclo no es la esperada repruebo el test.
	 */
	public void testAlgoTankDestruirGrizzlyBattleTankConAmetralladoraDesdeIzquierda() {
		tanque = new AlgoTank(new Posicion(0,0));
		GrizzlyBattleTank otroTanque = new GrizzlyBattleTank(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado(),0));
		tanque.moverDerecha();
		assertTrue(Espacio.getInstancia().incluyeA(otroTanque));
		int contador = 0;
		while ((otroTanque.getResistencia() > 0)&&(contador < 100)) {
			tanque.vivir();
			tanque.disparar();
			++contador;
		}
		if (otroTanque.getResistencia() > 0)
			fail();
		assertFalse(Espacio.getInstancia().incluyeA(otroTanque));
	}
	
	/**
	 * @see testAlgoTankDestruirGrizzlyBattleTankConAmetralladoraDesdeIzquierda()
	 * Testeo además que la municion del cañón disminuya como se espera.
	 */
	public void testAlgoTankDestruirGrizzlyBattleTankConCanionDesdeDerecha() {
		GrizzlyBattleTank otroTanque = new GrizzlyBattleTank(new Posicion(0,0));
		tanque = new AlgoTank(new Posicion(((OcupacionCuadrada)otroTanque.getOcupacion()).getLado(),0));
		tanque.entregarArma(new Canion(tanque,25));
		tanque.moverIzquierda();
		assertTrue(Espacio.getInstancia().incluyeA(otroTanque));
		int contador = 0;
		while ((otroTanque.getResistencia() > 0)&&(contador < 100)) {
			tanque.vivir();
			tanque.disparar();
			++contador;
		}
		if (otroTanque.getResistencia() > 0)
			fail();
		assertEquals(tanque.getArmasPrioritarias().peek().getMunicion(),21);
		assertFalse(Espacio.getInstancia().incluyeA(otroTanque));
	}
	
	/**
	 * @see testAlgoTankDestruirGrizzlyBattleTankConAmetralladoraDesdeIzquierda()
	 * En este caso lo dañamos dado que el lanza cohetes no puede destruir un tanque porque siempre le quita la mitad de su resistencia actual.
	 * Testeo además que la municion del lanza cohetes disminuya como se espera.
	 */
	public void testAlgoTankDaniarGrizzlyBattleTankConLanzaCohetesDesdeAbajo() {
		GrizzlyBattleTank otroTanque = new GrizzlyBattleTank(new Posicion(0,0));
		tanque = new AlgoTank(new Posicion(0,((OcupacionCuadrada)otroTanque.getOcupacion()).getLado()));
		tanque.entregarArma(new LanzaCohetes(tanque,25));
		tanque.moverArriba();
		assertTrue(Espacio.getInstancia().incluyeA(otroTanque));
		int contador = 0;
		while ((otroTanque.getResistencia() > 1)&&(contador < 100)) {
			tanque.vivir();
			tanque.disparar();
			++contador;
		}
		if (otroTanque.getResistencia() > 1)
			fail();
		assertEquals(tanque.getArmasPrioritarias().peek().getMunicion(),18);
		assertTrue(Espacio.getInstancia().incluyeA(otroTanque));
	}

	/**
	 * testAlgoTankDestruirGrizzlyBattleTankConAmetralladoraDesdeIzquierda()
	 */
	public void testAlgoTankDestruirIFVConAmetralladoraDesdeIzquierda() {
		tanque = new AlgoTank(new Posicion(0,0));
		IFV otroTanque = new IFV(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado(),0));
		tanque.moverDerecha();
		assertTrue(Espacio.getInstancia().incluyeA(otroTanque));
		int contador = 0;
		while ((otroTanque.getResistencia() > 0)&&(contador < 100)) {
			tanque.vivir();
			tanque.disparar();
			++contador;
		}
		if (otroTanque.getResistencia() > 0)
			fail();
		assertFalse(Espacio.getInstancia().incluyeA(otroTanque));
	}
	
	/**
	 * @see testAlgoTankDestruirGrizzlyBattleTankConCanionDesdeIzquierda()
	 * Testeo además que la municion del cañón AUMENTE como se espera.
	 */
	public void testAlgoTankDestruirIFVConCanionDesdeDerecha() {
		IFV otroTanque = new IFV(new Posicion(0,0));
		tanque = new AlgoTank(new Posicion(((OcupacionCuadrada)otroTanque.getOcupacion()).getLado(),0));
		tanque.entregarArma(new Canion(tanque,10));
		tanque.moverIzquierda();
		assertTrue(Espacio.getInstancia().incluyeA(otroTanque));
		int contador = 0;
		while ((otroTanque.getResistencia() > 0)&&(contador < 100)) {
			tanque.vivir();
			tanque.disparar();
			++contador;
		}
		if (otroTanque.getResistencia() > 0)
			fail();
		//TENER EN CUENTA QUE CUANDO ALGO TANK DESTRUYE A UNA INSTANCIA DE IFV SE APODERA DE SU ARMA Y POR ESO LA MUNICIÓN QUE TESTEAMOS AHORA ES 25
		assertEquals(tanque.getArmasPrioritarias().peek().getMunicion(),25);
		assertFalse(Espacio.getInstancia().incluyeA(otroTanque));
	}
	
	/**
	 * @see testAlgoTankDestruirGrizzlyBattleTankConLanzaCohetesDesdeIzquierda()
	 */
	public void testAlgoTankDaniarIFVConLanzaCohetesDesdeAbajo() {
		IFV otroTanque = new IFV(new Posicion(0,0));
		tanque = new AlgoTank(new Posicion(0,((OcupacionCuadrada)otroTanque.getOcupacion()).getLado()));
		tanque.entregarArma(new LanzaCohetes(tanque,25));
		tanque.moverArriba();
		assertTrue(Espacio.getInstancia().incluyeA(otroTanque));
		int contador = 0;
		while ((otroTanque.getResistencia() > 1)&&(contador < 100)) {
			tanque.vivir();
			tanque.disparar();
			++contador;
		}
		if (otroTanque.getResistencia() > 1)
			fail();
		assertEquals(tanque.getArmasPrioritarias().peek().getMunicion(),18);
		assertTrue(Espacio.getInstancia().incluyeA(otroTanque));
	}
	
	/**
	 * testAlgoTankDestruirGrizzlyBattleTankConAmetralladoraDesdeIzquierda()
	 */
	public void testAlgoTankDestruirMirageTankConAmetralladoraDesdeIzquierda() {
		tanque = new AlgoTank(new Posicion(0,0));
		MirageTank otroTanque = new MirageTank(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado(),0));
		tanque.moverDerecha();
		assertTrue(Espacio.getInstancia().incluyeA(otroTanque));
		int contador = 0;
		while ((otroTanque.getResistencia() > 0)&&(contador < 100)) {
			tanque.vivir();
			tanque.disparar();
			++contador;
		}
		if (otroTanque.getResistencia() > 0)
			fail();
		assertFalse(Espacio.getInstancia().incluyeA(otroTanque));
	}
	
	/**
	 * @see testAlgoTankDestruirGrizzlyBattleTankConCanionDesdeIzquierda()
	 */
	public void testAlgoTankDestruirMirageTankConCanionDesdeDerecha() {
		MirageTank otroTanque = new MirageTank(new Posicion(0,0));
		tanque = new AlgoTank(new Posicion(((OcupacionCuadrada)otroTanque.getOcupacion()).getLado(),0));
		tanque.entregarArma(new Canion(tanque,10));
		tanque.moverIzquierda();
		assertTrue(Espacio.getInstancia().incluyeA(otroTanque));
		int contador = 0;
		while ((otroTanque.getResistencia() > 0)&&(contador < 100)) {
			tanque.vivir();
			tanque.disparar();
			++contador;
		}
		if (otroTanque.getResistencia() > 0)
			fail();
		assertEquals(tanque.getArmasPrioritarias().peek().getMunicion(),25);
		assertFalse(Espacio.getInstancia().incluyeA(otroTanque));
	}
	
	/**
	 * @see testAlgoTankDestruirGrizzlyBattleTankConLanzaCohetesDesdeIzquierda()
	 */
	public void testAlgoTankDaniarMirageTankConLanzaCohetesDesdeAbajo() {
		MirageTank otroTanque = new MirageTank(new Posicion(0,0));
		tanque = new AlgoTank(new Posicion(0,((OcupacionCuadrada)otroTanque.getOcupacion()).getLado()));
		tanque.entregarArma(new LanzaCohetes(tanque,25));
		tanque.moverArriba();
		assertTrue(Espacio.getInstancia().incluyeA(otroTanque));
		int contador = 0;
		while ((otroTanque.getResistencia() > 1)&&(contador < 100)) {
			tanque.vivir();
			tanque.disparar();
			++contador;
		}
		if (otroTanque.getResistencia() > 1)
			fail();
		assertEquals(tanque.getArmasPrioritarias().peek().getMunicion(),18);
		assertTrue(Espacio.getInstancia().incluyeA(otroTanque));
	}
	
	/* A CONTINUACIÓN TESTEO QUE ALGO TANK PUEDA DESTRUIR CORRECTAMENTE A LOS DISTINTOS TIPOS DE PARED Y AL CUARTEL ARGENTINO, EN DISTINTAS POSICIONES RELATIVAS */
	
	/**
	 * Agrego una instancia de la pared y del tanque en posiciones tales que los disparos del segundo vayan a impactar con la primera, y testeamos que al primer disparo desaparezca.
	 */
	public void testAlgoTankDestruirParedConcretoConAmetralladoraDesdeAbajo() {
		ParedConcreto pared = new ParedConcreto(new Posicion(0,0));
		tanque = new AlgoTank(new Posicion(0,((OcupacionCuadrada)pared.getOcupacion()).getLado()));
		tanque.moverArriba();
		assertTrue(Espacio.getInstancia().incluyeA(pared));
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.disparar();
		assertFalse(Espacio.getInstancia().incluyeA(pared));
	}
	
	/**
	 * Agrego una instancia de la pared y del tanque en posiciones tales que los disparos del segundo vayan a impactar con la primera, y testeamos que al primer disparo no desaparezca pero al segundo sí.
	 */
	public void testAlgoTankDestruirParedMetalConAmetralladoraDesdeDerecha() {
		ParedMetal pared = new ParedMetal(new Posicion(0,0));
		tanque = new AlgoTank(new Posicion(((OcupacionCuadrada)pared.getOcupacion()).getLado(),0));
		tanque.moverIzquierda();
		assertTrue(Espacio.getInstancia().incluyeA(pared));
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.disparar();
		assertTrue(Espacio.getInstancia().incluyeA(pared));
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.disparar();
		assertFalse(Espacio.getInstancia().incluyeA(pared));
	}
	
	/**
	 * Agrego un cuartel argentino en una posición continua a una instancia de AlgoTank tal que los disparos lo impacten, y testeamos que antes del primer disparo el cuartel no haya desaparecido y que el juego no esté perdido, y que al primer disparo el cuartel haya desaparecido y que el juego resulte perdido.
	 */
	public void testAlgoTankDestruirCuartelArgentinoDesdeIzquierdaYJuegoPerdido() {
		tanque = new AlgoTank(new Posicion(0,0));
		CuartelArgentino cuartel = new CuartelArgentino(new Posicion(((OcupacionCuadrada)tanque.getOcupacion()).getLado(),0));
		tanque.moverDerecha();
		assertTrue(Espacio.getInstancia().incluyeA(cuartel));
		assertFalse(Espacio.getInstancia().juegoPerdido());
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.vivir();
		tanque.disparar();
		assertFalse(Espacio.getInstancia().incluyeA(cuartel));
		assertTrue(Espacio.getInstancia().juegoPerdido());
	}
	
}
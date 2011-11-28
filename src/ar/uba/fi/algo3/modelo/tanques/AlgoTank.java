package ar.uba.fi.algo3.modelo.tanques;

import ar.uba.fi.algo3.modelo.armamentista.arma.Ametralladora;
import ar.uba.fi.algo3.modelo.armamentista.arma.Canion;
import ar.uba.fi.algo3.modelo.armamentista.arma.LanzaCohetes;
import ar.uba.fi.algo3.modelo.estrategias.estrategiasDisparo.EstrategiaDisparoAlgoTank;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;

/**
 * Modela al tanque manejado por el jugador.
 * @author Tomás
 *
 */
public class AlgoTank extends Tanque {

	private Ametralladora ametralladora;
	private Canion canion;
	private LanzaCohetes lanzaCohetes;
	
	public AlgoTank(Posicion punto) {
		super(punto);
		ametralladora = new Ametralladora(this);
		canion = new Canion(this,0);
		estrategiaDisparo = new EstrategiaDisparoAlgoTank(this);
		lanzaCohetes = new LanzaCohetes(this,0);
		orientacion = Orientacion.j;
		velocidad = 2;
		velocidadDisparo = 8;
		try {
			Espacio.getInstancia().agregarTanqueJugador(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Le pide a su estrategia de disparo que resuelva el qué arma disparar, siempre y cuando esto pueda hacerse.
	 */
	public void disparar() {
		estrategiaDisparo.decidirDisparo();
	}
	
	/**
	 * Delega en la clase Ametralladora.
	 */
	public void dispararAmetralladora() {
		ametralladora.disparar();
	}
	
	/**
	 * Delega en la clase Canion.
	 */
	public void dispararCanion() {
		canion.disparar();
	}
	
	/**
	 * Delega en la clase LanzaCohetes.
	 */
	public void dispararLanzaCohetes() {
		lanzaCohetes.disparar();
	}

	/**
	 * 
	 * @return instancia de la clase Ametralladora perteneciente al tanque
	 */
	public Ametralladora getAmetralladora() {
		return ametralladora;
	}

	/**
	 * 
	 * @return instancia de la clase Canion perteneciente al tanque
	 */
	public Canion getCanion() {
		return canion;
	}

	/**
	 * 
	 * @return instancia de la clase LanzaCohetes perteneciente al tanque
	 */
	public LanzaCohetes getLanzaCohetes() {
		return lanzaCohetes;
	}
	
	/**
	 * 
	 * @param municion entero que sumaremos a la munición del cañón
	 */
	public void incrementarMunicionCanion(int municion) {
		canion.incrementarMunicion(municion);
	}

	/**
	 * 
	 * @param municion entero que sumaremos a la munición del lanza cohetes
	 */
	public void incrementarMunicionLanzaCohetes(int municion) {
		lanzaCohetes.incrementarMunicion(municion);
	}

	
	public void vivir() {
		estrategiaDisparo.informarTranscursoTiempo();
	}
	
}

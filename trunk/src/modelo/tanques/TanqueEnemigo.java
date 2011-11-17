package modelo.tanques;

import modelo.armamentista.arma.Arma;
import modelo.estrategias.estrategiasDisparo.EstrategiaDisparoVelocidadDependiente;
import modelo.estrategias.estrategiasMovimiento.EstrategiaMovimiento;
import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.Orientacion;
import modelo.manejoEspacial.Posicion;

/**
 * Proveé el estado y el comportamiento común de los tanques enemigos.
 * @author Tomás
 *
 */
public abstract class TanqueEnemigo extends Tanque {
	
	protected Arma arma;
	protected EstrategiaMovimiento estrategiaMovimiento;
	protected int puntosPorDestruccion;
	
	public TanqueEnemigo(Posicion puntoMenorModulo) {
		super(puntoMenorModulo);
		estrategiaDisparo = new EstrategiaDisparoVelocidadDependiente(this);
		orientacion = Orientacion.jNegativo;
		try {
			Espacio.getInstancia().agregarTanqueEnemigo(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Delega en su instancia de una subclase de Arma.
	 */
	public void disparar() {
		arma.disparar();
	}
	
	/**
	 * 
	 * @return arma del tanque
	 */
	public Arma getArma() {
		return arma;
	}

	/**
	 * 
	 * @return entero representante de los puntos que se obtienen al destruir al tanque
	 */
	public int getPuntosPorDestruccion() {
		return puntosPorDestruccion;
	}
	
	/**
	 * Le indica al tanque que se mueva y dispare si es necesario, delegando en las estrategias correspondientes.
	 */
	public void vivir() {
		estrategiaMovimiento.dedicirMovimiento();
		estrategiaDisparo.decidirDisparo();
		estrategiaDisparo.informarTranscursoTiempo();
	}
	
}

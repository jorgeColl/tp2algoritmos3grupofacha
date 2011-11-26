package modelo.tanques;

import java.util.Stack;

import modelo.armamentista.arma.Ametralladora;
import modelo.armamentista.arma.ArmaMunicionLimitada;
import modelo.estrategias.estrategiasDisparo.EstrategiaDisparoAlgoTank;
import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.Orientacion;
import modelo.manejoEspacial.Posicion;

/**
 * Modela al tanque manejado por el jugador.
 * @author Tomás
 *
 */
public class AlgoTank extends Tanque {

	private Ametralladora ametralladora;
	private Stack<ArmaMunicionLimitada> armasPrioritarias;
	
	public AlgoTank(Posicion punto) {
		super(punto);
		ametralladora = new Ametralladora(this);
		armasPrioritarias = new Stack<ArmaMunicionLimitada>();
		estrategiaDisparo = new EstrategiaDisparoAlgoTank(this);
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
	 * Le pide a su estrategia de disparo que resuelva el qué arma disparar, siempre y cuando esto sea temporalmente posible.
	 */
	public void disparar() {
		estrategiaDisparo.decidirDisparo();
	}
	
	/**
	 * Cambiamos el dueño del arma y la agregamos a las del tanque, siempre y cuando no tengan munición nula.
	 * @param arma instancia de una subclase de ArmaMunicionLimitada que se sumará a las del tanque
	 */
	public void entregarArma(ArmaMunicionLimitada arma) {
		arma.setDuenio(this);
		if (arma.getMunicion() > 0)
			armasPrioritarias.push(arma);
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
	 * @return pila de las armas robadas por el tanque, en órden de prioridad
	 */
	public Stack<ArmaMunicionLimitada> getArmasPrioritarias() {
		return armasPrioritarias;
	}
	
	public void vivir() {
		estrategiaDisparo.informarTranscursoTiempo();
	}
	
}

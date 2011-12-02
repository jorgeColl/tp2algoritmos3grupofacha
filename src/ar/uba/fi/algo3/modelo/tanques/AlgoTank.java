package ar.uba.fi.algo3.modelo.tanques;

import java.util.Stack;

import ar.uba.fi.algo3.ConstructorVista;
import ar.uba.fi.algo3.modelo.armamentista.arma.Ametralladora;
import ar.uba.fi.algo3.modelo.armamentista.arma.ArmaMunicionLimitada;
import ar.uba.fi.algo3.modelo.estrategias.estrategiasDisparo.EstrategiaDisparoAlgoTank;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.vista.VistaAlgoTank;

/**
 * Modela al tanque manejado por el jugador.
 * @author Tom�s
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
		
		/* agrego la instancia en el Espacio */
		try {
			Espacio.getInstancia().agregarTanqueJugador(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (Espacio.getInstancia().incluyeA(this)){
			ConstructorVista.construirVista(this);
		}
		
		
	}
	
	/**
	 * Le pide a su estrategia de disparo que resuelva el qu� arma disparar, siempre y cuando esto sea temporalmente posible.
	 */
	public void disparar() {
		estrategiaDisparo.decidirDisparo();
	}
	
	/**
	 * Cambiamos el due�o del arma y la agregamos a las del tanque, siempre y cuando no tengan munici�n nula.
	 * @param arma instancia de una subclase de ArmaMunicionLimitada que se sumar� a las del tanque
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
	 * @return pila de las armas robadas por el tanque, en �rden de prioridad
	 */
	public Stack<ArmaMunicionLimitada> getArmasPrioritarias() {
		return armasPrioritarias;
	}
	
	public void vivir() {
		estrategiaDisparo.informarTranscursoTiempo();
	}
	
}

/**
 * 
 */
package ar.uba.fi.algo3.controlador;


import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.vista.ConstructorVista;

/**
 * @author jc
 * Clase que modela la logica de un nivel generico del juego.
 * Utiliza el patron de disenio Singleton.
 */
public class Nivel {
	
	private Persistidor persistidor;
	protected Fabricador fabricador;
	static Nivel instancia;
	private boolean juegoEmpezado;
	private int contadorParaReinicio;
	private static final int PUNTOS_PARA_GANAR = 1000;
	
	private Nivel(){
		persistidor = new Persistidor();
		fabricador = new Fabricador();
		juegoEmpezado = false;
		contadorParaReinicio = 0;
	}
	
    /**
     * Corre la logica del nivel.
     */
	public void correrLogica(){
		if(!juegoEmpezado) return;
		if(this.nivelGanado()){
			ConstructorVista.construirVistaJuegoTerminado(this);
			ControladorJuego.getInstancia().desactivarEscuchadores();
			contadorParaReinicio++;
			if(contadorParaReinicio>50){
				contadorParaReinicio=0;
				this.cargarProximoNivel();
			}
		} else if(this.nivelPerdido()){
			ConstructorVista.construirVistaJuegoTerminado(this);
			ControladorJuego.getInstancia().desactivarEscuchadores();
			contadorParaReinicio++;
			if(contadorParaReinicio>100)
				this.reiniciar();
		} else {
			Espacio.getInstancia().correrLogica();
			fabricador.decidirAgregarTanqueEnemigo();
			fabricador.decidirAgregarBonus();
		}
	}
	
	
	/**
	 * Reinicia el nivel, reiniciando el espacio con sus objetos
	 * y el controlador con sus dibujables.
	 */
	private void reiniciar() {
		Espacio.getInstancia().reiniciar();
		ControladorJuego.getInstancia().reiniciar();
		Nivel.instancia = null;
		Nivel.getInstancia();
	}
	
	/**
	 * Delega al persistidor la carga del proximo nivel desde archivo.
	 */
	public void cargarProximoNivel(){
		Espacio.getInstancia().reiniciar();
		ControladorJuego.getInstancia().reiniciar();
		persistidor.cargarProximoNivel();
		this.empezarNivel();
	}
	
	/**
	 * Delega al persistidor la carga de un juego guardado desde archivo.
	 */
	public void cargarNivelGuardado(){
		Espacio.getInstancia().reiniciar();
		ControladorJuego.getInstancia().reiniciar();
		this.persistidor.cargarJuegoGuardado();
		this.empezarNivel();
	}
	
	/**
	 * Guarda el nivel en un archivo XML.
	 */
	public void guardarNivel(){
		persistidor.guardarNivel();
	}
	
	/**
	 * @return true si se gano el juego y false en el caso contrario.
	 */
	public boolean nivelGanado(){
		if (Espacio.getInstancia().getTanqueJugador() == null) 
			return false;
		return (Espacio.getInstancia().getTanqueJugador().getPuntaje() >= PUNTOS_PARA_GANAR);
	}
	
	/**
	 * Se pierde el juego solo cuando se elimina el tanque del jugador o
	 * cuando se elimina el cuartel argentino.
	 * @return true si se perdio el juego y false en el caso contrario
	 */
	public boolean nivelPerdido() {
		if(! this.juegoEmpezado) return false;
		return (Espacio.getInstancia().getCuartelArgentino() == null || 
				Espacio.getInstancia().getTanqueJugador() == null);
	}
	
	/**
	 * Utiliza el patron Singleton para que solo haya una instancia de nivel.
	 */
	public static Nivel getInstancia() {
		if (instancia == null){
			instancia = new Nivel();;
			ConstructorVista.construirVistaInicioNivel();
		}
		return instancia;
	}
	
	/**
	 * Alterna la variable de estado que indica si el nivel esta o no empezado.
	 */
	public void empezarNivel(){
		this.juegoEmpezado = true;
	}
}

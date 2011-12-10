/**
 * 
 */
package ar.uba.fi.algo3;

import ar.uba.fi.algo3.modelo.objetosInanimados.BonusVelocidad;
import ar.uba.fi.algo3.modelo.objetosInanimados.BonusVida;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.GrizzlyBattleTank;
import ar.uba.fi.algo3.modelo.tanques.IFV;
import ar.uba.fi.algo3.modelo.tanques.MirageTank;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.vista.ConstructorVista;

/**
 * @author jc
 * Clase que modela la logica de un nivel generico del juego.
 */
public class Nivel {
	private Persistidor persistidor;
	private boolean juegoEmpezado;
	static Nivel instancia;
	private int contadorParaReinicio;
	private static final int PUNTOS_PARA_GANAR = 50;
	
	private Nivel(){
		persistidor = new Persistidor();
		juegoEmpezado = false;
		this.contadorParaReinicio = 0;
	}
	
    /**
     * Corre la logica del nivel.
     */
	public void correrLogica(){
		if(!juegoEmpezado) return;
		if(this.nivelGanado())
			this.cargarProximoNivel();
		else if(this.nivelPerdido()){
			ControladorJuego.getInstancia().desactivarEscuchadores();
			ConstructorVista.construirVistaJuegoPerdido();
			contadorParaReinicio++;
			if(contadorParaReinicio>100)
				this.reiniciar();
		} else {
			Espacio.getInstancia().correrLogica();
			decidirAgregarTanqueEnemigo();
			decidirAgregarBonus();
		}
	}
	
	/**
	 * Método que agrega cuatro tanques enemigos cuyas clases y posiciones son elegidas al azar.
	 * Los tanques son agregados siempre lo más al norte posible del espacio. 
	 */
	private void decidirAgregarTanqueEnemigo() {
		if (Espacio.getInstancia().hayTanquesEnemigos()) return;
		int contador = 0;
		while (contador < 4) {
			int numero = (int)(Math.random()*3);
			OcupacionCuadrada ocupacionAuxiliar = 
					Espacio.getInstancia().getOcupacionCuadradaVaciaAlAzarEnBordeSuperior(43);
			Posicion posicionAuxiliar = 
					new Posicion(ocupacionAuxiliar.getPuntoMenorModulo().getX(),
							     ocupacionAuxiliar.getPuntoMenorModulo().getY());
			switch (numero) {
				case 0: new GrizzlyBattleTank(posicionAuxiliar); break;
				case 1: new IFV(posicionAuxiliar); break;
				case 2: new MirageTank(posicionAuxiliar); break;
			}
			++contador;
		}	
	}
	
	/**
	 * Método que agrega al azar bonus de vida o de velocidad, en posiciones también al azar. 
	 */
	private void decidirAgregarBonus() {
		int numero = (int)(Math.random()*666);
		OcupacionCuadrada ocupacionAuxiliar = 
				Espacio.getInstancia().getOcupacionCuadradaVaciaAlAzar(43);
		Posicion posicionAuxiliar = 
				new Posicion(ocupacionAuxiliar.getPuntoMenorModulo().getX(),
						     ocupacionAuxiliar.getPuntoMenorModulo().getY());
		switch (numero) {
			case 222: new BonusVida(posicionAuxiliar); break;
			case 444: new BonusVelocidad(posicionAuxiliar); break;
		}
	}
	
	/**
	 * Reinicia el nivel, reiniciando tambien el espacio con sus objetos.
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
	 * 
	 * @return true si se gano el juego y false en el caso contrario
	 */
	public boolean nivelGanado(){
		if (Espacio.getInstancia().getTanqueJugador() == null) 
			return false;
		return (Espacio.getInstancia().getTanqueJugador().getPuntaje() >= PUNTOS_PARA_GANAR);
	}
	
	/**
	 * Cuando el cuartel argentino es destruido, entonces se perdio el juego.
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
			instancia = new Nivel();
			ConstructorVista.construirVistaInicioNivel();
		}
		return instancia;
	}
	
	/**
	 * Cambia la variable de estado que indica si el nivel esta o no empezado.
	 */
	public void empezarNivel(){
		this.juegoEmpezado = true;
	}
}

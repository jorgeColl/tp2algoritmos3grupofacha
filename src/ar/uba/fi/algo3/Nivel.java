/**
 * 
 */
package ar.uba.fi.algo3;


import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;


/**
 * @author jc
 * Clase que modela un nivel generico del juego.
 */
public class Nivel {
	private Persistidor persistidor;
	private boolean juegoEmpezado;
	static Nivel instancia;
	private Fabricador fabrica;
	private int contadorParaReinicio;
	
	private Nivel(){
		persistidor = new Persistidor();
		juegoEmpezado = false;
		fabrica = new Fabricador (1000,1000);
		this.contadorParaReinicio = 0;
	}
	
    /**
     * Corre la logica del nivel.
     *  */
	public void correrLogica() {
		if(juegoEmpezado){
			if(this.nivelGanado()){
				this.cargarNivel();

			}else{
				if(this.nivelPerdido()){
					contadorParaReinicio++;
					if (contadorParaReinicio>100){
						this.reiniciar();
					}
				}else{
					Espacio.getInstancia().correrLogica();
					fabrica.fabricarTanquesEnemigos();
					fabrica.fabricarBonus();
				}
			
			}
		}
			
	}
	private void reiniciar() {
		Espacio.getInstancia().reiniciar();
		Nivel.instancia = null;
		Nivel.getInstancia();
		
	}
	
	public void cargarNivel(){
		//reiniciar provisorio
		Espacio.getInstancia().reiniciar();
		persistidor.cargarProximoNivel();
		this.empezarNivel();
	}
	
	public void cargarNivelGuardado(){
		Espacio.getInstancia().reiniciar();
		this.persistidor.cargarJuegoGuardado();
		this.empezarNivel();
	}
	
	public void guardarNivel(){
		persistidor.guardarNivel();
	}
	
	/**
	 * 1000 es el puntaje que necesita para ganar el nivel
	 * @return true si se gano el juego y false en el caso contrario
	 */
	public boolean nivelGanado(){
		if (Espacio.getInstancia().getTanqueJugador() == null) return false;
		return (Espacio.getInstancia().getTanqueJugador().getPuntaje() >= 1000);
	}
	
	/**
	 * Cuando el cuartel argentino es destruido, entonces se perdio el juego.
	 * @return true si se perdio el juego y false en el caso contrario
	 */
	public boolean nivelPerdido() {
		if(this.juegoEmpezado==false){
			return false;
		}
		return (Espacio.getInstancia().getCuartelArgentino() == null || 
				Espacio.getInstancia().getTanqueJugador() == null);
	}
	
	/**
	 * Utiliza el patron Singleton para que solo haya una instancia de nivel.
	 */
	public static Nivel getInstancia() {
		if (instancia == null){
			instancia = new Nivel();
			ConstructorVista.construirVista(instancia);
		}
		return instancia;
	}
	public void empezarNivel(){
		this.juegoEmpezado=true;
	}
}

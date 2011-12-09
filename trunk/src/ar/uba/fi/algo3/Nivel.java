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
	
	private Nivel(){
		persistidor = new Persistidor();
		juegoEmpezado = false;
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
					this.reiniciar();
				}else{
					Espacio.getInstancia().correrLogica();
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
		juegoEmpezado = true;
	}
	
	public void cargarNivelGuardado(){
		Espacio.getInstancia().reiniciar();
		this.persistidor.cargarJuegoGuardado();
		juegoEmpezado = true;
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
}

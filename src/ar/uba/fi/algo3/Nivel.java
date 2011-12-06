/**
 * 
 */
package ar.uba.fi.algo3;

import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;

/**
 * @author jc
 *
 */
public class Nivel {
	private Persistidor persistidor;
	private boolean juegoEmpezado;
	static Nivel instancia;
	
	private Nivel(){
		persistidor = new Persistidor();
		juegoEmpezado = false;
		
	}
	public void correrLogica() {
		
		if(this.juegoGanado() || !juegoEmpezado){
			persistidor.cargarProximoNivel();
			juegoEmpezado = true;
		}else{
				Espacio.getInstancia().correrLogica();
			}
		
	}
	
	/**
	 * 1000 es el puntaje que necesita para ganar el nivel
	 * @return true si se gano el juego y false en el caso contrario
	 */
	public boolean juegoGanado(){
		if (Espacio.getInstancia().getTanqueJugador() == null) return false;
		return (Espacio.getInstancia().getTanqueJugador().getPuntaje() >= 1000);
	}
	/**
	 * Cuando el cuartel argentino es destruido, entonces se perdio el juego.
	 * @return true si se perdio el juego y false en el caso contrario
	 */
	public boolean juegoPerdido() {
		return (Espacio.getInstancia().getCuartelArgentino() == null || Espacio.getInstancia().getTanqueJugador() == null);
	}
	
	public static Nivel getInstancia() {
		if (instancia == null){
			instancia = new Nivel();
			ConstructorVista.construirVista(instancia);
		}
		return instancia;
	}


}

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
		
		if(juegoEmpezado){
			
			if(this.juegoGanado()){
				this.cargarNivel();
				}else{
					Espacio.getInstancia().correrLogica();
					}
			
		}
		
	}
	/*
	
	 * crea una panatalla de inicio permitiendole al usuario elegir si desea continuar desde el
	 * juego guardado o empezar uno nuevo
	 
	private void pantallaDeIinicio() {
		
		ControladorJuego controlador = ControladorJuego.getInstancia();

		Cuadrado cuadrado = new Cuadrado(400,300);
		cuadrado.setColor(Color.gray);
		cuadrado.setPosicionable(new PuntoParaTexto(new Posicion(101,0)));
		controlador.agregarDibujable(cuadrado);
		
		VistaJuego vista = new VistaJuego();
		vista.setPosicionable(new PuntoParaTexto(new Posicion(200,200)));
		controlador.agregarDibujable(vista);
		
	}
	*/
	public void cargarNivel(){
		//reiniciar provisorio
		Espacio.getInstancia().reiniciar();
		persistidor.cargarProximoNivel();
		juegoEmpezado = true;
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

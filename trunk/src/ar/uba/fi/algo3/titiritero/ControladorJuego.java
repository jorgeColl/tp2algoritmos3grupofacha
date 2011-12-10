package ar.uba.fi.algo3.titiritero;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import ar.uba.fi.algo3.Nivel;
import ar.uba.fi.algo3.titiritero.audio.Reproductor;

/**
 * @author Nicolas
 * Esta clase es la encargada de manejar todo el gameloop. Basicamente tiene una lista
 * de ObjetosVivos y una Dibujables que son recorridas en cada gameloop.
 */
public class ControladorJuego implements Runnable {
	
	private static ControladorJuego instancia;
	private long intervaloSimulacion;
	private boolean estaEnEjecucion;
	private boolean escuchadoresActivos;
	private List<Dibujable> dibujables;
	private Stack<Dibujable> aEliminar;
	private List<Dibujable> aAgregar;
	private List<MouseClickObservador> mouseClickObservadores;
	private List<KeyPressedObservador> keyPressedObservadores_aux;
	private List<KeyPressedObservador> keyPressedObservadores_aux2;
	private List<KeyPressedObservador> keyPressedObservadores;
	private SuperficieDeDibujo superficieDeDibujo;
	private Reproductor reproductor;
	private Thread hiloAudio;
	private boolean estaReproductorActivo;	
	
	private ControladorJuego(){
		dibujables = new ArrayList<Dibujable>();
		mouseClickObservadores = new ArrayList<MouseClickObservador>();
		keyPressedObservadores = new ArrayList<KeyPressedObservador>();
		keyPressedObservadores_aux = new ArrayList<KeyPressedObservador>();
		keyPressedObservadores_aux2 = new ArrayList<KeyPressedObservador>();
		aEliminar = new Stack<Dibujable>();
		aAgregar = new ArrayList<Dibujable>();
		escuchadoresActivos = true;
//		estaReproductorActivo = activarReproductor;
		if(estaReproductorActivo)
			reproductor = new Reproductor();		
	}
	
	/**
	 * Metodo de singleton.
	 * @return
	 */
	public static ControladorJuego getInstancia() {
		if (instancia == null)
			instancia = new ControladorJuego();
		return instancia;
	} 
	
	/**
	 * Devuelve el estado de ejecucion del controlador.
	 * @return
	 */
	public boolean estaEnEjecucion(){
		return this.estaEnEjecucion;
	}
	
	public void comenzarJuego(){
		estaEnEjecucion = true;
		try{
			while(estaEnEjecucion){
				Nivel.getInstancia().correrLogica();
				this.eliminarPendientes();
				this.agregarPendientes();
				dibujar();
				Thread.sleep(intervaloSimulacion);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void comenzarJuegoAsyn(){
		Thread thread = new Thread(this);
		thread.start();
		if(this.estaReproductorActivo){
			this.reproductor.encender();
			this.hiloAudio =  new Thread(this.reproductor);
			this.hiloAudio.start();
		}
	}

	/**
	 * Le da comienzo al juego poniendo en marcha el gameloop.
	 * @param cantidadDeCiclos cantidad de ciclos que debe correr el gameloop.
	 */
	public void comenzarJuego(int cantidadDeCiclos){
		int contador = 0;
		estaEnEjecucion = true;
		try{
			while(contador < cantidadDeCiclos && estaEnEjecucion){
				Nivel.getInstancia().correrLogica();
				dibujar();
				Thread.sleep(intervaloSimulacion);
				contador++;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Detiene el juego provocando la salida del gameloop.
	 */
	public void detenerJuego(){
		this.estaEnEjecucion = false;
		if(reproductor!=null)
			this.reproductor.apagar();
	}
	
	public void agregarDibujable(Dibujable unDibujable){
		aAgregar.add(unDibujable);
	}
	
	public void removerDibujable(Dibujable unDibujable){
		aEliminar.push(unDibujable);
	}
	
	/**
	 * Utiliza una cola de objetos pendientes para agregarlos a la 
	 * lista para dibujar.
	 */
	private void agregarPendientes() {
		while(!aAgregar.isEmpty()){
			dibujables.add(aAgregar.remove(0));
		}
	}
	
	/**
	 * Utiliza una cola de objetos pendientes para eliminarlos de la 
	 * lista para dibujar.
	 */
	private void eliminarPendientes(){
		while(!aEliminar.empty()){
			dibujables.remove(aEliminar.pop());
		}
	}
	
	public long getIntervaloSimulacion() {
		return intervaloSimulacion;
	}

	public void setIntervaloSimulacion(long intervaloSimulacion) {
		this.intervaloSimulacion = intervaloSimulacion;
	}
	
	/**
	 * Crea una nueva lista de dibujables.
	 */
	public void reiniciar(){
		this.dibujables = new ArrayList<Dibujable>();
	}
	
	/**
	 * Desactiva los escuchadores de mouse y keypress.
	 */
	public void desactivarEscuchadores(){
		escuchadoresActivos = false;
	}

	/**
	 * Activa los escuchadores de mouse y keypress.
	 */
	public void activarEscuchadores(){
		escuchadoresActivos = true;
	}	
 
	private void dibujar() {
		this.superficieDeDibujo.limpiar();
		
		Collections.sort(dibujables);
		Iterator<Dibujable> iterador = dibujables.iterator();
		while(iterador.hasNext()){
			Dibujable dibujable = iterador.next();
			dibujable.dibujar(this.superficieDeDibujo);
		}		
		this.superficieDeDibujo.actualizar();
	}
	
	public SuperficieDeDibujo getSuperficieDeDibujo() {
		return superficieDeDibujo;
	}

	public void setSuperficieDeDibujo(SuperficieDeDibujo superficieDeDibujo) {
		this.superficieDeDibujo = superficieDeDibujo;
	}
	
	/**
	 * Se encarga de derivar el manejo del evento keyPress al objeto vista correspondiente
	 * @param KeyEvent evento
	 */
	public void despacharKeyPress(KeyEvent event){
		if(!escuchadoresActivos) return;
		for (KeyPressedObservador observador : this.keyPressedObservadores){
			observador.keyPressed(event);
		}
		this. agregarKeyPressObservadorPendientes();
		this.eliminarKeyPressObservadorPendientes();
	}
	
	/**
	 * Se encarga de derivar el manejo del evento click al objeto vista correspondiente
	 * @param x posicion horizontal del mouse
	 * @param y posicion vertical del mouse
	 */
	public void despacharMouseClick(int x, int y){
		if(!escuchadoresActivos) return;
		MouseClickObservador mouseClickObservador;
		Iterator<MouseClickObservador> iterador = this.mouseClickObservadores.iterator();
		while(iterador.hasNext()){
			mouseClickObservador = iterador.next();
			mouseClickObservador.MouseClick(x, y);
		}
	}
	
	public void agregarMouseClickObservador(MouseClickObservador unMouseClickObservador){
		this.mouseClickObservadores.add(unMouseClickObservador);
	}
	
	public void removerMouseClickObservador(MouseClickObservador unMouseClickObservador){
		this.mouseClickObservadores.remove(unMouseClickObservador);
	}
	
	private void eliminarKeyPressObservadorPendientes() {
		while(!this.keyPressedObservadores_aux2.isEmpty()){
			this.keyPressedObservadores.remove(this.keyPressedObservadores_aux2.remove(0));
		}
	}

	private void agregarKeyPressObservadorPendientes() {
		while(!this.keyPressedObservadores_aux.isEmpty()){
			this.keyPressedObservadores.add(this.keyPressedObservadores_aux.remove(0));
		}
	}

	public void agregarKeyPressObservador(KeyPressedObservador unKeyPressedObservador){
		this.keyPressedObservadores_aux.add(unKeyPressedObservador);
	}
	
	public void removerKeyPressObservador(KeyPressedObservador unKeyPressedObservador){
		this.keyPressedObservadores_aux2.add(unKeyPressedObservador);
	}
	
	public void run() {
		this.comenzarJuego();
	}

	public Reproductor getReproductorDeAudio() {
		if(!this.estaReproductorActivo)
			throw new OperacionNoValida();
		return this.reproductor;
	}	
}

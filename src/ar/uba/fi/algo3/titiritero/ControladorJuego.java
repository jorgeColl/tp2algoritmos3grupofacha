package ar.uba.fi.algo3.titiritero;

import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import ar.uba.fi.algo3.Nivel;
import ar.uba.fi.algo3.titiritero.audio.Reproductor;
import java.util.PriorityQueue;

/**
 * @author Nicolas
 * Esta clase es la encargada de manejar todo el gameloop. B�sicamente tiene una lista
 * de ObjetosVivos y una Dibujables que son recorridas en cada gameloop.
 */
public class ControladorJuego implements Runnable {
	
	private static ControladorJuego instancia;
	private long intervaloSimulacion;
	private boolean estaEnEjecucion;
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
		this.dibujables = new ArrayList<Dibujable>();
		this.mouseClickObservadores = new ArrayList<MouseClickObservador>();
		this.keyPressedObservadores = new ArrayList<KeyPressedObservador>();
		this.keyPressedObservadores_aux = new ArrayList<KeyPressedObservador>();
		this.keyPressedObservadores_aux2 = new ArrayList<KeyPressedObservador>();
		this.aEliminar = new Stack<Dibujable>();
		this.aAgregar = new ArrayList<Dibujable>();
//		this.estaReproductorActivo = activarReproductor;
		if(this.estaReproductorActivo)
			this.reproductor = new Reproductor();		
	}
	
	public static ControladorJuego getInstancia() {
		if (instancia == null)
			instancia = new ControladorJuego();
		return instancia;
	} 
	
	public boolean estaEnEjecucion(){
		return this.estaEnEjecucion;
	}
	
	public void comenzarJuego(){
		estaEnEjecucion = true;
		try{
			while(estaEnEjecucion){
				Nivel.getInstancia().correrLogica();
				dibujar();
				this.eliminarPendientes();
				this.agregarPendientes();
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
	 * @param cantidadDeCiclos cantidad de ciclos que debe correr el gameloop..  
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
	
	private void eliminarPendientes(){
		while(!aEliminar.empty()){
			dibujables.remove(aEliminar.pop());
		}
	}
	
	private void agregarPendientes() {
		while(!aAgregar.isEmpty()){
			dibujables.add(aAgregar.remove(0));
		}
	}
	
	public long getIntervaloSimulacion() {
		return intervaloSimulacion;
	}

	public void setIntervaloSimulacion(long intervaloSimulacion) {
		this.intervaloSimulacion = intervaloSimulacion;
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
	 * Se encarga de derivar el manejo del evento click al objeto vista correspondiente
	 * @param x posici�n horizontal del mouse
	 * @param y posici�n vertial del mouse
	 */
	public void despacharMouseClick(int x, int y){
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
	
	/**
	 * Se encarga de derivar el manejo del evento keyPress al objeto vista correspondiente
	 * @param KeyEvent evento
	 */
	public void despacharKeyPress(KeyEvent event){
		for (KeyPressedObservador observador : this.keyPressedObservadores){
			observador.keyPressed(event);
		}
		this. agregarKeyPressObservadorPendientes();
		this.eliminarKeyPressObservadorPendientes();
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

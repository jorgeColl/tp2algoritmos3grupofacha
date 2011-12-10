package ar.uba.fi.algo3.titiritero.vista;

import java.awt.Color;
import java.awt.event.KeyEvent;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.MouseClickObservador;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public abstract class Figura implements Dibujable, MouseClickObservador, KeyPressedObservador {

	private Color color;
	protected Posicionable posicionable;
	protected int prioridad;
	public Figura(){
		this.prioridad=0;
	}
	public abstract void dibujar(SuperficieDeDibujo superfice) ;

	public void setColor(Color unColor){
		this.color =unColor; 
	}
	
	public Color getColor(){
		return this.color;
	}
	
	public Posicionable getPosicionable() {
		return this.posicionable;
	}

	public void setPosicionable(Posicionable posicionable) {
		this.posicionable = posicionable;		
	}

	public void MouseClick(int x, int y){
		System.out.println("Click;" + x + "," + y);
	}
	
	public void keyPressed(KeyEvent keyEvent){
		char c = keyEvent.getKeyChar();
		if(c != KeyEvent.CHAR_UNDEFINED){
			System.out.println("tecla apretada:" + c);
		}
	}
	public int getPrioridad(){
		return this.prioridad;
	}
	
	public void setPrioridad(int prioridad){
		this.prioridad = prioridad;
	}
	
	public int compareTo(Dibujable o) {
		if (this.prioridad >= o.getPrioridad()){
			return 1;
		}
		if (this.prioridad == o.getPrioridad()){
			return 1;
		}
		return -1;
	}
		
}

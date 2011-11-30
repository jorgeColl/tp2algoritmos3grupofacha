package ar.uba.fi.algo3.titiritero.vista;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;
import ar.uba.fi.algo3.titiritero.MouseClickObservador;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

/*
 * Esta clase representa una imagen JPG abstrayendo al usuario de los detalles de Java2D
 * Simplemente requiere de una referencia al nombre del archivo JPG
 */
public abstract class Imagen implements Dibujable, MouseClickObservador, KeyPressedObservador {
	
	public Imagen(){
		super();
	}

	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
		grafico.drawImage(imagen, posicionable.getX(), posicionable.getY(), null);
	}
	    
	public Posicionable getPosicionable() {
		return posicionable;
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
	
    protected BufferedImage imagen;
    protected Posicionable posicionable;

}

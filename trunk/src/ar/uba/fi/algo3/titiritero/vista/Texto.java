package ar.uba.fi.algo3.titiritero.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

/**
 * Sirve para abstraer al usuario de escribir Texto en la pantalla.
 * @see Font
 * @author mwaisgold@gmail.com
 *
 */
public abstract class Texto extends Figura {

	
	private Font fuente;
	protected int tamanio;
	
	
	public Texto(){
		this.tamanio=14;
		setColor(Color.WHITE);
		setFuente("Serif",tamanio);
	}
	
	public Texto(Color color, Font fuente){
		setColor(color);
		this.fuente = fuente;
	}
	
	public void setFuente(String fuente, int tamanio){
		this.fuente = new Font(fuente,Font.BOLD,tamanio);
		this.tamanio = tamanio;
	}
	
	protected int getTamanioFuente(){
		return this.tamanio;
	}
	
	protected void setTamanioFuente(int nuevoTamanio){
		this.tamanio = nuevoTamanio;
		this.setFuente("Serif", this.tamanio);
	}
	
	/* cambie el codigo original para que ahora acepte saltos de linea*/
	public void dibujar(SuperficieDeDibujo superfice) {
		Graphics grafico = (Graphics)superfice.getBuffer();
		grafico.setColor(this.getColor());
		grafico.setFont(fuente);
		String[] textos = getTexto().split("\n");
		int y = 0;
		for(int i=0 ; i< textos.length ;i++){
			grafico.drawString(textos[i], this.getPosicionable().getX(), this.getPosicionable().getY() + y);
			y += this.tamanio;
		}
	}

	protected abstract String getTexto();

}

package ar.uba.fi.algo3.titiritero;

/*
 * Esta abstraccion representa a todos los objetos Vista de la aplicacion
 * Cada objeto vista esta relacionado con un objeto del modelo que implementa
 * la interface Posicionable
 */
public interface Dibujable extends Comparable<Dibujable> {

	public void dibujar(SuperficieDeDibujo superfice);
	public Posicionable getPosicionable();
	public void setPosicionable(Posicionable posicionable);
	public int getPrioridad();
	
}   

/**
 * 
 */
package ar.uba.fi.algo3.vista;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;


import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.TextoEstatico;

/**
 * @author jc
 * clase que se va a encargar de fijarse si algunos de los elementos que determinan si
 * el juego termino y va a graficar segun sus estados
 */
public class VistaDeFinDeJuego extends TextoEstatico {
	ArrayList<Posicionable> elementosARevisar = null;
	static VistaDeFinDeJuego instancia = null;
	
	private VistaDeFinDeJuego(){
		super("JUEGO\nPERDIDO :(");
		super.setColor(Color.red);
		super.setFuente("Serif",40);
		super.setPosicionable(new PuntoParaTexto(new Posicion(100,100)));
		this.elementosARevisar = new ArrayList<Posicionable>();
	}
	
	public static VistaDeFinDeJuego getInstancia(){
		if(instancia==null){
			instancia=new VistaDeFinDeJuego();
			return instancia;
		}else{
			return instancia;
		}
	}
	
	public void agregarElementoQueProvocaPerderElJuego(Posicionable objeto){
		elementosARevisar.add(objeto);
	}
	
	public void dibujar(SuperficieDeDibujo superficieDeDibujo){
		
		Iterator<Posicionable> iterador = this.elementosARevisar.iterator();
		while (iterador.hasNext()){
			Posicionable elemento = iterador.next();
			if (elemento.isVivo()==false){
				super.dibujar(superficieDeDibujo);
			}
		}
		
	}
}

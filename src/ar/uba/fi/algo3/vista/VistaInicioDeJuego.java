/**
 * 
 */
package ar.uba.fi.algo3.vista;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.File;

import ar.uba.fi.algo3.Nivel;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.ImagenDinamica;
import ar.uba.fi.algo3.titiritero.vista.TextoEstatico;

/**
 * @author jc
 * Vista que modela la pantalla que se muestra al iniciar un juego.
 */
public class VistaInicioDeJuego extends ImagenDinamica {
	
	final static int NUEVA_PARTIDA = 0;
	final static int CARGAR_PARTIDA = 1;
	int seleccion;
	
	public VistaInicioDeJuego(){
		super();
		this.agregarImagen(NUEVA_PARTIDA, "img/inicio_nuevap.jpg");
		this.agregarImagen(CARGAR_PARTIDA, "img/inicio_cargarp.jpg");
		this.cambiarAImagen(NUEVA_PARTIDA);
		seleccion = NUEVA_PARTIDA;
	}
	
	public void dibujar(SuperficieDeDibujo superficeDeDibujo){
		Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
		grafico.drawImage(imagen, 0, 0, null);
	}
	
	@Override
	public void keyPressed(KeyEvent keyEvent){
		int c = keyEvent.getKeyCode();
		Nivel nivel = Nivel.getInstancia();
		switch (c){	
			case KeyEvent.VK_UP:
				this.cambiarAImagen(NUEVA_PARTIDA);
				seleccion = NUEVA_PARTIDA;
				break;
			case KeyEvent.VK_DOWN:
				this.cambiarAImagen(CARGAR_PARTIDA);
				seleccion = CARGAR_PARTIDA;
				break;
			case KeyEvent.VK_SPACE:
				if(seleccion == CARGAR_PARTIDA){		
					Nivel.getInstancia().cargarNivelGuardado();
				} else {
					nivel.cargarNivel();
				}
				this.eliminarVista();
				break;
		}
	
	}
	/**
	 * metodo que se encarga de eliminar la vista y el key obsevator, al mismo tiempo que crea
	 * otro
	 */
	private void eliminarVista(){
		ControladorJuego.getInstancia().removerDibujable(this);
		ControladorJuego.getInstancia().removerKeyPressObservador(this);
		//crear escuchador
		Escuchador escuchador = new Escuchador();
		ControladorJuego.getInstancia().agregarKeyPressObservador(escuchador);	
	}
}

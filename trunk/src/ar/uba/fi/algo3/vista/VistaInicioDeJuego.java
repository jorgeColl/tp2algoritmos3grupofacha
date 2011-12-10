package ar.uba.fi.algo3.vista;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import ar.uba.fi.algo3.Nivel;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.ImagenDinamica;

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
		this.prioridad=11;
		this.agregarImagen(NUEVA_PARTIDA, "img/inicio_nuevap.jpg");
		this.agregarImagen(CARGAR_PARTIDA, "img/inicio_cargarp.jpg");
		this.cambiarAImagen(NUEVA_PARTIDA);
		seleccion = NUEVA_PARTIDA;
	}
	
	/**
	 * Redefinicion del metodo dibujar de la clase Imagen, que permite
	 * dibujar las imagenes a pesar de que no pertenezcan a ningun objeto
	 * vivo.
	 */
	public void dibujar(SuperficieDeDibujo superficeDeDibujo){
		Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
		grafico.drawImage(imagen, 0, 0, null);
	}
	
	/**
	 * Metodo que escucha si el usuario presiona las teclas para seleccionar
	 * la accion al inicio del juego.
	 */
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
					nivel.cargarNivelGuardado();
				} else {
					nivel.cargarProximoNivel();
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
		EscuchadorEstatico escuchador = new EscuchadorEstatico();
		ControladorJuego.getInstancia().agregarKeyPressObservador(escuchador);	
	}
}

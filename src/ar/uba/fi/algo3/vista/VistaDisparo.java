package ar.uba.fi.algo3.vista;

import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.ImagenEstatica;

public class VistaDisparo extends ImagenEstatica{
	
	public VistaDisparo(){
		super();
		this.setNombreArchivoImagen("img/Disparo.JPG");
	}
	public void dibujar(SuperficieDeDibujo superficeDeDibujo){
		if( ((ObjetoJuego)this.posicionable).isVivo() == false){
			//ACA EXPLOTA TODO :( 
			//ControladorJuego.getInstancia().removerDibujable(this);
		}else{
			super.dibujar(superficeDeDibujo);
		}
	}

}

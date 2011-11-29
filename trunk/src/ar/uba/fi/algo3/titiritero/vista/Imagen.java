package ar.uba.fi.algo3.titiritero.vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
//import java.net.URL;

import javax.imageio.ImageIO;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

/*
 * Esta clase representa una imagen JPG abstrayendo al usuario de los detalles de Java2D
 * Simplemente requiere de una referencia al nombre del archivo JPG
 */
public class Imagen implements Dibujable{
	
	public Imagen(){
		
	}

	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
		grafico.drawImage(this.imagen, this.posicionable.getX(), this.posicionable.getY(), null);
	}
	    
	public String getNombreArchivoImagen() {
		return nombreArchivoImagen;
	}

	/**
	 * Estable la imagen con la que se dibujará el objeto.
	 * @param nombreArchivoImagen es el nombre del archivo que contiene l a imagen. Se espera que dicho archivo sea .jpg y esté ubicado en....
	 */
	public void setNombreArchivoImagen(String nombreArchivoImagen) {
		this.nombreArchivoImagen = nombreArchivoImagen;
		try{
			//URL u = this.getClass().getResource(this.nombreArchivoImagen);
			File u = new File(this.nombreArchivoImagen);
			this.imagen = ImageIO.read(u);
		} catch(Exception ex) {}
	
		if (this.imagen == null) System.out.println("ERROR: imagen es null.");
	}
	
	public Posicionable getPosicionable() {
		return posicionable;
	}

	public void setPosicionable(Posicionable posicionable) {
		this.posicionable = posicionable;
		
	}
	
	private String nombreArchivoImagen;
    private BufferedImage imagen;
    private Posicionable posicionable;

}

/**
 * 
 */
package ar.uba.fi.algo3.titiritero.vista;

import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @see ImagenDinamica
 * @author Fede
 *
 */
public class ImagenEstatica extends Imagen {
	
	public ImagenEstatica(){
		super();
	}
	
	public String getNombreArchivoImagen() {
		return nombreArchivoImagen;
	}
	
	/**
	 * Establece la imagen con la que se dibujará el objeto.
	 * @param nombreArchivoImagen es el nombre del archivo que contiene la imagen. 
	 * 		Se espera que dicho archivo sea .jpg y esté ubicado en....
	 */
	public void setNombreArchivoImagen(String nombreArchivoImagen) {
		this.nombreArchivoImagen = nombreArchivoImagen;
		try{
			File u = new File(this.nombreArchivoImagen);
			this.imagen = ImageIO.read(u);
		} catch(Exception ex) {}
	
		if (this.imagen == null) System.out.println("ERROR: imagen es null.");
	}
	
	private String nombreArchivoImagen;
}

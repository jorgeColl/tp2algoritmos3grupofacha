package ar.uba.fi.algo3.modelo.armamentista.arma;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ar.uba.fi.algo3.modelo.tanques.Tanque;

/**
 * Otorga comportamiento común a las clases que representan a armas con munición limitada.
 * @author Fede
 *
 */
public abstract class ArmaMunicionLimitada extends Arma {

	protected int municion;
	protected String tipo;
	
	/**
	 * 
	 * @param municion entero correspondiente a la munición inicial del arma
	 */
	public ArmaMunicionLimitada(Tanque duenio, int municion) {
		super(duenio);
		this.municion = municion;
	}
	
	/**
	 * 
	 * @return entero correspondiente a la munición del arma
	 */
	public int getMunicion() {
		return municion;
	}
	
	/**
	 * Establece una municion al arma. Usado por los metodos relacionados
	 * con la persistencia.
	 */
	public void setMunicion(int unaMunicion){
		municion = unaMunicion;
	}
	
	/**
	 * 
	 * @param incremento entero que sumaremos a la munición del arma
	 */
	public void incrementarMunicion(int incremento) {
		municion = municion + incremento;
	}

	/**
	 * Persiste el arma del AlgoTank.
	 */
	public void persistir(Document documentoXML, Element raiz){
		Attr atributoTipo = documentoXML.createAttribute("tipoArmaMunicionLimitada");
		atributoTipo.setValue(tipo);
		raiz.setAttributeNode(atributoTipo);

		Attr atributoMunicion = documentoXML.createAttribute("cantidadMunicion");
		atributoMunicion.setValue(((Integer) municion).toString());
		raiz.setAttributeNode(atributoMunicion);
	}
}

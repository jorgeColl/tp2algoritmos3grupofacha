/**
 * 
 */
package ar.uba.fi.algo3;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.objetosInanimados.CuartelArgentino;
import ar.uba.fi.algo3.modelo.objetosInanimados.ParedConcreto;
import ar.uba.fi.algo3.modelo.objetosInanimados.ParedMetal;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import ar.uba.fi.algo3.modelo.tanques.GrizzlyBattleTank;
import ar.uba.fi.algo3.modelo.tanques.IFV;
import ar.uba.fi.algo3.modelo.tanques.MirageTank;

/**
 * @author Fede
 * Clase que facilita la persistencia del juego.
 * 
 */
public class Persistidor {
	
	private static int nivelActual;
	private final static String directorioDeNiveles = "level/nivel";
	private final static String directorioDeGuardados = "save/";
	
	public Persistidor(){
		nivelActual = 0;
	}
	
	public void cargarProximoNivel(){
		nivelActual++;
		try {
			Integer nivelACargar = (Integer) nivelActual;
			File archivoXML = new File(directorioDeNiveles + nivelACargar.toString() + ".xml" );
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = dbFactory.newDocumentBuilder();
			Document documentoXML = parser.parse(archivoXML);
			documentoXML.getDocumentElement().normalize();

			this.cargarParedesDeDocumento(documentoXML);
			this.cargarAlgoTankDeDocumento(documentoXML);
			this.cargarCuartelArgentinoDeDocumento(documentoXML);
			this.cargarTanquesEnemigosDeDocumento(documentoXML);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void cargarParedesDeDocumento(Document documentoXML){
		NodeList listaDeParedes = documentoXML.getElementsByTagName("pared");
		 
		for(int i = 0; i < listaDeParedes.getLength(); i++) {
			Node pared = listaDeParedes.item(i);
			
			if(pared.getNodeType() == Node.ELEMENT_NODE) {
				Element elementoPared = (Element) pared;
				
				int posX = Integer.parseInt(elementoPared.getAttribute("posX"));
				int posY = Integer.parseInt(elementoPared.getAttribute("posY"));
				Posicion ubicacion = new Posicion(posX, posY);
				String tipo = elementoPared.getAttribute("tipo");
				
				if(tipo.equalsIgnoreCase("concreto")){
					ParedConcreto paredConcreto = new ParedConcreto(ubicacion);
				} else if (tipo.equalsIgnoreCase("metal")){
					ParedMetal paredMetal = new ParedMetal(ubicacion);
				}
			}
		}
	}
	
	private void cargarAlgoTankDeDocumento(Document documentoXML){
		NodeList listaAlgoTank = documentoXML.getElementsByTagName("algoTank");
		Node nodoAlgoTank = listaAlgoTank.item(0);
		if(nodoAlgoTank.getNodeType() == Node.ELEMENT_NODE) {
			Element elementoAlgoTank = (Element) nodoAlgoTank;
			int posX = Integer.parseInt(elementoAlgoTank.getAttribute("posX"));
			int posY = Integer.parseInt(elementoAlgoTank.getAttribute("posY"));
			Posicion ubicacion = new Posicion(posX, posY);
			AlgoTank algoTank = new AlgoTank(ubicacion);
		}
	}

	private void cargarCuartelArgentinoDeDocumento(Document documentoXML){
		NodeList listaCuartelArgentino = documentoXML.getElementsByTagName("cuartelArgentino");
		Node nodoCuartelArgentino = listaCuartelArgentino.item(0);
		if(nodoCuartelArgentino.getNodeType() == Node.ELEMENT_NODE) {
			Element elementoCuartelArgentino = (Element) nodoCuartelArgentino;
			int posX = Integer.parseInt(elementoCuartelArgentino.getAttribute("posX"));
			int posY = Integer.parseInt(elementoCuartelArgentino.getAttribute("posY"));
			Posicion ubicacion = new Posicion(posX, posY);
			CuartelArgentino cuartelArgentino = new CuartelArgentino(ubicacion);
		}
	}
	
	private void cargarTanquesEnemigosDeDocumento(Document documentoXML){
		NodeList listaDeTanquesEnemigos = documentoXML.getElementsByTagName("tanqueEnemigo");
	 
		for(int i = 0; i < listaDeTanquesEnemigos.getLength(); i++) {
			Node tanque = listaDeTanquesEnemigos.item(i);
			
			if(tanque.getNodeType() == Node.ELEMENT_NODE) {
				Element elementoTanque = (Element) tanque;
				
				int posX = Integer.parseInt(elementoTanque.getAttribute("posX"));
				int posY = Integer.parseInt(elementoTanque.getAttribute("posY"));
				Posicion ubicacion = new Posicion(posX, posY);
				String tipo = elementoTanque.getAttribute("tipo");
				
				if(tipo.equalsIgnoreCase("Grizzly")){
					GrizzlyBattleTank grizzly = new GrizzlyBattleTank(ubicacion);
				} else if (tipo.equalsIgnoreCase("IFV")){
					IFV ifv = new IFV(ubicacion);
				} else if (tipo.equalsIgnoreCase("Mirage")){
					MirageTank mirage = new MirageTank(ubicacion);
				}
			}
		}
	}
}

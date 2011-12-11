/**
 * 
 */
package ar.uba.fi.algo3.controlador;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ar.uba.fi.algo3.modelo.armamentista.arma.Canion;
import ar.uba.fi.algo3.modelo.armamentista.arma.LanzaCohetes;
import ar.uba.fi.algo3.modelo.armamentista.disparo.DisparoAmetralladora;
import ar.uba.fi.algo3.modelo.armamentista.disparo.DisparoCanion;
import ar.uba.fi.algo3.modelo.armamentista.disparo.DisparoLanzaCohetes;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.objetosInanimados.CuartelArgentino;
import ar.uba.fi.algo3.modelo.objetosInanimados.Pared;
import ar.uba.fi.algo3.modelo.objetosInanimados.ParedConcreto;
import ar.uba.fi.algo3.modelo.objetosInanimados.ParedMetal;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import ar.uba.fi.algo3.modelo.tanques.GrizzlyBattleTank;
import ar.uba.fi.algo3.modelo.tanques.IFV;
import ar.uba.fi.algo3.modelo.tanques.MirageTank;
import ar.uba.fi.algo3.modelo.tanques.TanqueEnemigo;

/**
 * @author Fede
 * Clase que hace posible la persistencia del juego.
 * 
 */
public class Persistidor {
	
	private static int nivelActual;
	private final static String DIRECTORIO_DE_NIVELES = "level/nivel";
	private final static String ARCHIVO_DE_GUARDADO = "save/saved.xml";
	
	public Persistidor(){
		nivelActual = 0;
	}
	
	/**
	 * Carga el juego que se encuentre guardado en el directorio recibido.
	 * @param directorio
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	private void cargarNivelDesdeArchivo(String directorio) 
		throws SAXException, IOException, ParserConfigurationException {
			File archivoXML = new File(directorio);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = dbFactory.newDocumentBuilder();
			Document documentoXML = parser.parse(archivoXML);
			documentoXML.getDocumentElement().normalize();
			
			NodeList listaConUnElemento = documentoXML.getElementsByTagName("nivel");
			Element elementoNumeroNivel = (Element) listaConUnElemento.item(0);
			int numeroNivel = Integer.parseInt(elementoNumeroNivel.getAttribute("numero"));
			nivelActual = numeroNivel;
			
			this.cargarParedesDeDocumento(documentoXML);
			this.cargarAlgoTankDeDocumento(documentoXML);
			this.cargarCuartelArgentinoDeDocumento(documentoXML);
			this.cargarTanquesEnemigosDeDocumento(documentoXML);
			this.cargarDisparosDeDocumento(documentoXML);
	}
	
	/**
	 * Delega al Espacio la tarea de persistir a los objetos del juego, y los guarda
	 * en el directorio especificado en ARCHIVO_DE_GUARDADO.
	 */
	public void guardarNivel(){
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
			Document documentoXML = docBuilder.newDocument();
			
			Element raiz = documentoXML.createElement("nivel");
			Attr atributoNivel = documentoXML.createAttribute("numero");
			atributoNivel.setValue(((Integer) nivelActual).toString());
			raiz.setAttributeNode(atributoNivel);
			
			Espacio.getInstancia().persistir(documentoXML, raiz);
			documentoXML.appendChild(raiz);
			
			TransformerFactory transFac = TransformerFactory.newInstance();
			Transformer trans = transFac.newTransformer();
			DOMSource fuente = new DOMSource(documentoXML);
			StreamResult resultado = new StreamResult(new File(ARCHIVO_DE_GUARDADO));
			
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
			trans.transform(fuente, resultado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	/**
	 * Carga el juego guardado en ARCHIVO_DE_GUARDADO, si existe.
	 */
	public void cargarJuegoGuardado(){
		try {
			this.cargarNivelDesdeArchivo(ARCHIVO_DE_GUARDADO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Aumenta el contador del nivel para cargar el nuevo, leyendo el archivo
	 * XML correspondiente.
	 */
	public void cargarProximoNivel(){
		nivelActual++;
		Integer nivelACargar = (Integer) nivelActual;
		String directorio = DIRECTORIO_DE_NIVELES + nivelACargar.toString() + ".xml" ;
		try {
			this.cargarNivelDesdeArchivo(directorio);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	/**
	 * Lee las paredes del documento XML cargado, creando los objetos correspondientes
	 * con los atributos especificados.
	 * @param documentoXML
	 */
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
				
				Pared paredNueva;
				if(tipo.equalsIgnoreCase("concreto"))
					paredNueva = (ParedConcreto) new ParedConcreto(ubicacion);
				else
					paredNueva = (ParedMetal) new ParedMetal(ubicacion);
								
				if(elementoPared.hasAttribute("impactosRecibidos")){
					int impactosRecibidos = 
							Integer.parseInt(elementoPared.getAttribute("impactosRecibidos"));
					paredNueva.setImpactosRecibidos(impactosRecibidos);
				}
				
			}
		}
	}
	
	/**
	 * Lee el algoTank del documento XML cargado, creándolo con los atributos especificados.
	 * @param documentoXML
	 */
	private void cargarAlgoTankDeDocumento(Document documentoXML){
		NodeList listaAlgoTank = documentoXML.getElementsByTagName("algoTank");
		Node nodoAlgoTank = listaAlgoTank.item(0);
		
		if(nodoAlgoTank.getNodeType() == Node.ELEMENT_NODE) {
			Element elementoAlgoTank = (Element) nodoAlgoTank;
			
			int posX = Integer.parseInt(elementoAlgoTank.getAttribute("posX"));
			int posY = Integer.parseInt(elementoAlgoTank.getAttribute("posY"));
			
			Posicion ubicacion = new Posicion(posX, posY);
			AlgoTank algoTank = new AlgoTank(ubicacion);
			
			if(elementoAlgoTank.hasAttribute("resistencia")){
				int resistencia = 
						Integer.parseInt(elementoAlgoTank.getAttribute("resistencia"));
				algoTank.setResistencia(resistencia);
			}

			if(elementoAlgoTank.hasAttribute("puntaje")){
				int puntaje = 
						Integer.parseInt(elementoAlgoTank.getAttribute("puntaje"));
				algoTank.setPuntaje(puntaje);
			}
			
			if(elementoAlgoTank.hasAttribute("tipoArmaMunicionLimitada")){
				String tipo = elementoAlgoTank.getAttribute("tipoArmaMunicionLimitada");
				int cantidadMunicion = 
						Integer.parseInt(elementoAlgoTank.getAttribute("cantidadMunicion"));
				
				if(tipo.equalsIgnoreCase("canion"))
					algoTank.entregarArma(new Canion(algoTank, cantidadMunicion));
				else if(tipo.equalsIgnoreCase("lanzaCohetes"))
					algoTank.entregarArma(new LanzaCohetes(algoTank, cantidadMunicion));
			}
			
		}
	}

	/**
	 * Lee la informacion correspondiente al CuartelArgentino del documento XML cargado y
	 * pasado por parametro, creando el objeto con los atributos especificados.
	 * @param documentoXML
	 */
	private void cargarCuartelArgentinoDeDocumento(Document documentoXML){
		NodeList listaCuartelArgentino = 
				documentoXML.getElementsByTagName("cuartelArgentino");
		Node nodoCuartelArgentino = listaCuartelArgentino.item(0);
		
		if(nodoCuartelArgentino.getNodeType() == Node.ELEMENT_NODE) {
			Element elementoCuartelArgentino = (Element) nodoCuartelArgentino;
			
			int posX = Integer.parseInt(elementoCuartelArgentino.getAttribute("posX"));
			int posY = Integer.parseInt(elementoCuartelArgentino.getAttribute("posY"));
			
			Posicion ubicacion = new Posicion(posX, posY);
			new CuartelArgentino(ubicacion);
		}
	}
	
	/**
	 * Lee el archivo XML pasado por parametro para cargar los TanquesEnemigos, creandolos
	 * con los atributos especificados.
	 * @param documentoXML
	 */
	private void cargarTanquesEnemigosDeDocumento(Document documentoXML){
		NodeList listaDeTanquesEnemigos = 
				documentoXML.getElementsByTagName("tanqueEnemigo");
	 
		for(int i = 0; i < listaDeTanquesEnemigos.getLength(); i++) {
			Node tanque = listaDeTanquesEnemigos.item(i);
			
			if(tanque.getNodeType() == Node.ELEMENT_NODE) {
				Element elementoTanque = (Element) tanque;
				
				int posX = Integer.parseInt(elementoTanque.getAttribute("posX"));
				int posY = Integer.parseInt(elementoTanque.getAttribute("posY"));
				Posicion ubicacion = new Posicion(posX, posY);
				String tipo = elementoTanque.getAttribute("tipo");
				
				TanqueEnemigo tanqueNuevo;
				if(tipo.equalsIgnoreCase("Grizzly"))
					tanqueNuevo = (GrizzlyBattleTank) new GrizzlyBattleTank(ubicacion);
				else if(tipo.equalsIgnoreCase("IFV"))
					tanqueNuevo = (IFV) new IFV(ubicacion);
				else
					tanqueNuevo = (MirageTank) new MirageTank(ubicacion);
								
				if(elementoTanque.hasAttribute("resistencia")){
					int resistencia = 
							Integer.parseInt(elementoTanque.getAttribute("resistencia"));
					tanqueNuevo.setResistencia(resistencia);
				}
			}
		}
	}
	
	/**
	 * Lee el archivo XML pasado por parametro para cargar los TanquesEnemigos, creandolos
	 * con los atributos especificados.
	 * @param documentoXML
	 */
	private void cargarDisparosDeDocumento(Document documentoXML){
		NodeList listaDeDisparos = documentoXML.getElementsByTagName("disparo");
	 
		for(int i = 0; i < listaDeDisparos.getLength(); i++) {
			Node disparo = listaDeDisparos.item(i);
			
			if(disparo.getNodeType() == Node.ELEMENT_NODE) {
				Element elementoDisparo = (Element) disparo;
				
				int posX = Integer.parseInt(elementoDisparo.getAttribute("posX"));
				int posY = Integer.parseInt(elementoDisparo.getAttribute("posY"));
				int orientacionX = Integer.parseInt(elementoDisparo.getAttribute("orientacionX"));
				int orientacionY = Integer.parseInt(elementoDisparo.getAttribute("orientacionY"));
				
				Orientacion sentido;
				if(orientacionX == 0 && orientacionY == 1) sentido = Orientacion.j;
				else if(orientacionX == 0 && orientacionY == -1) sentido = Orientacion.jNegativo;
				else if(orientacionX == 1 && orientacionY == 0) sentido = Orientacion.i;
				else sentido = Orientacion.iNegativo;
				Posicion ubicacion = new Posicion(posX, posY);
				
				String tipo = elementoDisparo.getAttribute("tipo");
				
				if(tipo.equalsIgnoreCase("canion"))
					new DisparoCanion(sentido, ubicacion);
				else if(tipo.equalsIgnoreCase("lanzaCohetes"))
					new DisparoLanzaCohetes(sentido, ubicacion);
				else
					new DisparoAmetralladora(sentido, ubicacion);
			}
		}
	}
}

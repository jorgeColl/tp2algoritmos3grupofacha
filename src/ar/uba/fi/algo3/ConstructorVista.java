/**
 * 
 */
package ar.uba.fi.algo3;

import java.awt.Color;

import ar.uba.fi.algo3.modelo.armamentista.disparo.DisparoAmetralladora;
import ar.uba.fi.algo3.modelo.armamentista.disparo.DisparoCanion;
import ar.uba.fi.algo3.modelo.armamentista.disparo.DisparoLanzaCohetes;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.objetosInanimados.BonusVelocidad;
import ar.uba.fi.algo3.modelo.objetosInanimados.BonusVida;
import ar.uba.fi.algo3.modelo.objetosInanimados.CuartelArgentino;
import ar.uba.fi.algo3.modelo.objetosInanimados.ParedConcreto;
import ar.uba.fi.algo3.modelo.objetosInanimados.ParedMetal;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import ar.uba.fi.algo3.modelo.tanques.GrizzlyBattleTank;
import ar.uba.fi.algo3.modelo.tanques.IFV;
import ar.uba.fi.algo3.modelo.tanques.MirageTank;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.vista.TextoDinamico;
import ar.uba.fi.algo3.vista.PuntoParaTexto;
import ar.uba.fi.algo3.vista.VistaAlgoTank;
import ar.uba.fi.algo3.vista.VistaBonus;
import ar.uba.fi.algo3.vista.VistaDeTextoDeAlgoTank;
import ar.uba.fi.algo3.vista.VistaDisparoAmetralladora;
import ar.uba.fi.algo3.vista.VistaParaImagen;
import ar.uba.fi.algo3.vista.VistaImagenConOrientacion;
import ar.uba.fi.algo3.vista.VistaDeFinalizacionDeJuego;


/**
 * @author jc
 * esta clase va a ayudar a crear a las vistas de los elementos que esten en el juego y 
 * quieran ser visualizados
 */
public class ConstructorVista {
	
	//solo evita dos lineas de repeticion de codigo
	private static void auxiliar (Dibujable vista, Posicionable objeto){
		vista.setPosicionable(objeto);
		ControladorJuego.getInstancia().agregarDibujable(vista);
	}
	
	public static void construirVista(DisparoAmetralladora disparo){
		VistaDisparoAmetralladora vista = new VistaDisparoAmetralladora();
		auxiliar(vista,disparo);
		System.out.println("01");
	}
	
	public static void construirVista(DisparoCanion disparo){
		VistaImagenConOrientacion vista = 
				new VistaImagenConOrientacion("img/DisparoCanion_i.JPG",
						"img/DisparoCanion_iNegativo.JPG",
						"img/DisparoCanion_j.JPG",
						"img/DisparoCanion_jNegativo.JPG");
		auxiliar(vista,disparo);
		System.out.println("02");
	}
	
	public static void construirVista(DisparoLanzaCohetes disparo){
		VistaImagenConOrientacion vista = 
				new  VistaImagenConOrientacion("img/DisparoLanzaCohetes_i.JPG",
						"img/DisparoLanzaCohetes_iNegativo.JPG",
						"img/DisparoLanzaCohetes_j.JPG",
						"img/DisparoLanzaCohetes_jNegativo.JPG");
		auxiliar(vista,disparo);
		System.out.println("03");
	}
	
	public static void construirVista(ParedConcreto pared){
		VistaParaImagen vista = new VistaParaImagen("img/ParedConcreto.JPG");
		auxiliar(vista,pared);
		System.out.println("04");
	}
	
	public static void construirVista(ParedMetal pared){
		VistaParaImagen vista = new VistaParaImagen("img/ParedMetal.JPG");
		auxiliar(vista,pared);
		System.out.println("05");
	}
	
	public static void construirVista(CuartelArgentino cuartel){
		VistaParaImagen vista = new VistaParaImagen("img/cuartelArgentino.GIF");
		auxiliar(vista,cuartel);
		System.out.println("05");
		
	}
	
	public static void construirVista(AlgoTank tanque){
		VistaAlgoTank vista = new VistaAlgoTank();
		auxiliar(vista,tanque);
		
		ControladorJuego.getInstancia().agregarKeyPressObservador(vista);
		
		//creo la segunda vista
		VistaDeTextoDeAlgoTank observador = new VistaDeTextoDeAlgoTank(tanque);
		TextoDinamico vista2 = new TextoDinamico(observador);
		PuntoParaTexto pptexto2 = new PuntoParaTexto(new Posicion(602,10));
		vista2.setColor(Color.black);
		auxiliar(vista2,pptexto2);
		System.out.println("06");
	}
	
	public static void construirVista(BonusVelocidad bonus){
		VistaBonus vista = new VistaBonus("img/Bonus.JPG");
		auxiliar(vista,bonus);
		System.out.println("07");
	}
	
	public static void construirVista(BonusVida bonus){
		VistaBonus vista = new VistaBonus("img/BonusVida.JPG");
		auxiliar(vista,bonus);
		System.out.println("08");
	}
	
	public static void construirVista(GrizzlyBattleTank tanque){
		VistaImagenConOrientacion vista = 
				new VistaImagenConOrientacion("img/GrizzlyBattleTank_i.JPG",
						"img/GrizzlyBattleTank_iNegativo.JPG",
						"img/GrizzlyBattleTank_j.JPG", 
						"img/GrizzlyBattleTank_jNegativo.JPG");
		auxiliar(vista,tanque);
		System.out.println("09");
	}
	
	public static void construirVista(IFV tanque){
		VistaImagenConOrientacion vista = 
				new VistaImagenConOrientacion("img/IFV_i.JPG",
						"img/IFV_iNegativo.JPG",
						"img/IFV_j.JPG", 
						"img/IFV_jNegativo.JPG");
		auxiliar(vista,tanque);
		System.out.println("10");
	}
	
	public static void construirVista(MirageTank tanque){
		VistaImagenConOrientacion vista = 
				new VistaImagenConOrientacion("img/MirageTank_i.JPG",
						"img/MirageTank_iNegativo.JPG",
						"img/MirageTank_j.JPG", 
						"img/MirageTank_jNegativo.JPG");
		auxiliar(vista,tanque);
		System.out.println("11");
	}
	
	public static void construirVista(Espacio espacio){
		
		VistaDeFinalizacionDeJuego observante = new VistaDeFinalizacionDeJuego(espacio);
		TextoDinamico vista2 = new TextoDinamico(observante);
		PuntoParaTexto pptexto2 = new PuntoParaTexto(new Posicion(602,100));
		vista2.setColor(Color.red);
		auxiliar(vista2,pptexto2);
		System.out.println("12");		
	}
		
}

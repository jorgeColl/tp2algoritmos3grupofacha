/**
 * 
 */
package ar.uba.fi.algo3;

import java.awt.Color;


import ar.uba.fi.algo3.modelo.armamentista.disparo.DisparoAmetralladora;
import ar.uba.fi.algo3.modelo.armamentista.disparo.DisparoCanion;
import ar.uba.fi.algo3.modelo.armamentista.disparo.DisparoLanzaCohetes;
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
import ar.uba.fi.algo3.vista.VistaDeTextoDeAlgoTank;
import ar.uba.fi.algo3.vista.VistaParaImagen;
import ar.uba.fi.algo3.vista.VistaImagenConOrientacion;
import ar.uba.fi.algo3.vista.VistaDeFinalizacionDeJuego;
import ar.uba.fi.algo3.vista.VistaInicioDeJuego;


/**
 * @author jc
 * esta clase va a ayudar a crear a las vistas de los elementos que esten en el juego y 
 * deban ser visualizados
 */
public class ConstructorVista {
	
	//solo evita dos lineas de repeticion de codigo
	private static void auxiliar (Dibujable vista, Posicionable objeto){
		vista.setPosicionable(objeto);
		ControladorJuego.getInstancia().agregarDibujable(vista);
	}
	
	public static void construirVista(DisparoAmetralladora disparo){
		VistaParaImagen vista = new VistaParaImagen("img/Disparo.JPG");
		auxiliar(vista,disparo);
	}
	
	public static void construirVista(DisparoCanion disparo){
		VistaImagenConOrientacion vista = 
				new VistaImagenConOrientacion("img/DisparoCanion_i.JPG",
						"img/DisparoCanion_iNegativo.JPG",
						"img/DisparoCanion_j.JPG",
						"img/DisparoCanion_jNegativo.JPG");
		auxiliar(vista,disparo);
	}
	
	public static void construirVista(DisparoLanzaCohetes disparo){
		VistaImagenConOrientacion vista = 
				new  VistaImagenConOrientacion("img/DisparoLanzaCohetes_i.JPG",
						"img/DisparoLanzaCohetes_iNegativo.JPG",
						"img/DisparoLanzaCohetes_j.JPG",
						"img/DisparoLanzaCohetes_jNegativo.JPG");
		auxiliar(vista,disparo);
	}
	
	public static void construirVista(ParedConcreto pared){
		VistaParaImagen vista = new VistaParaImagen("img/ParedConcreto.JPG");
		auxiliar(vista,pared);
	}
	
	public static void construirVista(ParedMetal pared){
		VistaParaImagen vista = new VistaParaImagen("img/ParedMetal.JPG");
		auxiliar(vista,pared);
	}
	
	public static void construirVista(CuartelArgentino cuartel){
		VistaParaImagen vista = new VistaParaImagen("img/cuartelArgentino.GIF");
		auxiliar(vista,cuartel);		
	}
	
	public static void construirVista(AlgoTank tanque){
		VistaAlgoTank vista = new VistaAlgoTank("img/AlgoTank_i.JPG",
				"img/AlgoTank_iNegativo.JPG",
				"img/AlgoTank_j.JPG",
				"img/AlgoTank_jNegativo.JPG");
		auxiliar(vista,tanque);
		
		ControladorJuego.getInstancia().agregarKeyPressObservador(vista);
		
		//creo la segunda vista
		VistaDeTextoDeAlgoTank observador = new VistaDeTextoDeAlgoTank(tanque);
		TextoDinamico vista2 = new TextoDinamico(observador);
		PuntoParaTexto pptexto2 = new PuntoParaTexto(new Posicion(602,15));
		vista2.setColor(Color.black);
		auxiliar(vista2,pptexto2);
	}
	
	public static void construirVista(BonusVelocidad bonus){
		VistaParaImagen vista = new VistaParaImagen("img/Bonus.JPG");
		vista.setPrioridad(2);
		auxiliar(vista,bonus);
	}
	
	public static void construirVista(BonusVida bonus){
		VistaParaImagen vista = new VistaParaImagen("img/BonusVida.JPG");
		vista.setPrioridad(2);
		auxiliar(vista,bonus);
	}
	
	public static void construirVista(GrizzlyBattleTank tanque){
		VistaImagenConOrientacion vista = 
				new VistaImagenConOrientacion("img/GrizzlyBattleTank_i.JPG",
						"img/GrizzlyBattleTank_iNegativo.JPG",
						"img/GrizzlyBattleTank_j.JPG", 
						"img/GrizzlyBattleTank_jNegativo.JPG");
		auxiliar(vista,tanque);
	}
	
	public static void construirVista(IFV tanque){
		VistaImagenConOrientacion vista = 
				new VistaImagenConOrientacion("img/IFV_i.JPG",
						"img/IFV_iNegativo.JPG",
						"img/IFV_j.JPG", 
						"img/IFV_jNegativo.JPG");
		auxiliar(vista,tanque);
	}
	
	public static void construirVista(MirageTank tanque){
		VistaImagenConOrientacion vista = 
				new VistaImagenConOrientacion("img/MirageTank_i.JPG",
						"img/MirageTank_iNegativo.JPG",
						"img/MirageTank_j.JPG", 
						"img/MirageTank_jNegativo.JPG");
		auxiliar(vista,tanque);
	}
	
	/**
	 * Construye las vistas de inicio y final de juego.
	 * @param nivel
	 */
	public static void construirVista(Nivel nivel){
		VistaInicioDeJuego vista1 = new VistaInicioDeJuego();
		//PuntoParaTexto pptexto = new PuntoParaTexto(new Posicion(150,200));
		//vista1.setColor(Color.black);
		//auxiliar(vista1,pptexto);
		ControladorJuego.getInstancia().agregarDibujable(vista1);
		ControladorJuego.getInstancia().agregarKeyPressObservador(vista1);
		
		
		VistaDeFinalizacionDeJuego observante = new VistaDeFinalizacionDeJuego(nivel);
		TextoDinamico vista2 = new TextoDinamico(observante);
		PuntoParaTexto pptexto2 = new PuntoParaTexto(new Posicion(100,200));
		vista2.setColor(Color.red);
		vista2.setTamanioFuente(50);
		auxiliar(vista2,pptexto2);
		
		
		
		
	}
		
}

/**
 * 
 */
package ar.uba.fi.algo3;

import java.util.ArrayList;
import java.util.Random;

import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.GrizzlyBattleTank;
import ar.uba.fi.algo3.modelo.tanques.IFV;
import ar.uba.fi.algo3.modelo.tanques.MirageTank;
import ar.uba.fi.algo3.modelo.tanques.TanqueEnemigo;

/**
 * @author jc
 *
 */
public class Fabricador {
	
	private int contador;
	private int limitePuntos;
	private ArrayList<Integer>posiciones;
	private ArrayList<TanqueEnemigo> flota;
	private int cantidadMaximaDeEnemigosEnPantalla;
	
	
	Fabricador(int limitePuntos){
		this.contador = 0;
		this.limitePuntos = limitePuntos;
		
		this.posiciones = new ArrayList<Integer>();
		for (int i=0 ;i<600 ;i++){
			this.posiciones.add(i);
			}
		this.flota = new ArrayList<TanqueEnemigo>();
		this.cantidadMaximaDeEnemigosEnPantalla = 4;
		
		}

	public void fabricarTanquesEnemigos(){
		
		if (this.alguienVivo(this.flota) == false){
			
			Random random = new Random();
			int cantDeTanques = random.nextInt(this.cantidadMaximaDeEnemigosEnPantalla);
			
			for (int i=0;i<cantDeTanques;i++){
				
				Posicion posicion = this.generarPosicionAleatoria();
				TanqueEnemigo tanque = this.generarTanqueAleatorio(posicion);
				
				while (Espacio.getInstancia().incluyeA(tanque) == false ){
					
					
					posicion = this.generarPosicionAleatoria();
					tanque = this.generarTanqueAleatorio(posicion);
					
				}
				flota.add(tanque);
				this.contador+= tanque.getPuntosPorDestruccion();
				if(this.contador>this.limitePuntos){
					break;
				}
			}
		}
	}

	private TanqueEnemigo generarTanqueAleatorio(Posicion posicion) {
		Random random = new Random();
		int numero = random.nextInt(3);
		switch (numero){
			case 0 :
				return (TanqueEnemigo)new IFV(posicion);
			case 1:
				return (TanqueEnemigo)new GrizzlyBattleTank(posicion);
			case 2:
				return (TanqueEnemigo)new MirageTank(posicion);
				
		}
		return null;
		
		
	}
	private Posicion generarPosicionAleatoria(){
		Random random = new Random();
		int numero1 = random.nextInt(600); 
		int numero2 = random.nextInt(600);
		Posicion posicion = new Posicion(posiciones.get(numero1),posiciones.get(numero2));
		
		return posicion;
	}
	private boolean alguienVivo(ArrayList<TanqueEnemigo> flota){
		
		for(int i=0;i<flota.size();i++){
			if (flota.get(i).isVivo() == true){
				return true;
			}
		}
		
		return false;
	}
}

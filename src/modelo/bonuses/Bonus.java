package modelo.bonuses;

import modelo.armamentista.disparo.Disparo;
import modelo.clasesGeneralizadoras.ObjetoJuego;
import modelo.manejoEspacial.OcupacionCuadrada;
import modelo.manejoEspacial.Posicion;


public abstract class Bonus extends ObjetoJuego {
	
	Bonus(Posicion posicion){
		int lado = 2; 
		ocupacion = new OcupacionCuadrada(posicion,lado);
	}
	
	//no hace nada si choca con un disparo
	@Override 
	public void chocarConDisparo(Disparo disparo){}
	
	@Override
	public boolean estaEnContactoCon(ObjetoJuego objeto) {
		return (objeto.getOcupacion().coincidenciaOcupacionalCon(ocupacion));
	}
	
	
	
}

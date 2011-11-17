package modelo.tanques;

import modelo.armamentista.arma.Canion;
import modelo.estrategias.estrategiasMovimiento.AlcanzarObjetivoBordes;
import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.Posicion;

public class IFV extends TanqueEnemigo {

	public IFV(Posicion puntoMenorModulo) {
		super(puntoMenorModulo);
		arma = new Canion(this,25);
		estrategiaMovimiento = new AlcanzarObjetivoBordes(this,Espacio.getInstancia().getCuartelArgentino());
		puntosPorDestruccion = 30;
		velocidad = 3;
		velocidadDisparo = 8;
	}
	
}

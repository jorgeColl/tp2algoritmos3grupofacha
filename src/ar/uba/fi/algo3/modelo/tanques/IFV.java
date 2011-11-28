package modelo.tanques;

import modelo.armamentista.arma.Canion;
import modelo.estrategias.estrategiasMovimiento.AlcanzarObjetivoBordes;
import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.Posicion;

public class IFV extends TanqueEnemigo {

	public IFV(Posicion punto) {
		super(punto);
		arma = new Canion(this,25);
		estrategiaMovimiento = new AlcanzarObjetivoBordes(this,Espacio.getInstancia().getCuartelArgentino());
		puntosPorDestruccion = 30;
		velocidad = 3;
		velocidadDisparo = 8;
	}
	
	/**
	 * Al comportamiento de la clase ancestro, sumamos el otorgar las armas a la instancia de AlgoTank del espacio.
	 */
	public void desaparecer() {
		super.desaparecer();
		if (!(Espacio.getInstancia().getTanqueJugador() == null))
			Espacio.getInstancia().getTanqueJugador().incrementarMunicionCanion(((Canion)arma).getMunicion());
	}
	
}
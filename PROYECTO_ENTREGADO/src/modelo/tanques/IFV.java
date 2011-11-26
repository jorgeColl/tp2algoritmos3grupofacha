package modelo.tanques;

import modelo.armamentista.arma.ArmaMunicionLimitada;
import modelo.armamentista.arma.Canion;
import modelo.clasesGeneralizadoras.ObjetoJuego;
import modelo.estrategias.estrategiasMovimiento.AlcanzarObjetivoBordes;
import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.Posicion;

public class IFV extends TanqueEnemigo {

	public IFV(Posicion punto) {
		super(punto);
		arma = new Canion(this,25);
		if (!(Espacio.getInstancia().getCuartelArgentino() == null))
			indicarObjetivo(Espacio.getInstancia().getCuartelArgentino());
		puntosPorDestruccion = 30;
		velocidad = 3;
		velocidadDisparo = 8;
	}
	
	public void indicarObjetivo(ObjetoJuego objeto) {
		estrategiaMovimiento = new AlcanzarObjetivoBordes(this,objeto);
	}
	
	/**
	 * Al comportamiento de la clase ancestro, sumamos el otorgar las armas a la instancia de AlgoTank del espacio.
	 * Es casteo es type-safe porque el arma es siempre una instancia de Canion.
	 */
	public void desaparecer() {
		super.desaparecer();
		if (!(Espacio.getInstancia().getTanqueJugador() == null))
			Espacio.getInstancia().getTanqueJugador().entregarArma((ArmaMunicionLimitada)arma);
	}
	
}
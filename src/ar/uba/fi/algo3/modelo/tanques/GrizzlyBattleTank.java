package ar.uba.fi.algo3.modelo.tanques;

import ar.uba.fi.algo3.vista.ConstructorVista;
import ar.uba.fi.algo3.modelo.armamentista.arma.Ametralladora;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.modelo.estrategias.estrategiasMovimiento.AlcanzarObjetivo;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;

public class GrizzlyBattleTank extends TanqueEnemigo {

	public GrizzlyBattleTank(Posicion punto) {
		super(punto);
		arma = new Ametralladora(this);
		if (!(Espacio.getInstancia().getTanqueJugador() == null))
			indicarObjetivo(Espacio.getInstancia().getTanqueJugador());
		puntosPorDestruccion = 20;
		velocidad = 1;
		velocidadDisparo = 1;
		tipo = "grizzly";
		
		if (Espacio.getInstancia().incluyeA(this)){
			ConstructorVista.construirVista(this);
		}
	}

	public void indicarObjetivo(ObjetoJuego objeto) {
		estrategiaMovimiento = new AlcanzarObjetivo(this,objeto);
	}

}

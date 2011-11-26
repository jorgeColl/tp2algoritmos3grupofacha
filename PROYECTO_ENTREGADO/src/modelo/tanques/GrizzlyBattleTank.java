package modelo.tanques;

import modelo.armamentista.arma.Ametralladora;
import modelo.clasesGeneralizadoras.ObjetoJuego;
import modelo.estrategias.estrategiasMovimiento.AlcanzarObjetivo;
import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.Posicion;

public class GrizzlyBattleTank extends TanqueEnemigo {

	public GrizzlyBattleTank(Posicion punto) {
		super(punto);
		arma = new Ametralladora(this);
		if (!(Espacio.getInstancia().getTanqueJugador() == null))
			indicarObjetivo(Espacio.getInstancia().getTanqueJugador());
		puntosPorDestruccion = 20;
		velocidad = 1;
		velocidadDisparo = 4;
	}

	public void indicarObjetivo(ObjetoJuego objeto) {
		estrategiaMovimiento = new AlcanzarObjetivo(this,objeto);
	}

}

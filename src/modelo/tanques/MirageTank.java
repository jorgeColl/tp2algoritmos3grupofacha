package modelo.tanques;

import modelo.armamentista.arma.Canion;
import modelo.manejoEspacial.Posicion;

public class MirageTank extends TanqueEnemigo {

	public MirageTank(Posicion puntoMenorModulo) {
		super(puntoMenorModulo);
		arma = new Canion(this,25);
		puntosPorDestruccion = 50;
		velocidad = 2;
	}

}

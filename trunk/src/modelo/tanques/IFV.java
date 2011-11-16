package modelo.tanques;

import modelo.armamentista.arma.LanzaCohetes;
import modelo.manejoEspacial.Posicion;

public class IFV extends TanqueEnemigo {

	public IFV(Posicion puntoMenorModulo) {
		super(puntoMenorModulo);
		arma = new LanzaCohetes(this,25);
		puntosPorDestruccion = 30;
		velocidad = 2;
	}
	
}

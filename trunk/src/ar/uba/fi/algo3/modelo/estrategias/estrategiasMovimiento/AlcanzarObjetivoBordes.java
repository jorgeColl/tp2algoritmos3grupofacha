package ar.uba.fi.algo3.modelo.estrategias.estrategiasMovimiento;

import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoMovil;

/**
 * Le indica al objeto móvil que se acerque a su objetivo por los bordes.
 * Cuando empieza el juego el objeto comienza a moverse hacia el borde lateral más cercano.
 * Una vez allí busca acercarse verticalmente a su objetivo.
 * Cuando ya está verticalmente coincidente a su objetivo se orienta hacia él.
 * Cuando el objeto móvil pierde la coincidencia vertical con su objetivo vuelve a buscarla.
 * @author Tomás
 *
 */
public class AlcanzarObjetivoBordes extends EstrategiaMovimiento {
	
	public AlcanzarObjetivoBordes(ObjetoMovil duenio, ObjetoJuego objetivo) {
		super(duenio,objetivo);
	}

	public void dedicirMovimiento() {
		if (!(duenio.getOcupacion().estaEnBordeHorizontal()))
			duenio.acercarseAlBordeLateralMasCercano();
		else {
			indicarDuenioAcercarseVerticalmenteAObjetivo();
			if (duenio.getOcupacion().coincidenciaProyeccionVerticalCon(objetivo.getOcupacion()))
				orientarDuenioHorizontalmenteHaciaObjetivo();
		}
	}
	
}

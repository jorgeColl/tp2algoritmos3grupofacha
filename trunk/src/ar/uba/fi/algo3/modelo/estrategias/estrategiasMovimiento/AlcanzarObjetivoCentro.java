package ar.uba.fi.algo3.modelo.estrategias.estrategiasMovimiento;

import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoMovil;

/**
 * Le indica al objeto móvil que se acerque a su objetivo por el centro.
 * Primero le indicamos al objeto que se dirija al centro del espacio.
 * Luego que comience a moverse verticalmente hasta que coincida en dicho eje con su objetivo.
 * Finalmente que se oriente hacia el, y que si este sale de la posición coincidente verticalmente que vuelva a buscarla.
 * @author Tomás
 *
 */
public class AlcanzarObjetivoCentro extends EstrategiaMovimiento {

	public AlcanzarObjetivoCentro(ObjetoMovil duenio, ObjetoJuego objetivo) {
		super(duenio,objetivo);
	}

	public void dedicirMovimiento() {
		if (!(duenio.getOcupacion().estaEnCentroHorizontal()))
			duenio.acercarseAlCentroHorizontalDelEspacio();
		else {
			indicarDuenioAcercarseVerticalmenteAObjetivo();
			if (duenio.getOcupacion().coincidenciaProyeccionVerticalCon(objetivo.getOcupacion()))
				orientarDuenioHorizontalmenteHaciaObjetivo();
		}
	}
	
}

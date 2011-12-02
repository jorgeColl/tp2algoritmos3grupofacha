package ar.uba.fi.algo3.modelo.estrategias.estrategiasMovimiento;

import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoMovil;

/**
 * Otorga comportamiento a los objetos moviles que buscan llegar 
 * a un objetivo sin especificaciones de direccion.
 * Para esto tiene un contador que le permite ir alternando el 
 * moverse horizontal y verticalmente.
 * @author Tomas
 *
 */
public class AlcanzarObjetivo extends EstrategiaMovimiento {

	private int contador;
	
	public AlcanzarObjetivo(ObjetoMovil duenio, ObjetoJuego objetivo) {
		super(duenio, objetivo);
		contador = 0;
	}

	/**
	 * Cuando el contador es 0, prioriza el movimiento horizontal 
	 * hacia el objetivo (si no tiene sentido realizar tal movimiento 
	 * realiza el opuesto).
	 * Cuando el contador es 1, prioriza el movimiento vertical hacia 
	 * el objetivo (si no tiene sentido realizar tal movimiento realiza 
	 * el opuesto).
	 */
	public void dedicirMovimiento() {
		if (contador == 2)
			contador = 0;
		if (contador == 0) {
			if (!(duenio.getOcupacion().
					coincidenciaProyeccionHorizontalCon(objetivo.getOcupacion())))
				indicarDuenioAcercarseHorizontalmenteAObjetivo();
			else
				indicarDuenioAcercarseVerticalmenteAObjetivo();
		}
		if (contador == 1) {
			if (!(duenio.getOcupacion().
					coincidenciaProyeccionVerticalCon(objetivo.getOcupacion())))
				indicarDuenioAcercarseVerticalmenteAObjetivo();
			else
				indicarDuenioAcercarseHorizontalmenteAObjetivo();
		}
		++contador;
	}

}

package modelo;

/**
 * Implementa la inferfaz Ocupacion, modelando concretamente a una ocupaci�n bidimensional cuadrada.
 * El atributo puntoMenorModulo representa al punto del cuadrado m�s cercano al origen.
 * El atributo lado representa a la longitud del lado del cuadrado.
 * @author Tom�s
 *
 */
public class OcupacionCuadrada implements Ocupacion {

	private Posicion puntoMenorModulo;
	private int lado;
	
	/**
	 * Constructor.
	 * @param puntoMenorModulo objeto con el que se inicializar� el atributo centro puntoMenorModulo
	 * @param lado entero con el que se inicializar� el atributo lado
	 */
	public OcupacionCuadrada(Posicion puntoMenorModulo, int lado) {
		this.puntoMenorModulo = puntoMenorModulo;
		this.lado = lado;
	}
	
	/**
	 * Utiliza dos m�todos privados para simplificar tests booleanos.
	 */
	@Override
	public boolean coincidenciaOcupacionalCon(OcupacionCuadrada ocupacion) {
		if ((this.coincidenciaOcupacionalHorizotal(ocupacion))&&(this.coincidenciaOcupacionalVertical(ocupacion)))
			return true;
		return false;
	}

	/**
	 * 
	 * @param ocupacion instancia de la clase OcupacionCuadrada con respecto a la cual compararemos a esta
	 * @return true si las proyecciones ortogonales en el eje x de esta ocupacion y de la del parametro tienen puntos en comun 
	 */
	private boolean coincidenciaOcupacionalHorizotal(OcupacionCuadrada ocupacion) {
		if ((puntoMenorModulo.getX()+(lado-1)) >= (ocupacion.getPuntoMenorModulo().getX())) {
			if ((puntoMenorModulo.getX()) <= (ocupacion.getPuntoMenorModulo().getX()+(ocupacion.getLado()-1)))
				return true;
		}
		return false;		
	}
	
	/**
	 * @see comentario del metodo coincidenciaOcupacionalHorizotal(OcupacionCuadrada ocupacion)
	 */
	private boolean coincidenciaOcupacionalVertical(OcupacionCuadrada ocupacion) {
		if ((puntoMenorModulo.getY()+(lado-1)) >= (ocupacion.getPuntoMenorModulo().getY())) {
			if ((puntoMenorModulo.getY()) <= (ocupacion.getPuntoMenorModulo().getY()+(ocupacion.getLado()-1)))
				return true;
		}
		return false;		
	}
	
	
	/**
	 * 
	 * @return atributo lado
	 */
	public int getLado() {
		return lado;
	}
	
	/**
	 * 
	 * @return atributo puntoMenorModulo
	 */
	public Posicion getPuntoMenorModulo() {
		return puntoMenorModulo;
	}	

}
package modelo.manejoEspacial;

/**
 * Implementa la inferfaz Ocupacion, modelando concretamente a una ocupación bidimensional cuadrada.
 * El atributo puntoMenorModulo representa al punto del cuadrado más cercano al origen.
 * El atributo lado representa a la longitud del lado del cuadrado.
 * @author Tomás
 *
 */
public class OcupacionCuadrada implements Ocupacion {

	private int lado;
	private Posicion puntoMenorModulo;
		
	/**
	 * Constructor.
	 * @param puntoMenorModulo objeto con el que se inicializará el atributo centro puntoMenorModulo
	 * @param lado entero con el que se inicializará el atributo lado
	 */
	public OcupacionCuadrada(Posicion puntoMenorModulo, int lado) {
		this.puntoMenorModulo = puntoMenorModulo;
		this.lado = lado;
	}
	
	/**
	 * Utiliza dos métodos privados para simplificar tests booleanos.
	 */

	@Override
	public boolean coincidenciaOcupacionalCon(Ocupacion ocupacion) {
		return (ocupacion.compararConOcupacionCuadrada(this));
	}

	/**
	 * Utiliza dos métodos privados para simplificar tests booleanos.
	 */
	@Override
	public boolean compararConOcupacionCuadrada(OcupacionCuadrada ocupacion) {
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
	
	@Override
	public boolean espacialmenteValida() {
		if (puntoMenorModulo.getX() < 0)
			return false;
		if ((puntoMenorModulo.getX()+(lado-1)) > Espacio.getInstancia().getLimiteDerecho())
			return false;
		if (puntoMenorModulo.getY() < 0)
			return false;
		if ((puntoMenorModulo.getY()+(lado-1)) > Espacio.getInstancia().getLimiteInferior())
			return false;
		return true;
	}	
	
	/**
	 * 
	 * @return atributo lado
	 */
	public int getLado() {
		return lado;
	}
	
	@Override
	public Posicion getPosicionPerimetralCentradaEnOrientacion(Orientacion orientacion) {
		//INICIALIZACION CORRESPONDIENTE A SI EL PARÁMETRO ES Orientacion.i, SI ES OTRA SE LA CAMBIARÁ LUEGO.
		//RAZÓN DE COMPILACIÓN
		Posicion posicionAuxiliar = new Posicion(puntoMenorModulo.getX()+lado,puntoMenorModulo.getY()+Math.round(lado/2));
		if (orientacion == Orientacion.iNegativo)
			posicionAuxiliar = new Posicion(puntoMenorModulo.getX()-1,puntoMenorModulo.getY()+Math.round(lado/2));
		else {
			if (orientacion == Orientacion.j)
				posicionAuxiliar = new Posicion(puntoMenorModulo.getX()+Math.round(lado/2),puntoMenorModulo.getY()-1);
			else {
				if (orientacion == Orientacion.jNegativo)
					posicionAuxiliar = new Posicion(puntoMenorModulo.getX()+Math.round(lado/2),puntoMenorModulo.getY()+lado);	
			}
		}
		return posicionAuxiliar;
	}
	
	/**
	 * 
	 * @return atributo puntoMenorModulo
	 */
	public Posicion getPuntoMenorModulo() {
		return puntoMenorModulo;
	}

	public Ocupacion getOcupacionMovidaAbajo() {
		Posicion puntoAuxiliar = new Posicion(puntoMenorModulo.getX(),puntoMenorModulo.getY()+1);
		return (new OcupacionCuadrada(puntoAuxiliar,lado));
	}
	
	public Ocupacion getOcupacionMovidaArriba() {
		Posicion puntoAuxiliar = new Posicion(puntoMenorModulo.getX(),puntoMenorModulo.getY()-1);
		return (new OcupacionCuadrada(puntoAuxiliar,lado));
	}

	public Ocupacion getOcupacionMovidaDerecha() {
		Posicion puntoAuxiliar = new Posicion(puntoMenorModulo.getX()+1,puntoMenorModulo.getY());
		return (new OcupacionCuadrada(puntoAuxiliar,lado));
	}

	public Ocupacion getOcupacionMovidaIzquierda() {
		Posicion puntoAuxiliar = new Posicion(puntoMenorModulo.getX()-1,puntoMenorModulo.getY());
		return (new OcupacionCuadrada(puntoAuxiliar,lado));
	}
	
}
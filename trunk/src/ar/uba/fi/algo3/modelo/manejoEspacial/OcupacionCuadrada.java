package ar.uba.fi.algo3.modelo.manejoEspacial;

/**
 * Implementa la inferfaz Ocupacion, modelando concretamente a una ocupación 
 * bidimensional cuadrada.
 * El atributo puntoMenorModulo representa al punto del cuadrado más cercano 
 * al origen.
 * El atributo lado representa a la longitud del lado del cuadrado.
 * @author Samanta
 *
 */
public class OcupacionCuadrada implements Ocupacion {

	private int lado;
	private Posicion puntoMenorModulo;
		
	/**
	 * Constructor.
	 * @param puntoMenorModulo objeto con el que se inicializará el atributo 
	 * puntoMenorModulo
	 * @param lado entero con el que se inicializará el atributo lado
	 */
	public OcupacionCuadrada(Posicion puntoMenorModulo, int lado) {
		this.puntoMenorModulo = puntoMenorModulo;
		this.lado = lado;
	}
	
	/**
	 * Le indicamos al parámetro que se compare con una ocupación cuadrada, y 
	 * le pasamos esta instancia como parámetro.
	 */
	public boolean coincidenciaOcupacionalCon(Ocupacion ocupacion) {
		return (ocupacion.compararConOcupacionCuadrada(this));
	}
	
	public boolean coincidenciaProyeccionHorizontalCon(Ocupacion ocupacion) {
		if (getLimiteDerecho() >= ocupacion.getLimiteIzquierdo()) {
			if (getLimiteIzquierdo() <= ocupacion.getLimiteDerecho())
				return true;
		}
		return false;
	}
	
	public boolean coincidenciaProyeccionVerticalCon(Ocupacion ocupacion) {
		if (getLimiteInferior() >= ocupacion.getLimiteSuperior()) {
			if (getLimiteSuperior() <= ocupacion.getLimiteInferior())
				return true;
		}
		return false;
	}

	/**
	 * Delegamos en dos métodos que simplifican test booleanos.
	 */
	public boolean compararConOcupacionCuadrada(OcupacionCuadrada ocupacion) {
		if (coincidenciaProyeccionHorizontalCon(ocupacion)) {
			if (coincidenciaProyeccionVerticalCon(ocupacion))
				return true;
		}
		return false;
	}
	
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
	 * Delego en dos métodos propios.
	 */
	public boolean estaEnBorde() {
		return ((estaEnBordeHorizontal())||(estaEnBordeVertical()));
	}
	
	
	public boolean estaEnBordeHorizontal() {
		if (getLimiteDerecho() == Espacio.getInstancia().getLimiteDerecho())
			return true;
		if (getLimiteIzquierdo() == 0)
			return true;
		return false;
	}
	
	public boolean estaEnBordeVertical() {
		if (getLimiteInferior() == Espacio.getInstancia().getLimiteInferior())
			return true;
		if (getLimiteSuperior() == 0)
			return true;
		return false;
	}

	public boolean estaEnCentroHorizontal() {
		if (getLimiteIzquierdo() <= (Espacio.getInstancia().getLimiteDerecho()/2)) {
			if (getLimiteDerecho() >= (Espacio.getInstancia().getLimiteDerecho()/2))
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
	
	/* Utilizamos este método (en principio) para crear instancias de disparos 
	 * cuadrados centrados con respecto a su tanque, dado que esto depende del 
	 * lado de los disparos y este no es accesible por el constructor tradicional.*/
	/**
	 * Devuelve una intancia de OcupacionCuadrada que fue construída a partir 
	 * de una posicion perimetral centrada en la orientación de un objeto con 
	 * respecto al cual queremos que esta ocupación esté continua y centrada.
	 * @param posicion instancia de la clase posicion que representa la posición 
	 *  perimetral centrada en la orientación del disparo
	 * @param lado entero representante de lado que se quiere que tenga el disparo
	 * @param orientacion instancia de la clase Orientacion que representa la 
	 *  orientacion con la que viajará el disparo
	 * @return instancia de la clase OcupacionCuadrada con las características 
	 *  analizadas
	 */
	public static OcupacionCuadrada crearAPartirDePosicionPerimetralCentradaEnOrientacion(Posicion posicion, int lado, Orientacion orientacion) {
		Posicion puntoMenorModulo;
		if (orientacion == Orientacion.i)
			puntoMenorModulo = new Posicion(posicion.getX(),posicion.getY()-(lado/2));
		else {
			if (orientacion == Orientacion.iNegativo)
				puntoMenorModulo = new Posicion(posicion.getX()-lado+1,posicion.getY()-(lado/2));
			else {
				if (orientacion == Orientacion.j)
					puntoMenorModulo = new Posicion(posicion.getX()-(lado/2),posicion.getY()-lado+1);
				else {
					puntoMenorModulo = new Posicion(posicion.getX()-(lado/2),posicion.getY());
				}
			}
		}
		return new OcupacionCuadrada(puntoMenorModulo,lado);
	}
	
	public Posicion getPosicionPerimetralCentradaEnOrientacion(Orientacion orientacion) {
		//INICIALIZACION CORRESPONDIENTE A SI EL PARÁMETRO ES Orientacion.i, SI ES OTRA SE LA CAMBIARÁ LUEGO.
		//RAZÓN DE COMPILACIÓN
		Posicion posicionAuxiliar = new Posicion(puntoMenorModulo.getX()+lado,puntoMenorModulo.getY()+(lado/2));
		if (orientacion == Orientacion.iNegativo)
			posicionAuxiliar = new Posicion(puntoMenorModulo.getX()-1,puntoMenorModulo.getY()+(lado/2));
		else {
			if (orientacion == Orientacion.j)
				posicionAuxiliar = new Posicion(puntoMenorModulo.getX()+(lado/2),puntoMenorModulo.getY()-1);
			else {
				if (orientacion == Orientacion.jNegativo)
					posicionAuxiliar = new Posicion(puntoMenorModulo.getX()+(lado/2),puntoMenorModulo.getY()+lado);	
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

	public int getLimiteDerecho() {
		return (puntoMenorModulo.getX() + lado - 1);
	}

	public int getLimiteInferior() {
		return (puntoMenorModulo.getY() + lado - 1);
	}

	public int getLimiteIzquierdo() {
		return (puntoMenorModulo.getX());
	}

	public int getLimiteSuperior() {
		return (puntoMenorModulo.getY());
	}

}
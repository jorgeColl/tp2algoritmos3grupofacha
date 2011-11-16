package modelo.armamentista.disparo;

import java.util.Vector;

import modelo.clasesGeneralizadoras.ObjetoJuego;
import modelo.clasesGeneralizadoras.ObjetoMovil;
import modelo.clasesGeneralizadoras.ObjetoVivo;
import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.Ocupacion;
import modelo.manejoEspacial.Orientacion;
import modelo.manejoEspacial.Posicion;
import modelo.tanques.Tanque;

/**
 * Modela un disparo que se mueve por el escenario hasta salir de este o impactar con una instancia de ObjetoJuego, caus�ndole un da�o. 
 * @author Tom�s
 *
 */
public abstract class Disparo extends ObjetoMovil implements ObjetoVivo {
	
	protected int danioNeto;
	protected int danioPorcentual;
	
	/**
	 * Constructor.
	 * @param orientacion versor representante de la direcci�n del disparo
	 * @param punto posici�n de la ocupaci�n del disparo m�s cercana al tanque que lo ha disparado y centrada en la misma sobre el eje de movimiento de este
	 */
	public Disparo(Orientacion orientacion, Posicion punto) {
		this.orientacion = orientacion;
	}
	
	/**
	 * En este caso, si la ocupaci�n no es v�lida, el disparo ha salido de los l�mites de la pantalla y por lo tanto desaparece.
	 */
	protected void chequearOcupacionValidaYColisiones(Ocupacion ocupacionProvisoria) {
		if ((ocupacionProvisoria.espacialmenteValida())) {
			ocupacion = ocupacionProvisoria;
			Vector<ObjetoJuego> objetos = Espacio.getInstancia().getObjetosJuegoEnContactoCon(this);
			int contador = 0;
			while (contador < objetos.size()) {
				objetos.get(contador).chocarConDisparo(this);
				++contador;
			}
		}
		else
			desaparecer();
	}
	
	/**
	 * Cuando dos disparon chocan ambos desaparecen.
	 */
	@Override
	public void chocarConDisparo(Disparo disparo) {
		disparo.desaparecer();
		desaparecer();
	}
	
	/**
	 * Le indicamos al tanque que ha sido chocado por este disparo, y hacemos que este �ltimo desaparezca.
	 */
	@Override
	public void chocarConTanque(Tanque tanque) {
		tanque.chocarConDisparo(this);
		desaparecer();
	}
	
	public boolean estaEnContactoCon(ObjetoJuego objeto) {
		return (objeto.getOcupacion().coincidenciaOcupacionalCon(ocupacion));
	}
	
	/**
	 * 
	 * @return atributo danioNeto
	 */
	public int getDanioNeto() {
		return danioNeto;
	}
	
	/**
	 * 
	 * @return atributo danioPorcentual
	 */
	public int getDanioPorcentual() {
		return danioPorcentual;
	}
	
	/**
	 * M�todo usado internamente para calcular la posici�n con la que se crea la ocupaci�n del disparo, dado que la misma tiene que estar centrada con respecto al tanque que la dispara, y para esto tiene que tener en cuenta el radio del disparo.
	 * @return posicion con la que se crea la ocupaci�n del objeto
	 */
	protected Posicion obtenerPuntoMenorModuloDisparo(Orientacion orientacion, Posicion puntoReferencia, int lado) {
		//INICIALIZACI�N POR DEFECTO SUPONIENDO QUE LA ORIENTACI�N ES Orientacion.i
		//SI NO LO ES LUEGO SE CAMBIA.
		Posicion posicionAuxiliar = new Posicion(puntoReferencia.getX(),(int)(puntoReferencia.getY()-Math.floor(lado/2)));
		if (orientacion == Orientacion.iNegativo)
			posicionAuxiliar = new Posicion(puntoReferencia.getX()-lado+1,(int)(puntoReferencia.getY()-Math.floor(lado/2)));
		else {
			if (orientacion == Orientacion.j)
				posicionAuxiliar = new Posicion((int)(puntoReferencia.getY()-Math.floor(lado/2)),puntoReferencia.getY()-lado+1);
			else {
				if (orientacion == Orientacion.jNegativo)
					posicionAuxiliar = new Posicion((int)(puntoReferencia.getY()-Math.floor(lado/2)),puntoReferencia.getY());
			}		
		} 
		return posicionAuxiliar;
	}
	
	public void vivir() {
		int contador = 0;
		if (orientacion == Orientacion.i)
			moverDerecha();
		else {
			if (orientacion == Orientacion.iNegativo)
				moverIzquierda();
			else {
				if (orientacion == Orientacion.j)
					moverArriba();
				else {
					moverAbajo();
				}
			}
		}
	}
	
}

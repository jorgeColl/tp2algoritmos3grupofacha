package pruebas.pruebasUnitarias;

import modelo.armamentista.arma.LanzaCohetes;
import modelo.estrategias.estrategiasDisparo.EstrategiaDisparoVelocidadDependiente;
import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.Posicion;
import modelo.tanques.MirageTank;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase EstrategiaDisparoAlgoTank.
 * @author Tomás
 *
 */
public class PruebasEstrategiaDisparoVelocidadDependiente extends TestCase {

	private MirageTank duenio;
	private EstrategiaDisparoVelocidadDependiente estrategia;
	
	protected void setUp() throws Exception {
		super.setUp();
		Espacio.getInstancia().reiniciar();
		duenio = new MirageTank(new Posicion(250,250));
		estrategia = new EstrategiaDisparoVelocidadDependiente(duenio);
	}
	
	/**
	 * Chequeo que hasta que no transcurra el tiempo necesario el tanque no dispare.
	 * @throws Exception 
	 */
	public void testTiempoTranscurridoHastaPrimerDisparo() throws Exception {
		assertEquals(((LanzaCohetes)duenio.getArma()).getMunicion(),25);
		estrategia.informarTranscursoTiempo();
		estrategia.decidirDisparo();
		assertEquals(((LanzaCohetes)duenio.getArma()).getMunicion(),25);
		estrategia.informarTranscursoTiempo();
		estrategia.decidirDisparo();
		assertEquals(((LanzaCohetes)duenio.getArma()).getMunicion(),25);
		estrategia.informarTranscursoTiempo();
		estrategia.decidirDisparo();
		assertEquals(((LanzaCohetes)duenio.getArma()).getMunicion(),25);
		estrategia.informarTranscursoTiempo();
		estrategia.decidirDisparo();
		assertEquals(((LanzaCohetes)duenio.getArma()).getMunicion(),25);
		estrategia.informarTranscursoTiempo();
		estrategia.decidirDisparo();
		assertEquals(((LanzaCohetes)duenio.getArma()).getMunicion(),25);
		estrategia.informarTranscursoTiempo();
		estrategia.decidirDisparo();
		assertEquals(((LanzaCohetes)duenio.getArma()).getMunicion(),25);
		estrategia.informarTranscursoTiempo();
		estrategia.decidirDisparo();
		assertEquals(((LanzaCohetes)duenio.getArma()).getMunicion(),25);
		//A PARTIR DE AQUÍ YA PUEDE DISPARAR.
		estrategia.informarTranscursoTiempo();
		estrategia.decidirDisparo();
		assertEquals(((LanzaCohetes)duenio.getArma()).getMunicion(),24);
	}
	
}
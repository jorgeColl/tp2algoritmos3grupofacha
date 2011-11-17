package pruebas.pruebasUnitarias;

import modelo.estrategias.estrategiasDisparo.EstrategiaDisparoAlgoTank;
import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.Posicion;
import modelo.tanques.AlgoTank;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase EstrategiaDisparoAlgoTank.
 * @author Tomás
 *
 */
public class PruebasEstrategiaDisparoAlgoTank extends TestCase {

	private AlgoTank duenio;
	private EstrategiaDisparoAlgoTank estrategia;
	
	protected void setUp() throws Exception {
		super.setUp();
		Espacio.getInstancia().reiniciar();
		duenio = new AlgoTank(new Posicion(250,250));
		estrategia = new EstrategiaDisparoAlgoTank(duenio);
	}
	
	/**
	 * Otorgo al duenio municiones de LanzaCohetes y chequeo que dispare prioritariamente a esta arma, cuando su velocidad de disparo se lo permita.
	 */
	public void testDisparoLanzaCohetes() {
		duenio.incrementarMunicionLanzaCohetes(2);
		estrategia.decidirDisparo();
		assertEquals(duenio.getLanzaCohetes().getMunicion(),2);
		estrategia.informarTranscursoTiempo();
		estrategia.decidirDisparo();
		assertEquals(duenio.getLanzaCohetes().getMunicion(),2);
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		//A PARTIR DE AQUÍ YA PODRÍA DISPARAR.
		estrategia.decidirDisparo();
		assertEquals(duenio.getLanzaCohetes().getMunicion(),1);
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		//A PARTIR DE AQUÍ YA PODRÍA DISPARAR.
		estrategia.decidirDisparo();
		assertEquals(duenio.getLanzaCohetes().getMunicion(),0);
	}
	
	/**
	 * Otorgo al duenio municiones de Canion y chequeo que dispare prioritariamente a esta arma, cuando su velocidad de disparo se lo permita.
	 */
	public void testDisparoLanzaCanion() {
		duenio.incrementarMunicionCanion(2);
		estrategia.decidirDisparo();
		assertEquals(duenio.getCanion().getMunicion(),2);
		estrategia.informarTranscursoTiempo();
		estrategia.decidirDisparo();
		assertEquals(duenio.getCanion().getMunicion(),2);
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		//A PARTIR DE AQUÍ YA PODRÍA DISPARAR.
		estrategia.decidirDisparo();
		assertEquals(duenio.getCanion().getMunicion(),1);
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		//A PARTIR DE AQUÍ YA PODRÍA DISPARAR.
		estrategia.decidirDisparo();
		assertEquals(duenio.getCanion().getMunicion(),0);
	}
	
}

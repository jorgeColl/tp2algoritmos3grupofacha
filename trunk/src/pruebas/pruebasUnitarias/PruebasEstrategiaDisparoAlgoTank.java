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
	 * Otorgo al dueño del a estrategia municiones y chequeo que a medida que esta realice disparos, las municiones vayan disminuyendo en el valor esperado, lo que significa que el dueño ha disparado el arma correcta.
	 */
	public void testEstrategiaDisparoAlgoTankDecicionesCorrectas() {
		duenio.incrementarMunicionLanzaCohetes(4);
		duenio.incrementarMunicionCanion(3);
		
		assertEquals(duenio.getLanzaCohetes().getMunicion(),4);
		estrategia.decidirDisparo();
		assertEquals(duenio.getLanzaCohetes().getMunicion(),3);
		estrategia.decidirDisparo();
		assertEquals(duenio.getLanzaCohetes().getMunicion(),2);
		estrategia.decidirDisparo();
		assertEquals(duenio.getLanzaCohetes().getMunicion(),1);
		estrategia.decidirDisparo();
		assertEquals(duenio.getLanzaCohetes().getMunicion(),0);
		assertEquals(duenio.getCanion().getMunicion(),3);
		estrategia.decidirDisparo();
		assertEquals(duenio.getCanion().getMunicion(),2);
		estrategia.decidirDisparo();
		assertEquals(duenio.getCanion().getMunicion(),1);
		estrategia.decidirDisparo();
		assertEquals(duenio.getCanion().getMunicion(),0);
		estrategia.decidirDisparo();
	}

}

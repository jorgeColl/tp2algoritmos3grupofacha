package modelo;

public class Espacio {
	private static Espacio instancia;
	
	private Espacio(){
		
	}
	
	public static Espacio obtenerInstancia(){
		if (instancia == null){
			instancia = new Espacio();
		}
		return instancia;
	}
}

